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
package com.ashigeru.lang.java.jsr199.testing;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.annotation.processing.Processor;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

/**
 * ソースコードをメモリ上に展開してコンパイルを実施する。
 */
public class VolatileCompiler implements Closeable {

    private JavaCompiler compiler;

    private VolatileClassOutputManager files;

    private List<JavaFileObject> targets;

    private List<Processor> processors;

    /**
     * インスタンスを生成する。
     * @throws IllegalStateException コンパイラを利用できない場合
     */
    public VolatileCompiler() {
        this.compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            throw new IllegalStateException("No System Java Compiler");
        }
        this.files = new VolatileClassOutputManager(
            compiler.getStandardFileManager(
                null,
                Locale.ENGLISH,
                Charset.forName("UTF-8")));
        this.targets = new ArrayList<JavaFileObject>();
        this.processors = new ArrayList<Processor>();
    }

    /**
     * このコンパイラにソースプログラムを追加する。
     * @param java 追加するソースプログラム
     * @return このオブジェクト (メソッドチェイン用)
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public VolatileCompiler addSource(JavaFileObject java) {
        if (java == null) {
            throw new IllegalArgumentException("java must not be null"); //$NON-NLS-1$
        }
        targets.add(java);
        return this;
    }

    /**
     * このコンパイラに注釈プロセッサを追加する。
     * @param processor 追加するプロセッサ
     * @return このオブジェクト (メソッドチェイン用)
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public VolatileCompiler addProcessor(Processor processor) {
        if (processor == null) {
            throw new IllegalArgumentException("processor must not be null"); //$NON-NLS-1$
        }
        processors.add(processor);
        return this;
    }

    /**
     * コンパイルを実行し、結果の診断オブジェクトを返す。
     * @return 結果の診断オブジェクト
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public List<Diagnostic<? extends JavaFileObject>> doCompile() {
        DiagnosticCollector<JavaFileObject> collector =
            new DiagnosticCollector<JavaFileObject>();

        CompilationTask task = compiler.getTask(
            new PrintWriter(System.err, true),
            files,
            collector,
            Arrays.asList(new String[] {
                "-source", "1.6",
                "-target", "1.6",
                "-encoding", "UTF-8"
            }),
            Arrays.<String>asList(),
            targets);

        task.setProcessors(processors);

        task.call();
        return collector.getDiagnostics();
    }

    /**
     * 現在までのコンパイル結果を元にしたクラスローダーを生成して返す。
     * @return クラスローダー
     */
    public ClassLoader getClassLoader() {
        DirectClassLoader loader = new DirectClassLoader(getClass().getClassLoader());
        loader.setDefaultAssertionStatus(true);
        for (VolatileClassFile klass : files.getCompiled()) {
            loader.add(klass.getBinaryName(), klass.getBinaryContent());
        }
        return loader;
    }

    @Override
    public void close() throws IOException {
        files.close();
    }
}
