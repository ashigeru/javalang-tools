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

import com.ashigeru.lang.java.model.syntax.AlternateConstructorInvocation;
import com.ashigeru.lang.java.model.syntax.Expression;
import com.ashigeru.lang.java.model.syntax.ModelKind;
import com.ashigeru.lang.java.model.syntax.Type;
import com.ashigeru.lang.java.model.syntax.Visitor;

/**
 * {@link AlternateConstructorInvocation}の実装。
 * @author ashigeru
 */
public final class AlternateConstructorInvocationImpl extends ModelRoot implements AlternateConstructorInvocation {

    /**
     * 型引数の一覧。
     */
    private List<? extends Type> typeArguments;

    /**
     * 実引数の一覧。
     */
    private List<? extends Expression> arguments;

    @Override
    public List<? extends Type> getTypeArguments() {
        return this.typeArguments;
    }

    /**
     * 型引数の一覧を設定する。
     * <p> 型引数を一つも指定しない場合、引数には空を指定する。 </p>
     * @param typeArguments
     *     型引数の一覧
     * @throws IllegalArgumentException
     *     {@code typeArguments}に{@code null}が指定された場合
     */
    public void setTypeArguments(List<? extends Type> typeArguments) {
        Util.notNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        Util.notContainNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        this.typeArguments = Util.freeze(typeArguments);
    }

    @Override
    public List<? extends Expression> getArguments() {
        return this.arguments;
    }

    /**
     * 実引数の一覧を設定する。
     * <p> 実引数を一つも指定しない場合、引数には空を指定する。 </p>
     * @param arguments
     *     実引数の一覧
     * @throws IllegalArgumentException
     *     {@code arguments}に{@code null}が指定された場合
     */
    public void setArguments(List<? extends Expression> arguments) {
        Util.notNull(arguments, "arguments"); //$NON-NLS-1$
        Util.notContainNull(arguments, "arguments"); //$NON-NLS-1$
        this.arguments = Util.freeze(arguments);
    }

    /**
     * この要素の種類を表す{@link ModelKind#ALTERNATE_CONSTRUCTOR_INVOCATION}を返す。
     * @return {@link ModelKind#ALTERNATE_CONSTRUCTOR_INVOCATION}
     */
    @Override
    public ModelKind getModelKind() {
        return ModelKind.ALTERNATE_CONSTRUCTOR_INVOCATION;
    }

    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        Util.notNull(visitor, "visitor"); //$NON-NLS-1$
        return visitor.visitAlternateConstructorInvocation(this, context);
    }
}
