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
package com.ashigeru.lang.java.model.syntax;


/**
 * {@code assert}文を表現するインターフェース。
 * <ul>
 *   <li> Specified In: <ul>
 *     <li> {@code [JLS3:14.10] The assert Statement} </li>
 *   </ul> </li>
 * </ul>
 * @author ashigeru
 */
public interface AssertStatement
        extends Statement {

    // properties

    /**
     * 表明式を返す。
     * @return
     *     表明式
     */
    Expression getExpression();

    /**
     * メッセージ式を返す。
     * <p> メッセージ式が省略された場合は{@code null}が返される。 </p>
     * @return
     *     メッセージ式、
     *     ただしメッセージ式が省略された場合は{@code null}
     */
    Expression getMessage();
}
