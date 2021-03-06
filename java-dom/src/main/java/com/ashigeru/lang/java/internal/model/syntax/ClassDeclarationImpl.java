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
package com.ashigeru.lang.java.internal.model.syntax;

import java.util.List;

import com.ashigeru.lang.java.model.syntax.Attribute;
import com.ashigeru.lang.java.model.syntax.ClassDeclaration;
import com.ashigeru.lang.java.model.syntax.Javadoc;
import com.ashigeru.lang.java.model.syntax.ModelKind;
import com.ashigeru.lang.java.model.syntax.SimpleName;
import com.ashigeru.lang.java.model.syntax.Type;
import com.ashigeru.lang.java.model.syntax.TypeBodyDeclaration;
import com.ashigeru.lang.java.model.syntax.TypeParameterDeclaration;
import com.ashigeru.lang.java.model.syntax.Visitor;

/**
 * {@link ClassDeclaration}の実装。
 * @author ashigeru
 */
public final class ClassDeclarationImpl extends ModelRoot implements ClassDeclaration {

    /**
     * ドキュメンテーションコメント。
     */
    private Javadoc javadoc;

    /**
     * 修飾子および注釈の一覧。
     */
    private List<? extends Attribute> modifiers;

    /**
     * 型の単純名。
     */
    private SimpleName name;

    /**
     * 仮型引数宣言の一覧。
     */
    private List<? extends TypeParameterDeclaration> typeParameters;

    /**
     * 親クラス。
     */
    private Type superClass;

    /**
     * 親インターフェースの一覧。
     */
    private List<? extends Type> superInterfaceTypes;

    /**
     * メンバの一覧。
     */
    private List<? extends TypeBodyDeclaration> bodyDeclarations;

    @Override
    public Javadoc getJavadoc() {
        return this.javadoc;
    }

    /**
     * ドキュメンテーションコメントを設定する。
     * <p> ドキュメンテーションコメントが存在しない場合、引数には{@code null}を指定する。 </p>
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     */
    public void setJavadoc(Javadoc javadoc) {
        this.javadoc = javadoc;
    }

    @Override
    public List<? extends Attribute> getModifiers() {
        return this.modifiers;
    }

    /**
     * 修飾子および注釈の一覧を設定する。
     * <p> 修飾子または注釈が一つも宣言されない場合、引数には空を指定する。 </p>
     * @param modifiers
     *     修飾子および注釈の一覧
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     */
    public void setModifiers(List<? extends Attribute> modifiers) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        this.modifiers = Util.freeze(modifiers);
    }

    @Override
    public SimpleName getName() {
        return this.name;
    }

    /**
     * 型の単純名を設定する。
     * @param name
     *     型の単純名
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     */
    public void setName(SimpleName name) {
        Util.notNull(name, "name"); //$NON-NLS-1$
        this.name = name;
    }

    @Override
    public List<? extends TypeParameterDeclaration> getTypeParameters() {
        return this.typeParameters;
    }

    /**
     * 仮型引数宣言の一覧を設定する。
     * <p> 仮型引数が一つも宣言されない場合、引数には空を指定する。 </p>
     * @param typeParameters
     *     仮型引数宣言の一覧
     * @throws IllegalArgumentException
     *     {@code typeParameters}に{@code null}が指定された場合
     */
    public void setTypeParameters(List<? extends TypeParameterDeclaration> typeParameters) {
        Util.notNull(typeParameters, "typeParameters"); //$NON-NLS-1$
        Util.notContainNull(typeParameters, "typeParameters"); //$NON-NLS-1$
        this.typeParameters = Util.freeze(typeParameters);
    }

    @Override
    public Type getSuperClass() {
        return this.superClass;
    }

    /**
     * 親クラスを設定する。
     * <p> 親クラスが明示されない場合、引数には{@code null}を指定する。 </p>
     * @param superClass
     *     親クラス、
     *     ただし親クラスが明示されない場合は{@code null}
     */
    public void setSuperClass(Type superClass) {
        this.superClass = superClass;
    }

    @Override
    public List<? extends Type> getSuperInterfaceTypes() {
        return this.superInterfaceTypes;
    }

    /**
     * 親インターフェースの一覧を設定する。
     * <p> 親インターフェースが一つも宣言されない場合、引数には空を指定する。 </p>
     * @param superInterfaceTypes
     *     親インターフェースの一覧
     * @throws IllegalArgumentException
     *     {@code superInterfaceTypes}に{@code null}が指定された場合
     */
    public void setSuperInterfaceTypes(List<? extends Type> superInterfaceTypes) {
        Util.notNull(superInterfaceTypes, "superInterfaceTypes"); //$NON-NLS-1$
        Util.notContainNull(superInterfaceTypes, "superInterfaceTypes"); //$NON-NLS-1$
        this.superInterfaceTypes = Util.freeze(superInterfaceTypes);
    }

    @Override
    public List<? extends TypeBodyDeclaration> getBodyDeclarations() {
        return this.bodyDeclarations;
    }

    /**
     * メンバの一覧を設定する。
     * <p> メンバが一つも宣言されない場合、引数には空を指定する。 </p>
     * @param bodyDeclarations
     *     メンバの一覧
     * @throws IllegalArgumentException
     *     {@code bodyDeclarations}に{@code null}が指定された場合
     */
    public void setBodyDeclarations(List<? extends TypeBodyDeclaration> bodyDeclarations) {
        Util.notNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        Util.notContainNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        this.bodyDeclarations = Util.freeze(bodyDeclarations);
    }

    /**
     * この要素の種類を表す{@link ModelKind#CLASS_DECLARATION}を返す。
     * @return {@link ModelKind#CLASS_DECLARATION}
     */
    @Override
    public ModelKind getModelKind() {
        return ModelKind.CLASS_DECLARATION;
    }

    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        Util.notNull(visitor, "visitor"); //$NON-NLS-1$
        return visitor.visitClassDeclaration(this, context);
    }
}
