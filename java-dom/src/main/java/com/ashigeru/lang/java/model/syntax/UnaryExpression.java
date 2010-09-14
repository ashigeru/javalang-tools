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
 * 単項演算式を表現するインターフェース。
 * <ul>
 *   <li> Specified In: <ul>
 *     <li> {@code [JLS3:15.15] Unary Operators} </li>
 *   </ul> </li>
 * </ul>
 * @author ashigeru
 */
public interface UnaryExpression
        extends Expression {

    // properties

    /**
     * 単項演算子を返す。
     * @return
     *     単項演算子
     */
    UnaryOperator getOperator();

    /**
     * 演算項を返す。
     * @return
     *     演算項
     */
    Expression getOperand();
}
