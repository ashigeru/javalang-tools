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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import com.ashigeru.lang.java.model.syntax.Attribute;
import com.ashigeru.lang.java.model.syntax.CompilationUnit;
import com.ashigeru.lang.java.model.syntax.Modifier;
import com.ashigeru.lang.java.model.syntax.ModifierKind;
import com.ashigeru.lang.java.model.syntax.PackageDeclaration;
import com.ashigeru.lang.java.model.syntax.SimpleName;
import com.ashigeru.lang.java.model.syntax.TypeDeclaration;

/**
 * ソースコードを出力するためのファイルを作成する。
 */
public class Filer {

    private static final String EXTENSION = ".java";

    private static final String PACKAGE_INFO = "package-info" + EXTENSION;

    private File outputPath;

    private Charset encoding;

    /**
     * インスタンスを生成する。
     * @param outputPath 出力先のパス
     * @param encoding エンコーディング
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public Filer(File outputPath, Charset encoding) {
        if (outputPath == null) {
            throw new IllegalArgumentException("outputPath must not be null"); //$NON-NLS-1$
        }
        if (encoding == null) {
            throw new IllegalArgumentException("encoding must not be null"); //$NON-NLS-1$
        }
        this.outputPath = outputPath;
        this.encoding = encoding;
    }

    /**
     * 指定のパッケージ宣言に関連するフォルダへのパスを返す。
     * <p>
     * 返されたパスにフォルダが実際に存在するとは限らない。
     * </p>
     * @param packageDeclOrNull パッケージ宣言、無名パッケージの場合は{@code null}
     * @return 対象のフォルダへのパス
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public File getFolderFor(PackageDeclaration packageDeclOrNull) {
        if (packageDeclOrNull == null) {
            return outputPath;
        }
        File path = outputPath;
        for (SimpleName segment : Models.toList(packageDeclOrNull.getName())) {
            path = new File(path, segment.getToken());
        }
        return path;
    }

    /**
     * 指定のコンパイル単位に書き出すためのライターを返す。
     * @param unit 対象のコンパイル単位
     * @return 開いたライター
     * @throws IOException ファイルの作成に失敗した場合
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public PrintWriter openFor(CompilationUnit unit) throws IOException {
        if (unit == null) {
            throw new IllegalArgumentException("unit must not be null"); //$NON-NLS-1$
        }
        TypeDeclaration primary = findPrimaryType(unit);
        if (primary == null) {
            return openFor(unit.getPackageDeclaration(), PACKAGE_INFO);
        }
        return openFor(unit.getPackageDeclaration(), primary);
    }

    /**
     * 指定のコンパイル単位に含まれる、ファイル名に利用できそうな型の宣言を返す。
     * <p>
     * 型の宣言が指定のコンパイル単位に含まれない場合、このメソッドは{@code null}を返す。
     * </p>
     * @param unit 対象のコンパイル単位
     * @return ファイル名に利用できそうな型の宣言、存在しない場合は{@code null}
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static TypeDeclaration findPrimaryType(CompilationUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("unit must not be null"); //$NON-NLS-1$
        }
        TypeDeclaration first = null;
        for (TypeDeclaration decl : unit.getTypeDeclarations()) {
            if (first == null) {
                first = decl;
            }
            for (Attribute attribute : decl.getModifiers()) {
                if (attribute instanceof Modifier) {
                    Modifier modifier = (Modifier) attribute;
                    if (modifier.getModifierKind() == ModifierKind.PUBLIC) {
                        return decl;
                    }
                }
            }
        }
        return first;
    }

    private PrintWriter openFor(
            PackageDeclaration packageDecl,
            TypeDeclaration typeDecl) throws IOException {
        assert typeDecl != null;
        String fileName = typeDecl.getName().getToken() + EXTENSION;
        return openFor(packageDecl, fileName);
    }

    /**
     * 指定のパッケージに指定のサブパスのファイルを作成するためのライターを返す。
     * @param packageDeclOrNull 対象のパッケージ宣言、無名パッケージの場合は{@code null}
     * @param subPath パッケージ下のサブパス
     * @return 開いたライター
     * @throws IOException ファイルの作成に失敗した場合
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public PrintWriter openFor(
            PackageDeclaration packageDeclOrNull,
            String subPath) throws IOException {
        if (subPath == null) {
            throw new IllegalArgumentException("fileName must not be null"); //$NON-NLS-1$
        }
        File folder = getFolderFor(packageDeclOrNull);
        File file = new File(folder, subPath);
        return open(file);
    }

    private PrintWriter open(File file) throws IOException {
        assert file != null;
        File parent = file.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }
        return new PrintWriter(file, encoding.name());
    }
}
