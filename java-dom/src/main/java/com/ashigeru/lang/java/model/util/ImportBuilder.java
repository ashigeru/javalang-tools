/*
 * Copyright 2010 @ashigeru.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.ashigeru.lang.java.model.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ashigeru.lang.java.model.syntax.ArrayType;
import com.ashigeru.lang.java.model.syntax.BasicType;
import com.ashigeru.lang.java.model.syntax.ImportDeclaration;
import com.ashigeru.lang.java.model.syntax.ImportKind;
import com.ashigeru.lang.java.model.syntax.ModelFactory;
import com.ashigeru.lang.java.model.syntax.ModelKind;
import com.ashigeru.lang.java.model.syntax.Name;
import com.ashigeru.lang.java.model.syntax.NamedType;
import com.ashigeru.lang.java.model.syntax.PackageDeclaration;
import com.ashigeru.lang.java.model.syntax.ParameterizedType;
import com.ashigeru.lang.java.model.syntax.QualifiedName;
import com.ashigeru.lang.java.model.syntax.QualifiedType;
import com.ashigeru.lang.java.model.syntax.SimpleName;
import com.ashigeru.lang.java.model.syntax.StrictVisitor;
import com.ashigeru.lang.java.model.syntax.Type;

/**
 * {@link ImportDeclaration}を構築するビルダー。
 */
public class ImportBuilder {

    private PackageDeclaration packageDecl;

    private Resolver resolver;

    /**
     * インスタンスを生成する。
     * @param factory モデルを生成するファクトリ
     * @param packageDecl 現在のパッケージ宣言
     * @param strategy インポートを行う戦略
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public ImportBuilder(
            ModelFactory factory,
            PackageDeclaration packageDecl,
            Strategy strategy) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        if (strategy == null) {
            throw new IllegalArgumentException("strategy must not be null"); //$NON-NLS-1$
        }
        this.resolver = new Resolver(factory, strategy);
        this.packageDecl = packageDecl;
    }

    /**
     * 指定の型を可能であればインポートし、インポート後の型表現を返す。
     * @param type 対象の型
     * @return インポート後の型
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public Type resolve(Type type) {
        if (type == null) {
            throw new IllegalArgumentException("type must not be null"); //$NON-NLS-1$
        }
        return type.accept(resolver, null);
    }

    /**
     * 指定の型を可能であればインポートし、インポート後の型表現を返す。
     * @param type 対象の型
     * @return インポート後の型
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public Type toType(java.lang.reflect.Type type) {
        if (type == null) {
            throw new IllegalArgumentException("type must not be null"); //$NON-NLS-1$
        }
        return resolve(Models.toType(resolver.factory, type));
    }

    /**
     * これまでにこのビルダーでインポートしたクラスに対するインポート宣言の一覧を返す。
     * @return インポートしたクラスに対するインポート宣言の一覧
     */
    public List<ImportDeclaration> toImportDeclarations() {
        ModelFactory f = resolver.factory;
        Map<QualifiedName, SimpleName> imported = resolver.imported;
        Set<Name> implicit = createImplicit();

        List<ImportDeclaration> results = new ArrayList<ImportDeclaration>();
        for (QualifiedName name : imported.keySet()) {
            if (implicit.contains(name.getQualifier())) {
                continue;
            }
            results.add(f.newImportDeclaration(ImportKind.SINGLE_TYPE, name));
        }
        Collections.sort(results, ImportComparator.INSTANCE);
        return results;
    }

    private Set<Name> createImplicit() {
        Set<Name> implicit = new HashSet<Name>();
        implicit.add(Models.toName(resolver.factory, "java.lang"));
        if (packageDecl != null) {
            implicit.add(packageDecl.getName());
        }
        return implicit;
    }

    private enum ImportComparator implements Comparator<ImportDeclaration> {

        /**
         * 唯一のインスタンス
         */
        INSTANCE,

        ;
        @Override
        public int compare(ImportDeclaration o1, ImportDeclaration o2) {
            if (o1.getImportKind() != o2.getImportKind()) {
                return o1.getImportKind().compareTo(o2.getImportKind());
            }
            return o1.getName().toString().compareTo(o2.getName().toString());
        }
    }

