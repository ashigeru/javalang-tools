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
package com.ashigeru.lang.java.internal.model.syntax;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.WeakHashMap;

import com.ashigeru.lang.java.internal.model.util.ModelDigester;
import com.ashigeru.lang.java.internal.model.util.ModelEmitter;
import com.ashigeru.lang.java.internal.model.util.ModelMatcher;
import com.ashigeru.lang.java.internal.model.util.PrintEmitContext;
import com.ashigeru.lang.java.model.syntax.Model;

/**
 * {@link Model}の基底となるクラス。
 * @author ashigeru
 */
abstract class ModelRoot implements Model {

    private Map<Class<?>, Object> traits = new WeakHashMap<Class<?>, Object>();

    @Override
    public <T> T findModelTrait(Class<T> traitClass) {
        if (traitClass == null) {
            throw new IllegalArgumentException("traitClass must not be null"); //$NON-NLS-1$
        }
        Object adapter = traits.get(traitClass);
        if (adapter == null) {
            return null;
        }
        return traitClass.cast(adapter);
    }

    @Override
    public <T> void putModelTrait(Class<T> traitClass, T traitObject) {
        if (traitClass == null) {
            throw new IllegalArgumentException("traitClass must not be null"); //$NON-NLS-1$
        }
        if (traitObject == null) {
            traits.remove(traitClass);
        }
        else {
            assert traitClass.isInstance(traitObject);
            traits.put(traitClass, traitObject);
        }
    }

    @Override
    public int hashCode() {
        return ModelDigester.compute(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if ((obj instanceof Model) == false) {
            return false;
        }
        return accept(ModelMatcher.INSTANCE, (Model) obj) ;
    }

    @Override
    public String toString() {
        StringWriter buffer = new StringWriter();
        PrintWriter output = new PrintWriter(buffer);
        try {
            ModelEmitter.emit(this, new PrintEmitContext(output));
        }
        catch (RuntimeException e) {
            e.printStackTrace(output);
        }
        output.flush();
        return buffer.toString();
    }
}
