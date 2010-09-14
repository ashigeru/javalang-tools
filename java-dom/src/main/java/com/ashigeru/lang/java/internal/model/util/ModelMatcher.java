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
package com.ashigeru.lang.java.internal.model.util;

import java.util.List;

import com.ashigeru.lang.java.model.syntax.*;
import com.ashigeru.lang.java.model.util.NoThrow;

/**
 * {@link Model}どうしを比較するビジタ。
 * @author ashigeru
 */
public class ModelMatcher extends StrictVisitor<Boolean, Model, NoThrow> {

    /**
     * このクラスのインスタンス。
     */
    public static final ModelMatcher INSTANCE = new ModelMatcher();

    private ModelMatcher() {
        // only for the singleton instance
    }

    @Override
    public Boolean visitAlternateConstructorInvocation(
            AlternateConstructorInvocation elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        AlternateConstructorInvocation that = (AlternateConstructorInvocation) context;
        if (match(elem.getTypeArguments(), that.getTypeArguments()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getArguments(), that.getArguments()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitAnnotationDeclaration(
            AnnotationDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        AnnotationDeclaration that = (AnnotationDeclaration) context;
        if (match(elem.getJavadoc(), that.getJavadoc()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBodyDeclarations(), that.getBodyDeclarations()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitAnnotationElement(
            AnnotationElement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        AnnotationElement that = (AnnotationElement) context;
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitAnnotationElementDeclaration(
            AnnotationElementDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        AnnotationElementDeclaration that = (AnnotationElementDeclaration) context;
        if (match(elem.getJavadoc(), that.getJavadoc()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getDefaultExpression(), that.getDefaultExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitArrayAccessExpression(
            ArrayAccessExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ArrayAccessExpression that = (ArrayAccessExpression) context;
        if (match(elem.getArray(), that.getArray()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getIndex(), that.getIndex()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitArrayCreationExpression(
            ArrayCreationExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ArrayCreationExpression that = (ArrayCreationExpression) context;
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getDimensionExpressions(), that.getDimensionExpressions()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getArrayInitializer(), that.getArrayInitializer()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitArrayInitializer(
            ArrayInitializer elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ArrayInitializer that = (ArrayInitializer) context;
        if (match(elem.getElements(), that.getElements()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitArrayType(
            ArrayType elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ArrayType that = (ArrayType) context;
        if (match(elem.getComponentType(), that.getComponentType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitAssertStatement(
            AssertStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        AssertStatement that = (AssertStatement) context;
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getMessage(), that.getMessage()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitAssignmentExpression(
            AssignmentExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        AssignmentExpression that = (AssignmentExpression) context;
        if (match(elem.getLeftHandSide(), that.getLeftHandSide()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getOperator(), that.getOperator()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getRightHandSide(), that.getRightHandSide()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitBasicType(
            BasicType elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        BasicType that = (BasicType) context;
        if (match(elem.getTypeKind(), that.getTypeKind()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitBlock(
            Block elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        Block that = (Block) context;
        if (match(elem.getStatements(), that.getStatements()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitBlockComment(
            BlockComment elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        BlockComment that = (BlockComment) context;
        if (match(elem.getString(), that.getString()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitBreakStatement(
            BreakStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        BreakStatement that = (BreakStatement) context;
        if (match(elem.getTarget(), that.getTarget()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitCastExpression(
            CastExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        CastExpression that = (CastExpression) context;
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitCatchClause(
            CatchClause elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        CatchClause that = (CatchClause) context;
        if (match(elem.getParameter(), that.getParameter()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitClassBody(
            ClassBody elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ClassBody that = (ClassBody) context;
        if (match(elem.getBodyDeclarations(), that.getBodyDeclarations()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitClassDeclaration(
            ClassDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ClassDeclaration that = (ClassDeclaration) context;
        if (match(elem.getJavadoc(), that.getJavadoc()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getTypeParameters(), that.getTypeParameters()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getSuperClass(), that.getSuperClass()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getSuperInterfaceTypes(), that.getSuperInterfaceTypes()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBodyDeclarations(), that.getBodyDeclarations()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitClassInstanceCreationExpression(
            ClassInstanceCreationExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ClassInstanceCreationExpression that = (ClassInstanceCreationExpression) context;
        if (match(elem.getQualifier(), that.getQualifier()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getTypeArguments(), that.getTypeArguments()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getArguments(), that.getArguments()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitClassLiteral(
            ClassLiteral elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ClassLiteral that = (ClassLiteral) context;
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitCompilationUnit(
            CompilationUnit elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        CompilationUnit that = (CompilationUnit) context;
        if (match(elem.getPackageDeclaration(), that.getPackageDeclaration()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getImportDeclarations(), that.getImportDeclarations()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getTypeDeclarations(), that.getTypeDeclarations()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getComments(), that.getComments()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitConditionalExpression(
            ConditionalExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ConditionalExpression that = (ConditionalExpression) context;
        if (match(elem.getCondition(), that.getCondition()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getThenExpression(), that.getThenExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getElseExpression(), that.getElseExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitConstructorDeclaration(
            ConstructorDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ConstructorDeclaration that = (ConstructorDeclaration) context;
        if (match(elem.getJavadoc(), that.getJavadoc()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getTypeParameters(), that.getTypeParameters()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getFormalParameters(), that.getFormalParameters()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getExceptionTypes(), that.getExceptionTypes()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitContinueStatement(
            ContinueStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ContinueStatement that = (ContinueStatement) context;
        if (match(elem.getTarget(), that.getTarget()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitDoStatement(
            DoStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        DoStatement that = (DoStatement) context;
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getCondition(), that.getCondition()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitDocBlock(
            DocBlock elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        DocBlock that = (DocBlock) context;
        if (match(elem.getTag(), that.getTag()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getElements(), that.getElements()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitDocField(
            DocField elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        DocField that = (DocField) context;
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitDocMethod(
            DocMethod elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        DocMethod that = (DocMethod) context;
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getFormalParameters(), that.getFormalParameters()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitDocMethodParameter(
            DocMethodParameter elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        DocMethodParameter that = (DocMethodParameter) context;
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.isVariableArity(), that.isVariableArity()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitDocText(
            DocText elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        DocText that = (DocText) context;
        if (match(elem.getString(), that.getString()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitEmptyStatement(
            EmptyStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitEnhancedForStatement(
            EnhancedForStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        EnhancedForStatement that = (EnhancedForStatement) context;
        if (match(elem.getParameter(), that.getParameter()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitEnumConstantDeclaration(
            EnumConstantDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        EnumConstantDeclaration that = (EnumConstantDeclaration) context;
        if (match(elem.getJavadoc(), that.getJavadoc()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getArguments(), that.getArguments()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitEnumDeclaration(
            EnumDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        EnumDeclaration that = (EnumDeclaration) context;
        if (match(elem.getJavadoc(), that.getJavadoc()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getSuperInterfaceTypes(), that.getSuperInterfaceTypes()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getConstantDeclarations(), that.getConstantDeclarations()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBodyDeclarations(), that.getBodyDeclarations()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitExpressionStatement(
            ExpressionStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ExpressionStatement that = (ExpressionStatement) context;
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitFieldAccessExpression(
            FieldAccessExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        FieldAccessExpression that = (FieldAccessExpression) context;
        if (match(elem.getQualifier(), that.getQualifier()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitFieldDeclaration(
            FieldDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        FieldDeclaration that = (FieldDeclaration) context;
        if (match(elem.getJavadoc(), that.getJavadoc()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getVariableDeclarators(), that.getVariableDeclarators()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitForStatement(
            ForStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ForStatement that = (ForStatement) context;
        if (match(elem.getInitialization(), that.getInitialization()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getCondition(), that.getCondition()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getUpdate(), that.getUpdate()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitFormalParameterDeclaration(
            FormalParameterDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        FormalParameterDeclaration that = (FormalParameterDeclaration) context;
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.isVariableArity(), that.isVariableArity()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getExtraDimensions(), that.getExtraDimensions()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitIfStatement(
            IfStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        IfStatement that = (IfStatement) context;
        if (match(elem.getCondition(), that.getCondition()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getThenStatement(), that.getThenStatement()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getElseStatement(), that.getElseStatement()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitImportDeclaration(
            ImportDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ImportDeclaration that = (ImportDeclaration) context;
        if (match(elem.getImportKind(), that.getImportKind()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitInfixExpression(
            InfixExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        InfixExpression that = (InfixExpression) context;
        if (match(elem.getLeftOperand(), that.getLeftOperand()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getOperator(), that.getOperator()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getRightOperand(), that.getRightOperand()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitInitializerDeclaration(
            InitializerDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        InitializerDeclaration that = (InitializerDeclaration) context;
        if (match(elem.getJavadoc(), that.getJavadoc()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitInstanceofExpression(
            InstanceofExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        InstanceofExpression that = (InstanceofExpression) context;
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitInterfaceDeclaration(
            InterfaceDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        InterfaceDeclaration that = (InterfaceDeclaration) context;
        if (match(elem.getJavadoc(), that.getJavadoc()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getTypeParameters(), that.getTypeParameters()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getSuperInterfaceTypes(), that.getSuperInterfaceTypes()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBodyDeclarations(), that.getBodyDeclarations()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitJavadoc(
            Javadoc elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        Javadoc that = (Javadoc) context;
        if (match(elem.getBlocks(), that.getBlocks()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitLabeledStatement(
            LabeledStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        LabeledStatement that = (LabeledStatement) context;
        if (match(elem.getLabel(), that.getLabel()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitLineComment(
            LineComment elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        LineComment that = (LineComment) context;
        if (match(elem.getString(), that.getString()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitLiteral(
            Literal elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        Literal that = (Literal) context;
        if (match(elem.getToken(), that.getToken()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitLocalClassDeclaration(
            LocalClassDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        LocalClassDeclaration that = (LocalClassDeclaration) context;
        if (match(elem.getDeclaration(), that.getDeclaration()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitLocalVariableDeclaration(
            LocalVariableDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        LocalVariableDeclaration that = (LocalVariableDeclaration) context;
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getVariableDeclarators(), that.getVariableDeclarators()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitMarkerAnnotation(
            MarkerAnnotation elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        MarkerAnnotation that = (MarkerAnnotation) context;
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitMethodDeclaration(
            MethodDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        MethodDeclaration that = (MethodDeclaration) context;
        if (match(elem.getJavadoc(), that.getJavadoc()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getModifiers(), that.getModifiers()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getTypeParameters(), that.getTypeParameters()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getReturnType(), that.getReturnType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getFormalParameters(), that.getFormalParameters()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getExtraDimensions(), that.getExtraDimensions()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getExceptionTypes(), that.getExceptionTypes()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitMethodInvocationExpression(
            MethodInvocationExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        MethodInvocationExpression that = (MethodInvocationExpression) context;
        if (match(elem.getQualifier(), that.getQualifier()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getTypeArguments(), that.getTypeArguments()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getArguments(), that.getArguments()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitModifier(
            Modifier elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        Modifier that = (Modifier) context;
        if (match(elem.getModifierKind(), that.getModifierKind()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitNamedType(
            NamedType elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        NamedType that = (NamedType) context;
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitNormalAnnotation(
            NormalAnnotation elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        NormalAnnotation that = (NormalAnnotation) context;
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getElements(), that.getElements()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitPackageDeclaration(
            PackageDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        PackageDeclaration that = (PackageDeclaration) context;
        if (match(elem.getJavadoc(), that.getJavadoc()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getAnnotations(), that.getAnnotations()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitParameterizedType(
            ParameterizedType elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ParameterizedType that = (ParameterizedType) context;
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getTypeArguments(), that.getTypeArguments()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitParenthesizedExpression(
            ParenthesizedExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ParenthesizedExpression that = (ParenthesizedExpression) context;
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitPostfixExpression(
            PostfixExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        PostfixExpression that = (PostfixExpression) context;
        if (match(elem.getOperand(), that.getOperand()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getOperator(), that.getOperator()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitQualifiedName(
            QualifiedName elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        QualifiedName that = (QualifiedName) context;
        if (match(elem.getQualifier(), that.getQualifier()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getSimpleName(), that.getSimpleName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitQualifiedType(
            QualifiedType elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        QualifiedType that = (QualifiedType) context;
        if (match(elem.getQualifier(), that.getQualifier()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getSimpleName(), that.getSimpleName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitReturnStatement(
            ReturnStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ReturnStatement that = (ReturnStatement) context;
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitSimpleName(
            SimpleName elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        SimpleName that = (SimpleName) context;
        if (match(elem.getToken(), that.getToken()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitSingleElementAnnotation(
            SingleElementAnnotation elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        SingleElementAnnotation that = (SingleElementAnnotation) context;
        if (match(elem.getType(), that.getType()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitStatementExpressionList(
            StatementExpressionList elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        StatementExpressionList that = (StatementExpressionList) context;
        if (match(elem.getExpressions(), that.getExpressions()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitSuper(
            Super elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        Super that = (Super) context;
        if (match(elem.getQualifier(), that.getQualifier()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitSuperConstructorInvocation(
            SuperConstructorInvocation elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        SuperConstructorInvocation that = (SuperConstructorInvocation) context;
        if (match(elem.getQualifier(), that.getQualifier()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getTypeArguments(), that.getTypeArguments()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getArguments(), that.getArguments()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitSwitchCaseLabel(
            SwitchCaseLabel elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        SwitchCaseLabel that = (SwitchCaseLabel) context;
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitSwitchDefaultLabel(
            SwitchDefaultLabel elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitSwitchStatement(
            SwitchStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        SwitchStatement that = (SwitchStatement) context;
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getStatements(), that.getStatements()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitSynchronizedStatement(
            SynchronizedStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        SynchronizedStatement that = (SynchronizedStatement) context;
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitThis(
            This elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        This that = (This) context;
        if (match(elem.getQualifier(), that.getQualifier()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitThrowStatement(
            ThrowStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        ThrowStatement that = (ThrowStatement) context;
        if (match(elem.getExpression(), that.getExpression()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitTryStatement(
            TryStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        TryStatement that = (TryStatement) context;
        if (match(elem.getTryBlock(), that.getTryBlock()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getCatchClauses(), that.getCatchClauses()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getFinallyBlock(), that.getFinallyBlock()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitTypeParameterDeclaration(
            TypeParameterDeclaration elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        TypeParameterDeclaration that = (TypeParameterDeclaration) context;
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getTypeBounds(), that.getTypeBounds()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitUnaryExpression(
            UnaryExpression elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        UnaryExpression that = (UnaryExpression) context;
        if (match(elem.getOperator(), that.getOperator()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getOperand(), that.getOperand()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitVariableDeclarator(
            VariableDeclarator elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        VariableDeclarator that = (VariableDeclarator) context;
        if (match(elem.getName(), that.getName()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getExtraDimensions(), that.getExtraDimensions()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getInitializer(), that.getInitializer()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitWhileStatement(
            WhileStatement elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        WhileStatement that = (WhileStatement) context;
        if (match(elem.getCondition(), that.getCondition()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getBody(), that.getBody()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitWildcard(
            Wildcard elem,
            Model context) {
        if (elem.getModelKind() != context.getModelKind()) {
            return Boolean.FALSE;
        }
        Wildcard that = (Wildcard) context;
        if (match(elem.getBoundKind(), that.getBoundKind()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        if (match(elem.getTypeBound(), that.getTypeBound()) == Boolean.FALSE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private Boolean match(Model a, Model b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return Boolean.FALSE;
        }
        if (a.getModelKind() != b.getModelKind()) {
            return Boolean.FALSE;
        }
        return a.accept(this, b);
    }

    private Boolean match(
            List<? extends Model> a,
            List<? extends Model> b) {
        if (a.size() != b.size()) {
            return Boolean.FALSE;
        }
        for (int i = 0, n = a.size(); i < n; i++) {
            if (a.get(i).accept(this, b.get(i)) == Boolean.FALSE) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    private Boolean match(boolean a, boolean b) {
        return a == b;
    }

    private Boolean match(int a, int b) {
        return a == b;
    }

    private Boolean match(String a, String b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
    }

    private <T extends Enum<T>> Boolean match(T a, T b) {
        return a == b;
    }
}
