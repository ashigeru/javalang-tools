/*
 * Copyright 2007 the Seasar Foundation and the Others.
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
package com.ashigeru.lang.java.parser.javadoc;

import com.ashigeru.lang.java.internal.parser.javadoc.ir.IrLocation;

/**
 * コメント内に不正にコメントの終端が出現したことを表す例外。
 * @author Suguru ARAKAWA (Gluegent, Inc.)
 */
public class IllegalEndOfCommentException extends JavadocParseException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance.
     * @param location 位置
     * @param cause この原因の元となった例外
     */
    public IllegalEndOfCommentException(IrLocation location, Throwable cause) {
        super(buildMessage(), location, cause);
    }

    private static String buildMessage() {
        return "Unexpected end of comment (*/)";
    }
}
