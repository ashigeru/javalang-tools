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

import java.util.List;

/**
 * パラメータ化型を表現するインターフェース。
 * <ul>
 *   <li> Specified In: <ul>
 *     <li> {@code [JLS3:4.5] Parameterized Types} </li>
 *   </ul> </li>
 * </ul>
 * @author ashigeru
 */
public interface ParameterizedType
        extends Type {

    // properties

    /**
     * パラメータ化されていない型を返す。
     * @return
     *     パラメータ化されていない型
     */
    Type getType();

    /**
     * 型引数の一覧を返す。
     * @return
     *     型引数の一覧
     */
    List<? extends Type> getTypeArguments();
}
