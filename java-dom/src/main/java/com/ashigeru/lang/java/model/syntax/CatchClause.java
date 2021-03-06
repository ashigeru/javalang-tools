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
 * {@code catch}節を表現するインターフェース。
 * <ul>
 *   <li> Specified In: <ul>
 *     <li> {@code [JLS3:14.20] The try statement} </li>
 *   </ul> </li>
 * </ul>
 * @author ashigeru
 */
public interface CatchClause
        extends TypedElement {

    // properties

    /**
     * 例外仮引数を返す。
     * @return
     *     例外仮引数
     */
    FormalParameterDeclaration getParameter();

    /**
     * {@code catch}ブロックを返す。
     * @return
     *     {@code catch}ブロック
     */
    Block getBody();
}
