package com.ashigeru.lang.java.parser.javadoc;

import java.text.MessageFormat;

import com.ashigeru.lang.java.internal.parser.javadoc.ir.IrLocation;

/**
 * 内部ブロックの情報。
 * {@link JavadocBlockParserUtil#fetchBlockInfo(JavadocScanner)}の結果に利用される。
 * @author Suguru ARAKAWA (Gluegent, Inc.)
 */
public class JavadocBlockInfo {

    private IrLocation location;
    private String tagName;
    private JavadocScanner blockScanner;

    JavadocBlockInfo(String tagName, JavadocScanner blockScanner, IrLocation location) {
        super();
        this.tagName = tagName;
        this.blockScanner = blockScanner;
        this.location = location;
    }

    /**
     * ブロックのレンジを返す。
     * @return ブロックのレンジ
     */
    public IrLocation getLocation() {
        return this.location;
    }

    /**
     * タグ名を返す。
     * @return タグ名
     */
    public String getTagName() {
        return this.tagName;
    }

    /**
     * ブロックに対するスキャナを返す。
     * 返されるスキャナは、ブロック内のタグの次のトークンから、ブロック内部の終端トークンまでを保持する。
     * @return ブロックに対するスキャナ
     */
    public JavadocScanner getBlockScanner() {
        return this.blockScanner;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
            "'{'{0} {1}'}' ({2})", //$NON-NLS-1$
            getTagName(),
            getBlockScanner(),
            getLocation());
    }
}