    private static class Resolver extends StrictVisitor<Type, Void, NoThrow> {

        private Strategy strategy;

        Map<QualifiedName, SimpleName> imported;

        private Set<SimpleName> used;

        ModelFactory factory;

        Resolver(ModelFactory factory, Strategy strategy) {
            this.factory = factory;
            this.strategy = strategy;
            this.imported = new HashMap<QualifiedName, SimpleName>();
            this.used = new HashSet<SimpleName>();
        }

        @Override
        public Type visitArrayType(ArrayType elem, Void _) {
            Type component = elem.getComponentType().accept(this, _);
            if (elem.getComponentType().equals(component)) {
                return elem;
            }
            return factory.newArrayType(component);
        }

        @Override
        public Type visitBasicType(BasicType elem, Void _) {
            return elem;
        }

        @Override
        public Type visitNamedType(NamedType elem, Void _) {
            Name name = elem.getName();

            if (name.getModelKind() == ModelKind.SIMPLE_NAME) {
                used.add((SimpleName) name);
                return elem;
            }

            LinkedList<SimpleName> segments = new LinkedList<SimpleName>();
            name = normalize(name, segments);
            if (name.getModelKind() == ModelKind.SIMPLE_NAME) {
                used.add((SimpleName) name);
                return elem;
            }

            QualifiedName qname = (QualifiedName) name;
            SimpleName renamed = imported.get(qname);
            if (renamed == null) {
                if (used.contains(qname.getSimpleName())) {
                    return elem;
                }
                imported.put(qname, qname.getSimpleName());
                used.add(qname.getSimpleName());
            }
            return factory.newNamedType(Models.append(
                factory,
                segments.toArray(new Name[segments.size()])));
        }

        private Name normalize(
                Name name,
                LinkedList<SimpleName> segments) {
            Name current = name;
            if (strategy == Strategy.TOP_LEVEL) {
                while (isLikeEnclosingType(current)) {
                    QualifiedName qname = (QualifiedName) current;
                    segments.addFirst(qname.getSimpleName());
                    current = qname.getQualifier();
                }
            }
            if (current.getModelKind() == ModelKind.QUALIFIED_NAME) {
                segments.addFirst(((QualifiedName) current).getSimpleName());
            }
            else {
                segments.addFirst((SimpleName) current);
            }
            return current;
        }

        private boolean isLikeEnclosingType(Name name) {
            assert name != null;
            if (name.getModelKind() != ModelKind.QUALIFIED_NAME) {
                return false;
            }
            Name qualifier = ((QualifiedName) name).getQualifier();
            SimpleName parent;
            if (qualifier.getModelKind() == ModelKind.QUALIFIED_NAME) {
                parent = ((QualifiedName) qualifier).getSimpleName();
            }
            else {
                parent = (SimpleName) qualifier;
            }
            return isClassName(parent);
        }

        private boolean isClassName(SimpleName name) {
            assert name != null;
            char first = name.getToken().charAt(0);
            return Character.isUpperCase(first);
        }

        @Override
        public Type visitParameterizedType(ParameterizedType elem, Void _) {
            Type nonparameterized = elem.getType().accept(this, _);
            List<Type> arguments = new ArrayList<Type>();
            for (Type t : elem.getTypeArguments()) {
                arguments.add(t.accept(this, _));
            }
            if (nonparameterized.equals(elem.getType()) &&
                    arguments.equals(elem.getTypeArguments())) {
                return elem;
            }
            return factory.newParameterizedType(nonparameterized, arguments);
        }

        @Override
        public Type visitQualifiedType(QualifiedType elem, Void _) {
            Type qualifier = elem.getQualifier().accept(this, _);
            if (qualifier.equals(elem.getQualifier())) {
                return elem;
            }
            return factory.newQualifiedType(qualifier, elem.getSimpleName());
        }
    }

    /**
     * インポートの戦略。
     */
    public enum Strategy {

        /**
         * トップレベル型のみをインポートする。
         */
        TOP_LEVEL,

        /**
         * 末端の単純名を利用するようにインポートする。
         */
        ENCLOSING,
    }
}
