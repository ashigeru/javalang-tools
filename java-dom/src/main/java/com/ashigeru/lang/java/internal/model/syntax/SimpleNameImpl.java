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

import com.ashigeru.lang.java.model.syntax.ModelKind;
import com.ashigeru.lang.java.model.syntax.SimpleName;
import com.ashigeru.lang.java.model.syntax.Visitor;

/**
 * {@link SimpleName}の実装。
 * @author ashigeru
 */
public final class SimpleNameImpl extends ModelRoot implements SimpleName {

    /**
     * この単純名を表現する文字列。
     */
    private String string;

    @Override
    public String getToken() {
        return this.string;
    }

    /**
     * この単純名を表現する文字列を設定する。
     * @param string
     *     この単純名を表現する文字列
     * @throws IllegalArgumentException
     *     {@code string}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code string}に空が指定された場合
     */
    public void setString(String string) {
        Util.notNull(string, "string"); //$NON-NLS-1$
        this.string = string;
    }

    /**
     * この要素の種類を表す{@link ModelKind#SIMPLE_NAME}を返す。
     * @return {@link ModelKind#SIMPLE_NAME}
     */
    @Override
    public ModelKind getModelKind() {
        return ModelKind.SIMPLE_NAME;
    }

    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        Util.notNull(visitor, "visitor"); //$NON-NLS-1$
        return visitor.visitSimpleName(this, context);
    }
}
