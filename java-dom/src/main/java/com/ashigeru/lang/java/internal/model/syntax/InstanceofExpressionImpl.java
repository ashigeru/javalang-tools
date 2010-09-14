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
import com.ashigeru.lang.java.model.syntax.InstanceofExpression;
import com.ashigeru.lang.java.model.syntax.ModelKind;
import com.ashigeru.lang.java.model.syntax.Type;
import com.ashigeru.lang.java.model.syntax.Visitor;

/**
 * {@link InstanceofExpression}の実装。
 * @author ashigeru
 */
public final class InstanceofExpressionImpl extends ModelRoot implements InstanceofExpression {

    /**
     * 被演算項。
     */
    private Expression expression;

    /**
     * 比較対象型。
     */
    private Type type;

    @Override
    public Expression getExpression() {
        return this.expression;
    }

    /**
     * 被演算項を設定する。
     * @param expression
     *     被演算項
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     */
    public void setExpression(Expression expression) {
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        this.expression = expression;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    /**
     * 比較対象型を設定する。
     * @param type
     *     比較対象型
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     */
    public void setType(Type type) {
        Util.notNull(type, "type"); //$NON-NLS-1$
        this.type = type;
    }

    /**
     * この要素の種類を表す{@link ModelKind#INSTANCEOF_EXPRESSION}を返す。
     * @return {@link ModelKind#INSTANCEOF_EXPRESSION}
     */
    @Override
    public ModelKind getModelKind() {
        return ModelKind.INSTANCEOF_EXPRESSION;
    }

    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        Util.notNull(visitor, "visitor"); //$NON-NLS-1$
        return visitor.visitInstanceofExpression(this, context);
    }
}
