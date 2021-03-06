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

import java.util.ArrayList;

import com.ashigeru.lang.java.internal.parser.javadoc.ir.IrDocBlock;
import com.ashigeru.lang.java.internal.parser.javadoc.ir.IrDocFragment;

/**
 * タグの直後に参照を指定するブロックを解析する。
 * @author Suguru ARAKAWA (Gluegent, Inc.)
 */
public class FollowsReferenceBlockParser extends AcceptableJavadocBlockParser {

    /**
     * インスタンスを生成する。
     * インラインブロックを解析するパーサは存在しない状態となる。
     * @param tagNames タグ名の一覧
     */
    public FollowsReferenceBlockParser(String...tagNames) {
        super(tagNames);
    }

    @Override
    public IrDocBlock parse(String tag, JavadocScanner scanner) throws JavadocParseException {
        ArrayList<IrDocFragment> fragments = new ArrayList<IrDocFragment>();
        IrDocFragment first = fetchLinkTarget(scanner);
        if (first != null) {
            fragments.add(first);
        }
        fragments.addAll(fetchRestFragments(scanner));
        fragments.trimToSize();
        return newBlock(tag, fragments);
    }
}
