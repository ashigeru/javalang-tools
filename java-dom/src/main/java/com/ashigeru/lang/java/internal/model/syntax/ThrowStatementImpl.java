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

import com.ashigeru.lang.java.model.syntax.Expression;
import com.ashigeru.lang.java.model.syntax.ModelKind;
import com.ashigeru.lang.java.model.syntax.ThrowStatement;
import com.ashigeru.lang.java.model.syntax.Visitor;

/**
 * {@link ThrowStatement}の実装。
 * @author ashigeru
 */
public final class ThrowStatementImpl extends ModelRoot implements ThrowStatement {

    /**
     * 例外オブジェクト。
     */
    private Expression expression;

    @Override
    public Expression getExpression() {
        return this.expression;
    }

    /**
     * 例外オブジェクトを設定する。
     * @param expression
     *     例外オブジェクト
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     */
    public void setExpression(Expression expression) {
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        this.expression = expression;
    }

    /**
     * この要素の種類を表す{@link ModelKind#THROW_STATEMENT}を返す。
     * @return {@link ModelKind#THROW_STATEMENT}
     */
    @Override
    public ModelKind getModelKind() {
        return ModelKind.THROW_STATEMENT;
    }

    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        Util.notNull(visitor, "visitor"); //$NON-NLS-1$
        return visitor.visitThrowStatement(this, context);
    }
}
