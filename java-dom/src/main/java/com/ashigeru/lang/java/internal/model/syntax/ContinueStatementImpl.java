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

import com.ashigeru.lang.java.model.syntax.ContinueStatement;
import com.ashigeru.lang.java.model.syntax.ModelKind;
import com.ashigeru.lang.java.model.syntax.SimpleName;
import com.ashigeru.lang.java.model.syntax.Visitor;

/**
 * {@link ContinueStatement}の実装。
 * @author ashigeru
 */
public final class ContinueStatementImpl extends ModelRoot implements ContinueStatement {

    /**
     * 分岐先ラベル。
     */
    private SimpleName target;

    @Override
    public SimpleName getTarget() {
        return this.target;
    }

    /**
     * 分岐先ラベルを設定する。
     * <p> 分岐先ラベルが指定されない場合、引数には{@code null}を指定する。 </p>
     * @param target
     *     分岐先ラベル、
     *     ただし分岐先ラベルが指定されない場合は{@code null}
     */
    public void setTarget(SimpleName target) {
        this.target = target;
    }

    /**
     * この要素の種類を表す{@link ModelKind#CONTINUE_STATEMENT}を返す。
     * @return {@link ModelKind#CONTINUE_STATEMENT}
     */
    @Override
    public ModelKind getModelKind() {
        return ModelKind.CONTINUE_STATEMENT;
    }

    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        Util.notNull(visitor, "visitor"); //$NON-NLS-1$
        return visitor.visitContinueStatement(this, context);
    }
}
