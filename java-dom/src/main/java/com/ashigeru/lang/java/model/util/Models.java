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

import java.io.PrintWriter;

import com.ashigeru.lang.java.internal.model.syntax.ModelFactoryImpl;
import com.ashigeru.lang.java.internal.model.util.LiteralAnalyzer;
import com.ashigeru.lang.java.internal.model.util.ModelEmitter;
import com.ashigeru.lang.java.internal.model.util.ReflectionTypeMapper;
import com.ashigeru.lang.java.model.syntax.Literal;
import com.ashigeru.lang.java.model.syntax.Model;
import com.ashigeru.lang.java.model.syntax.ModelFactory;
import com.ashigeru.lang.java.model.syntax.Name;
import com.ashigeru.lang.java.model.syntax.SimpleName;
import com.ashigeru.lang.java.model.syntax.Type;

/**
 * {@link Model}に関するユーティリティ群。
 * @author ashigeru
 */
public class Models {

    /**
     * {@link Model}の実装を生成するためのファクトリを返す。
     * @return {@link Model}の実装を生成するためのファクトリ
     */
    public static ModelFactory getModelFactory() {
        return new ModelFactoryImpl();
    }

    /**
     * モデルを指定の出力先に文字列として書き出す。
     * <p>
     * 対象のモデルおよびそれに含まれるモデルのいずれかが
     * {@link CommentEmitTrait}を{@link Model#findModelTrait(Class)
     * 所有している}場合、それらのモデルはアダプタが指定するコメントをモデルの出力の前に出力する。
     * ただし、一部のコメントはモデルの途中で出力される場合がある。
     * </p>
     * @param model 対象のモデル
     * @param writer 出力先
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static void emit(Model model, PrintWriter writer) {
        if (model == null) {
            throw new IllegalArgumentException("model must not be null"); //$NON-NLS-1$
        }
        if (writer == null) {
            throw new IllegalArgumentException("writer must not be null"); //$NON-NLS-1$
        }
        ModelEmitter emitter = new ModelEmitter(writer);
        emitter.emit(model);
    }

    /**
     * リフレクションAPIの型の表現を、モデルの型の表現に変換して返す。
     * @param factory 利用するファクトリ
     * @param type 変換対象の型
     * @return 変換後のモデル
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static Type toType(ModelFactory factory, java.lang.reflect.Type type) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        if (type == null) {
            throw new IllegalArgumentException("type must not be null"); //$NON-NLS-1$
        }
        return new ReflectionTypeMapper().dispatch(type, factory);
    }

    /**
     * 指定の文字列を名前の構造に変換する。
     * <p>
     * 名前として正しいかどうかについては検証を行わない。
     * </p>
     * @param factory 利用するファクトリ
     * @param nameString 変換対象の文字列
     * @return 変換後の名前
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static Name toName(ModelFactory factory, String nameString) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        if (nameString == null) {
            throw new IllegalArgumentException("nameString must not be null"); //$NON-NLS-1$
        }
        String[] segments = nameString.trim().split("\\s*\\.\\s*"); //$NON-NLS-1$
        if (segments.length == 0 || segments[0].length() == 0) {
            throw new IllegalArgumentException("nameString is empty"); //$NON-NLS-1$
        }
        Name left = factory.newSimpleName(segments[0]);
        for (int i = 1; i < segments.length; i++) {
            SimpleName right = factory.newSimpleName(segments[i]);
            left = factory.newQualifiedName(left, right);
        }
        return left;
    }

    /**
     * 指定の定数を完全限定名に変換する。
     * @param factory 利用するファクトリ
     * @param constant 定数
     * @return 変換後の名前
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static Name toName(ModelFactory factory, Enum<?> constant) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        if (constant == null) {
            throw new IllegalArgumentException("constant must not be null"); //$NON-NLS-1$
        }
        Name typeName = toName(factory, constant.getDeclaringClass().getName());
        return factory.newQualifiedName(
                typeName,
                factory.newSimpleName(constant.name()));
    }

    /**
     * 指定の値をリテラルに変換する。
     * @param factory 利用するファクトリ
     * @param value 値
     * @return 変換後の名前
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static Literal toLiteral(ModelFactory factory, int value) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        String token = LiteralAnalyzer.intLiteralOf(value);
        return factory.newLiteral(token);
    }

    /**
     * 指定の値をリテラルに変換する。
     * @param factory 利用するファクトリ
     * @param value 値
     * @return 変換後の名前
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static Literal toLiteral(ModelFactory factory, long value) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        String token = LiteralAnalyzer.longLiteralOf(value);
        return factory.newLiteral(token);
    }

    /**
     * 指定の値をリテラルに変換する。
     * @param factory 利用するファクトリ
     * @param value 値
     * @return 変換後の名前
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static Literal toLiteral(ModelFactory factory, float value) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        String token = LiteralAnalyzer.floatLiteralOf(value);
        return factory.newLiteral(token);
    }

    /**
     * 指定の値をリテラルに変換する。
     * @param factory 利用するファクトリ
     * @param value 値
     * @return 変換後の名前
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static Literal toLiteral(ModelFactory factory, double value) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        String token = LiteralAnalyzer.doubleLiteralOf(value);
        return factory.newLiteral(token);
    }

    /**
     * 指定の値をリテラルに変換する。
     * @param factory 利用するファクトリ
     * @param value 値
     * @return 変換後の名前
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static Literal toLiteral(ModelFactory factory, boolean value) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        String token = LiteralAnalyzer.booleanLiteralOf(value);
        return factory.newLiteral(token);
    }

    /**
     * 指定の値をリテラルに変換する。
     * @param factory 利用するファクトリ
     * @param value 値
     * @return 変換後の名前
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static Literal toLiteral(ModelFactory factory, char value) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        String token = LiteralAnalyzer.charLiteralOf(value);
        return factory.newLiteral(token);
    }

    /**
     * 指定の値をリテラルに変換する。
     * @param factory 利用するファクトリ
     * @param value 値
     * @return 変換後の名前
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static Literal toLiteral(ModelFactory factory, String value) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        String token = LiteralAnalyzer.stringLiteralOf(value);
        return factory.newLiteral(token);
    }

    /**
     * {@code null}リテラルを返す。
     * @param factory 利用するファクトリ
     * @return 変換後の名前
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public static Literal toNullLiteral(ModelFactory factory) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null"); //$NON-NLS-1$
        }
        String token = LiteralAnalyzer.nullLiteral();
        return factory.newLiteral(token);
    }

    private Models() {
        throw new AssertionError();
    }
}
