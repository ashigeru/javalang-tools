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
 * 名前を表現する基底インターフェース。
 * <p> フィールド参照式が名前のみによって表現可能な場合、名前式を利用しなければならない。 </p>
 * <ul>
 *   <li> Specified In: <ul>
 *     <li> {@code [JLS3:6.2] Names and Identifiers} </li>
 *     <li> {@code [JLS3:6.5.6] Meaning of Expression Names} </li>
 *   </ul> </li>
 * </ul>
 * @see FieldAccessExpression
 * @author ashigeru
 */
public interface Name
        extends Expression, DocElement {

    // properties
}
