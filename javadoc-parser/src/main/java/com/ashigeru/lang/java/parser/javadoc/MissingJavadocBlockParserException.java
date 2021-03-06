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

import java.text.MessageFormat;

import com.ashigeru.lang.java.internal.parser.javadoc.ir.IrLocation;

/**
 * ブロックの解析を行うパーサが検出できなかったことを表す例外。
 * @author Suguru ARAKAWA (Gluegent, Inc.)
 */
public class MissingJavadocBlockParserException extends JavadocParseException {

    private static final long serialVersionUID = 1L;

    private String tagName;

    /**
     * インスタンスを生成する。
     * @param tagName 解析対象のタグ名
     * @param location 解析中の位置
     * @param cause この例外の元となった例外
     */
    public MissingJavadocBlockParserException(String tagName, IrLocation location, Throwable cause) {
        super(buildMessage(tagName), location, cause);
        this.tagName = tagName;
    }

    private static String buildMessage(String tag) {
        String blockName = (tag == null ? Messages.getString("MissingJavadocBlockParserException.nameSynopsisBlock") : tag); //$NON-NLS-1$
        return MessageFormat.format(Messages.getString("MissingJavadocBlockParserException.errorMissingBlockParser"), blockName); //$NON-NLS-1$
    }

    /**
     * 解析を行おうとしたタグの名前を返す。
     * 概要ブロックの解析に対するパーサが発見できなかったことを表す場合、
     * この呼び出しは{@code null}を返す。
     * @return 解析を行おうとしたタグの名前
     */
    public String getTagName() {
        return this.tagName;
    }
}
