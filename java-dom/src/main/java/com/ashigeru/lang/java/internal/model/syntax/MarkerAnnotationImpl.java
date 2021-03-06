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

import com.ashigeru.lang.java.model.syntax.MarkerAnnotation;
import com.ashigeru.lang.java.model.syntax.ModelKind;
import com.ashigeru.lang.java.model.syntax.NamedType;
import com.ashigeru.lang.java.model.syntax.Visitor;

/**
 * {@link MarkerAnnotation}の実装。
 * @author ashigeru
 */
public final class MarkerAnnotationImpl extends ModelRoot implements MarkerAnnotation {

    /**
     * 注釈の型。
     */
    private NamedType type;

    @Override
    public NamedType getType() {
        return this.type;
    }

    /**
     * 注釈の型を設定する。
     * @param type
     *     注釈の型
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     */
    public void setType(NamedType type) {
        Util.notNull(type, "type"); //$NON-NLS-1$
        this.type = type;
    }

    /**
     * この要素の種類を表す{@link ModelKind#MARKER_ANNOTATION}を返す。
     * @return {@link ModelKind#MARKER_ANNOTATION}
     */
    @Override
    public ModelKind getModelKind() {
        return ModelKind.MARKER_ANNOTATION;
    }

    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        Util.notNull(visitor, "visitor"); //$NON-NLS-1$
        return visitor.visitMarkerAnnotation(this, context);
    }
}
