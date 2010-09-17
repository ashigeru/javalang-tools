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

import java.util.List;

import com.ashigeru.lang.java.model.syntax.*;

/**
 * {@link ModelFactory}の実装。
 * @author ashigeru
 */
public class ModelFactoryImpl implements ModelFactory {

    /**
     * 新しい{@link AlternateConstructorInvocation}を生成して返す。
     * @param typeArguments
     *     型引数の一覧
     * @param arguments
     *     実引数の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeArguments}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code arguments}に{@code null}が指定された場合
     */
    @Override
    public AlternateConstructorInvocation newAlternateConstructorInvocation(
            List<? extends Type> typeArguments,
            List<? extends Expression> arguments) {
        return this.newAlternateConstructorInvocation0(
            typeArguments,
            arguments
        );
    }

    private AlternateConstructorInvocationImpl newAlternateConstructorInvocation0(
            List<? extends Type> typeArguments,
            List<? extends Expression> arguments) {
        Util.notNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        Util.notContainNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        Util.notNull(arguments, "arguments"); //$NON-NLS-1$
        Util.notContainNull(arguments, "arguments"); //$NON-NLS-1$
        AlternateConstructorInvocationImpl result = new AlternateConstructorInvocationImpl();
        result.setTypeArguments(typeArguments);
        result.setArguments(arguments);
        return result;
    }

    /**
     * 新しい{@link AnnotationDeclaration}を生成して返す。
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param name
     *     型の単純名
     * @param bodyDeclarations
     *     メンバの一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code bodyDeclarations}に{@code null}が指定された場合
     */
    @Override
    public AnnotationDeclaration newAnnotationDeclaration(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            SimpleName name,
            List<? extends TypeBodyDeclaration> bodyDeclarations) {
        return this.newAnnotationDeclaration0(
            javadoc,
            modifiers,
            name,
            bodyDeclarations
        );
    }

    private AnnotationDeclarationImpl newAnnotationDeclaration0(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            SimpleName name,
            List<? extends TypeBodyDeclaration> bodyDeclarations) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        Util.notNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        Util.notContainNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        AnnotationDeclarationImpl result = new AnnotationDeclarationImpl();
        result.setJavadoc(javadoc);
        result.setModifiers(modifiers);
        result.setName(name);
        result.setBodyDeclarations(bodyDeclarations);
        return result;
    }

    /**
     * 新しい{@link AnnotationElement}を生成して返す。
     * @param name
     *     注釈要素の名前
     * @param expression
     *     注釈要素値の式
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     */
    @Override
    public AnnotationElement newAnnotationElement(
            SimpleName name,
            Expression expression) {
        return this.newAnnotationElement0(
            name,
            expression
        );
    }

    private AnnotationElementImpl newAnnotationElement0(
            SimpleName name,
            Expression expression) {
        Util.notNull(name, "name"); //$NON-NLS-1$
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        AnnotationElementImpl result = new AnnotationElementImpl();
        result.setName(name);
        result.setExpression(expression);
        return result;
    }

    /**
     * 新しい{@link AnnotationElementDeclaration}を生成して返す。
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param type
     *     注釈要素の型
     * @param name
     *     注釈要素の名前
     * @param defaultExpression
     *     注釈要素の規定値、
     *     ただし規定値が存在しない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     */
    @Override
    public AnnotationElementDeclaration newAnnotationElementDeclaration(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            Type type,
            SimpleName name,
            Expression defaultExpression) {
        return this.newAnnotationElementDeclaration0(
            javadoc,
            modifiers,
            type,
            name,
            defaultExpression
        );
    }

    private AnnotationElementDeclarationImpl newAnnotationElementDeclaration0(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            Type type,
            SimpleName name,
            Expression defaultExpression) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(type, "type"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        AnnotationElementDeclarationImpl result = new AnnotationElementDeclarationImpl();
        result.setJavadoc(javadoc);
        result.setModifiers(modifiers);
        result.setType(type);
        result.setName(name);
        result.setDefaultExpression(defaultExpression);
        return result;
    }

    /**
     * 新しい{@link ArrayAccessExpression}を生成して返す。
     * @param array
     *     配列式
     * @param index
     *     添え字式
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code array}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code index}に{@code null}が指定された場合
     */
    @Override
    public ArrayAccessExpression newArrayAccessExpression(
            Expression array,
            Expression index) {
        return this.newArrayAccessExpression0(
            array,
            index
        );
    }

    private ArrayAccessExpressionImpl newArrayAccessExpression0(
            Expression array,
            Expression index) {
        Util.notNull(array, "array"); //$NON-NLS-1$
        Util.notNull(index, "index"); //$NON-NLS-1$
        ArrayAccessExpressionImpl result = new ArrayAccessExpressionImpl();
        result.setArray(array);
        result.setIndex(index);
        return result;
    }

    /**
     * 新しい{@link ArrayCreationExpression}を生成して返す。
     * @param type
     *     生成する配列の型
     * @param dimensionExpressions
     *     要素数指定式
     * @param arrayInitializer
     *     配列初期化子、
     *     ただし配列初期化子が指定されない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code dimensionExpressions}に{@code null}が指定された場合
     */
    @Override
    public ArrayCreationExpression newArrayCreationExpression(
            ArrayType type,
            List<? extends Expression> dimensionExpressions,
            ArrayInitializer arrayInitializer) {
        return this.newArrayCreationExpression0(
            type,
            dimensionExpressions,
            arrayInitializer
        );
    }

    private ArrayCreationExpressionImpl newArrayCreationExpression0(
            ArrayType type,
            List<? extends Expression> dimensionExpressions,
            ArrayInitializer arrayInitializer) {
        Util.notNull(type, "type"); //$NON-NLS-1$
        Util.notNull(dimensionExpressions, "dimensionExpressions"); //$NON-NLS-1$
        Util.notContainNull(dimensionExpressions, "dimensionExpressions"); //$NON-NLS-1$
        ArrayCreationExpressionImpl result = new ArrayCreationExpressionImpl();
        result.setType(type);
        result.setDimensionExpressions(dimensionExpressions);
        result.setArrayInitializer(arrayInitializer);
        return result;
    }

    /**
     * 新しい{@link ArrayInitializer}を生成して返す。
     * @param elements
     *     要素の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code elements}に{@code null}が指定された場合
     */
    @Override
    public ArrayInitializer newArrayInitializer(
            List<? extends Expression> elements) {
        return this.newArrayInitializer0(
            elements
        );
    }

    private ArrayInitializerImpl newArrayInitializer0(
            List<? extends Expression> elements) {
        Util.notNull(elements, "elements"); //$NON-NLS-1$
        Util.notContainNull(elements, "elements"); //$NON-NLS-1$
        ArrayInitializerImpl result = new ArrayInitializerImpl();
        result.setElements(elements);
        return result;
    }

    /**
     * 新しい{@link ArrayType}を生成して返す。
     * @param componentType
     *     要素型
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code componentType}に{@code null}が指定された場合
     */
    @Override
    public ArrayType newArrayType(
            Type componentType) {
        return this.newArrayType0(
            componentType
        );
    }

    private ArrayTypeImpl newArrayType0(
            Type componentType) {
        Util.notNull(componentType, "componentType"); //$NON-NLS-1$
        ArrayTypeImpl result = new ArrayTypeImpl();
        result.setComponentType(componentType);
        return result;
    }

    /**
     * 新しい{@link AssertStatement}を生成して返す。
     * @param expression
     *     表明式
     * @param message
     *     メッセージ式、
     *     ただしメッセージ式が省略された場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     */
    @Override
    public AssertStatement newAssertStatement(
            Expression expression,
            Expression message) {
        return this.newAssertStatement0(
            expression,
            message
        );
    }

    private AssertStatementImpl newAssertStatement0(
            Expression expression,
            Expression message) {
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        AssertStatementImpl result = new AssertStatementImpl();
        result.setExpression(expression);
        result.setMessage(message);
        return result;
    }

    /**
     * 新しい{@link AssignmentExpression}を生成して返す。
     * @param leftHandSide
     *     左辺式
     * @param operator
     *     単純代入演算子、または複合する演算子
     * @param rightHandSide
     *     右辺式
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code leftHandSide}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code operator}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code rightHandSide}に{@code null}が指定された場合
     */
    @Override
    public AssignmentExpression newAssignmentExpression(
            Expression leftHandSide,
            InfixOperator operator,
            Expression rightHandSide) {
        return this.newAssignmentExpression0(
            leftHandSide,
            operator,
            rightHandSide
        );
    }

    private AssignmentExpressionImpl newAssignmentExpression0(
            Expression leftHandSide,
            InfixOperator operator,
            Expression rightHandSide) {
        Util.notNull(leftHandSide, "leftHandSide"); //$NON-NLS-1$
        Util.notNull(operator, "operator"); //$NON-NLS-1$
        Util.notNull(rightHandSide, "rightHandSide"); //$NON-NLS-1$
        AssignmentExpressionImpl result = new AssignmentExpressionImpl();
        result.setLeftHandSide(leftHandSide);
        result.setOperator(operator);
        result.setRightHandSide(rightHandSide);
        return result;
    }

    /**
     * 新しい{@link BasicType}を生成して返す。
     * @param typeKind
     *     基本型の種類
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeKind}に{@code null}が指定された場合
     */
    @Override
    public BasicType newBasicType(
            BasicTypeKind typeKind) {
        return this.newBasicType0(
            typeKind
        );
    }

    private BasicTypeImpl newBasicType0(
            BasicTypeKind typeKind) {
        Util.notNull(typeKind, "typeKind"); //$NON-NLS-1$
        BasicTypeImpl result = new BasicTypeImpl();
        result.setTypeKind(typeKind);
        return result;
    }

    /**
     * 新しい{@link Block}を生成して返す。
     * @param statements
     *     文の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code statements}に{@code null}が指定された場合
     */
    @Override
    public Block newBlock(
            List<? extends Statement> statements) {
        return this.newBlock0(
            statements
        );
    }

    private BlockImpl newBlock0(
            List<? extends Statement> statements) {
        Util.notNull(statements, "statements"); //$NON-NLS-1$
        Util.notContainNull(statements, "statements"); //$NON-NLS-1$
        BlockImpl result = new BlockImpl();
        result.setStatements(statements);
        return result;
    }

    /**
     * 新しい{@link BlockComment}を生成して返す。
     * @param string
     *     コメント文字列
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code string}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code string}に空が指定された場合
     */
    @Override
    public BlockComment newBlockComment(
            String string) {
        return this.newBlockComment0(
            string
        );
    }

    private BlockCommentImpl newBlockComment0(
            String string) {
        Util.notNull(string, "string"); //$NON-NLS-1$
        BlockCommentImpl result = new BlockCommentImpl();
        result.setString(string);
        return result;
    }

    /**
     * 新しい{@link BreakStatement}を生成して返す。
     * @param target
     *     分岐先ラベル、
     *     ただし分岐先ラベルが指定されない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     */
    @Override
    public BreakStatement newBreakStatement(
            SimpleName target) {
        return this.newBreakStatement0(
            target
        );
    }

    private BreakStatementImpl newBreakStatement0(
            SimpleName target) {
        BreakStatementImpl result = new BreakStatementImpl();
        result.setTarget(target);
        return result;
    }

    /**
     * 新しい{@link CastExpression}を生成して返す。
     * @param type
     *     キャスト対象の型
     * @param expression
     *     演算項
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     */
    @Override
    public CastExpression newCastExpression(
            Type type,
            Expression expression) {
        return this.newCastExpression0(
            type,
            expression
        );
    }

    private CastExpressionImpl newCastExpression0(
            Type type,
            Expression expression) {
        Util.notNull(type, "type"); //$NON-NLS-1$
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        CastExpressionImpl result = new CastExpressionImpl();
        result.setType(type);
        result.setExpression(expression);
        return result;
    }

    /**
     * 新しい{@link CatchClause}を生成して返す。
     * @param parameter
     *     例外仮引数
     * @param body
     *     {@code catch}ブロック
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code parameter}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code body}に{@code null}が指定された場合
     */
    @Override
    public CatchClause newCatchClause(
            FormalParameterDeclaration parameter,
            Block body) {
        return this.newCatchClause0(
            parameter,
            body
        );
    }

    private CatchClauseImpl newCatchClause0(
            FormalParameterDeclaration parameter,
            Block body) {
        Util.notNull(parameter, "parameter"); //$NON-NLS-1$
        Util.notNull(body, "body"); //$NON-NLS-1$
        CatchClauseImpl result = new CatchClauseImpl();
        result.setParameter(parameter);
        result.setBody(body);
        return result;
    }

    /**
     * 新しい{@link ClassBody}を生成して返す。
     * @param bodyDeclarations
     *     メンバの一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code bodyDeclarations}に{@code null}が指定された場合
     */
    @Override
    public ClassBody newClassBody(
            List<? extends TypeBodyDeclaration> bodyDeclarations) {
        return this.newClassBody0(
            bodyDeclarations
        );
    }

    private ClassBodyImpl newClassBody0(
            List<? extends TypeBodyDeclaration> bodyDeclarations) {
        Util.notNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        Util.notContainNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        ClassBodyImpl result = new ClassBodyImpl();
        result.setBodyDeclarations(bodyDeclarations);
        return result;
    }

    /**
     * 新しい{@link ClassDeclaration}を生成して返す。
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param name
     *     型の単純名
     * @param typeParameters
     *     仮型引数宣言の一覧
     * @param superClass
     *     親クラス、
     *     ただし親クラスが明示されない場合は{@code null}
     * @param superInterfaceTypes
     *     親インターフェースの一覧
     * @param bodyDeclarations
     *     メンバの一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeParameters}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code superInterfaceTypes}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code bodyDeclarations}に{@code null}が指定された場合
     */
    @Override
    public ClassDeclaration newClassDeclaration(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            SimpleName name,
            List<? extends TypeParameterDeclaration> typeParameters,
            Type superClass,
            List<? extends Type> superInterfaceTypes,
            List<? extends TypeBodyDeclaration> bodyDeclarations) {
        return this.newClassDeclaration0(
            javadoc,
            modifiers,
            name,
            typeParameters,
            superClass,
            superInterfaceTypes,
            bodyDeclarations
        );
    }

    private ClassDeclarationImpl newClassDeclaration0(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            SimpleName name,
            List<? extends TypeParameterDeclaration> typeParameters,
            Type superClass,
            List<? extends Type> superInterfaceTypes,
            List<? extends TypeBodyDeclaration> bodyDeclarations) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        Util.notNull(typeParameters, "typeParameters"); //$NON-NLS-1$
        Util.notContainNull(typeParameters, "typeParameters"); //$NON-NLS-1$
        Util.notNull(superInterfaceTypes, "superInterfaceTypes"); //$NON-NLS-1$
        Util.notContainNull(superInterfaceTypes, "superInterfaceTypes"); //$NON-NLS-1$
        Util.notNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        Util.notContainNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        ClassDeclarationImpl result = new ClassDeclarationImpl();
        result.setJavadoc(javadoc);
        result.setModifiers(modifiers);
        result.setName(name);
        result.setTypeParameters(typeParameters);
        result.setSuperClass(superClass);
        result.setSuperInterfaceTypes(superInterfaceTypes);
        result.setBodyDeclarations(bodyDeclarations);
        return result;
    }

    /**
     * 新しい{@link ClassInstanceCreationExpression}を生成して返す。
     * @param qualifier
     *     限定式、
     *     ただし限定式が指定されない場合は{@code null}
     * @param typeArguments
     *     型引数の一覧
     * @param type
     *     インスタンスを生成する型
     * @param arguments
     *     実引数の一覧
     * @param body
     *     匿名クラス本体、
     *     ただし匿名クラス本体が指定されない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeArguments}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code arguments}に{@code null}が指定された場合
     */
    @Override
    public ClassInstanceCreationExpression newClassInstanceCreationExpression(
            Expression qualifier,
            List<? extends Type> typeArguments,
            Type type,
            List<? extends Expression> arguments,
            ClassBody body) {
        return this.newClassInstanceCreationExpression0(
            qualifier,
            typeArguments,
            type,
            arguments,
            body
        );
    }

    private ClassInstanceCreationExpressionImpl newClassInstanceCreationExpression0(
            Expression qualifier,
            List<? extends Type> typeArguments,
            Type type,
            List<? extends Expression> arguments,
            ClassBody body) {
        Util.notNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        Util.notContainNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        Util.notNull(type, "type"); //$NON-NLS-1$
        Util.notNull(arguments, "arguments"); //$NON-NLS-1$
        Util.notContainNull(arguments, "arguments"); //$NON-NLS-1$
        ClassInstanceCreationExpressionImpl result = new ClassInstanceCreationExpressionImpl();
        result.setQualifier(qualifier);
        result.setTypeArguments(typeArguments);
        result.setType(type);
        result.setArguments(arguments);
        result.setBody(body);
        return result;
    }

    /**
     * 新しい{@link ClassLiteral}を生成して返す。
     * @param type
     *     対象の型
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     */
    @Override
    public ClassLiteral newClassLiteral(
            Type type) {
        return this.newClassLiteral0(
            type
        );
    }

    private ClassLiteralImpl newClassLiteral0(
            Type type) {
        Util.notNull(type, "type"); //$NON-NLS-1$
        ClassLiteralImpl result = new ClassLiteralImpl();
        result.setType(type);
        return result;
    }

    /**
     * 新しい{@link CompilationUnit}を生成して返す。
     * @param packageDeclaration
     *     パッケージ宣言、
     *     ただし無名パッケージ上に存在するコンパイル単位を表現する場合は{@code null}
     * @param importDeclarations
     *     このコンパイル単位で宣言されるインポート宣言の一覧
     * @param typeDeclarations
     *     このコンパイル単位で宣言される型の一覧
     * @param comments
     *     このコンパイル単位に記述されたコメントの一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code importDeclarations}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeDeclarations}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code comments}に{@code null}が指定された場合
     */
    @Override
    public CompilationUnit newCompilationUnit(
            PackageDeclaration packageDeclaration,
            List<? extends ImportDeclaration> importDeclarations,
            List<? extends TypeDeclaration> typeDeclarations,
            List<? extends Comment> comments) {
        return this.newCompilationUnit0(
            packageDeclaration,
            importDeclarations,
            typeDeclarations,
            comments
        );
    }

    private CompilationUnitImpl newCompilationUnit0(
            PackageDeclaration packageDeclaration,
            List<? extends ImportDeclaration> importDeclarations,
            List<? extends TypeDeclaration> typeDeclarations,
            List<? extends Comment> comments) {
        Util.notNull(importDeclarations, "importDeclarations"); //$NON-NLS-1$
        Util.notContainNull(importDeclarations, "importDeclarations"); //$NON-NLS-1$
        Util.notNull(typeDeclarations, "typeDeclarations"); //$NON-NLS-1$
        Util.notContainNull(typeDeclarations, "typeDeclarations"); //$NON-NLS-1$
        Util.notNull(comments, "comments"); //$NON-NLS-1$
        Util.notContainNull(comments, "comments"); //$NON-NLS-1$
        CompilationUnitImpl result = new CompilationUnitImpl();
        result.setPackageDeclaration(packageDeclaration);
        result.setImportDeclarations(importDeclarations);
        result.setTypeDeclarations(typeDeclarations);
        result.setComments(comments);
        return result;
    }

    /**
     * 新しい{@link ConditionalExpression}を生成して返す。
     * @param condition
     *     条件式
     * @param thenExpression
     *     条件成立時に評価される式
     * @param elseExpression
     *     条件不成立時に評価される式
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code condition}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code thenExpression}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code elseExpression}に{@code null}が指定された場合
     */
    @Override
    public ConditionalExpression newConditionalExpression(
            Expression condition,
            Expression thenExpression,
            Expression elseExpression) {
        return this.newConditionalExpression0(
            condition,
            thenExpression,
            elseExpression
        );
    }

    private ConditionalExpressionImpl newConditionalExpression0(
            Expression condition,
            Expression thenExpression,
            Expression elseExpression) {
        Util.notNull(condition, "condition"); //$NON-NLS-1$
        Util.notNull(thenExpression, "thenExpression"); //$NON-NLS-1$
        Util.notNull(elseExpression, "elseExpression"); //$NON-NLS-1$
        ConditionalExpressionImpl result = new ConditionalExpressionImpl();
        result.setCondition(condition);
        result.setThenExpression(thenExpression);
        result.setElseExpression(elseExpression);
        return result;
    }

    /**
     * 新しい{@link ConstructorDeclaration}を生成して返す。
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param typeParameters
     *     型引数宣言の一覧
     * @param name
     *     メソッドまたはコンストラクタの名前
     * @param formalParameters
     *     仮引数宣言の一覧
     * @param exceptionTypes
     *     例外型宣言の一覧
     * @param body
     *     コンストラクタ本体
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeParameters}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code formalParameters}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code exceptionTypes}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code body}に{@code null}が指定された場合
     */
    @Override
    public ConstructorDeclaration newConstructorDeclaration(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            List<? extends TypeParameterDeclaration> typeParameters,
            SimpleName name,
            List<? extends FormalParameterDeclaration> formalParameters,
            List<? extends Type> exceptionTypes,
            Block body) {
        return this.newConstructorDeclaration0(
            javadoc,
            modifiers,
            typeParameters,
            name,
            formalParameters,
            exceptionTypes,
            body
        );
    }

    private ConstructorDeclarationImpl newConstructorDeclaration0(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            List<? extends TypeParameterDeclaration> typeParameters,
            SimpleName name,
            List<? extends FormalParameterDeclaration> formalParameters,
            List<? extends Type> exceptionTypes,
            Block body) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(typeParameters, "typeParameters"); //$NON-NLS-1$
        Util.notContainNull(typeParameters, "typeParameters"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        Util.notNull(formalParameters, "formalParameters"); //$NON-NLS-1$
        Util.notContainNull(formalParameters, "formalParameters"); //$NON-NLS-1$
        Util.notNull(exceptionTypes, "exceptionTypes"); //$NON-NLS-1$
        Util.notContainNull(exceptionTypes, "exceptionTypes"); //$NON-NLS-1$
        Util.notNull(body, "body"); //$NON-NLS-1$
        ConstructorDeclarationImpl result = new ConstructorDeclarationImpl();
        result.setJavadoc(javadoc);
        result.setModifiers(modifiers);
        result.setTypeParameters(typeParameters);
        result.setName(name);
        result.setFormalParameters(formalParameters);
        result.setExceptionTypes(exceptionTypes);
        result.setBody(body);
        return result;
    }

    /**
     * 新しい{@link ContinueStatement}を生成して返す。
     * @param target
     *     分岐先ラベル、
     *     ただし分岐先ラベルが指定されない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     */
    @Override
    public ContinueStatement newContinueStatement(
            SimpleName target) {
        return this.newContinueStatement0(
            target
        );
    }

    private ContinueStatementImpl newContinueStatement0(
            SimpleName target) {
        ContinueStatementImpl result = new ContinueStatementImpl();
        result.setTarget(target);
        return result;
    }

    /**
     * 新しい{@link DoStatement}を生成して返す。
     * @param body
     *     ループ本体
     * @param condition
     *     条件式
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code body}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code condition}に{@code null}が指定された場合
     */
    @Override
    public DoStatement newDoStatement(
            Statement body,
            Expression condition) {
        return this.newDoStatement0(
            body,
            condition
        );
    }

    private DoStatementImpl newDoStatement0(
            Statement body,
            Expression condition) {
        Util.notNull(body, "body"); //$NON-NLS-1$
        Util.notNull(condition, "condition"); //$NON-NLS-1$
        DoStatementImpl result = new DoStatementImpl();
        result.setBody(body);
        result.setCondition(condition);
        return result;
    }

    /**
     * 新しい{@link DocBlock}を生成して返す。
     * @param tag
     *     タグ文字列
     * @param elements
     *     インライン要素の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code tag}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code elements}に{@code null}が指定された場合
     */
    @Override
    public DocBlock newDocBlock(
            String tag,
            List<? extends DocElement> elements) {
        return this.newDocBlock0(
            tag,
            elements
        );
    }

    private DocBlockImpl newDocBlock0(
            String tag,
            List<? extends DocElement> elements) {
        Util.notNull(tag, "tag"); //$NON-NLS-1$
        Util.notNull(elements, "elements"); //$NON-NLS-1$
        Util.notContainNull(elements, "elements"); //$NON-NLS-1$
        DocBlockImpl result = new DocBlockImpl();
        result.setTag(tag);
        result.setElements(elements);
        return result;
    }

    /**
     * 新しい{@link DocField}を生成して返す。
     * @param type
     *     フィールドを宣言した型、
     *     ただし宣言型が指定されない場合は{@code null}
     * @param name
     *     フィールドの名称
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     */
    @Override
    public DocField newDocField(
            Type type,
            SimpleName name) {
        return this.newDocField0(
            type,
            name
        );
    }

    private DocFieldImpl newDocField0(
            Type type,
            SimpleName name) {
        Util.notNull(name, "name"); //$NON-NLS-1$
        DocFieldImpl result = new DocFieldImpl();
        result.setType(type);
        result.setName(name);
        return result;
    }

    /**
     * 新しい{@link DocMethod}を生成して返す。
     * @param type
     *     メソッドまたはコンストラクタの宣言型、
     *     ただし宣言型が指定されない場合は{@code null}
     * @param name
     *     メソッドまたはコンストラクタの名前
     * @param formalParameters
     *     メソッドまたはコンストラクタの仮引数宣言の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code formalParameters}に{@code null}が指定された場合
     */
    @Override
    public DocMethod newDocMethod(
            Type type,
            SimpleName name,
            List<? extends DocMethodParameter> formalParameters) {
        return this.newDocMethod0(
            type,
            name,
            formalParameters
        );
    }

    private DocMethodImpl newDocMethod0(
            Type type,
            SimpleName name,
            List<? extends DocMethodParameter> formalParameters) {
        Util.notNull(name, "name"); //$NON-NLS-1$
        Util.notNull(formalParameters, "formalParameters"); //$NON-NLS-1$
        Util.notContainNull(formalParameters, "formalParameters"); //$NON-NLS-1$
        DocMethodImpl result = new DocMethodImpl();
        result.setType(type);
        result.setName(name);
        result.setFormalParameters(formalParameters);
        return result;
    }

    /**
     * 新しい{@link DocMethodParameter}を生成して返す。
     * @param type
     *     仮引数の型
     * @param name
     *     仮引数の名前、
     *     ただし仮引数の名前が省略される場合は{@code null}
     * @param variableArity
     *     可変長引数
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     */
    @Override
    public DocMethodParameter newDocMethodParameter(
            Type type,
            SimpleName name,
            boolean variableArity) {
        return this.newDocMethodParameter0(
            type,
            name,
            variableArity
        );
    }

    private DocMethodParameterImpl newDocMethodParameter0(
            Type type,
            SimpleName name,
            boolean variableArity) {
        Util.notNull(type, "type"); //$NON-NLS-1$
        DocMethodParameterImpl result = new DocMethodParameterImpl();
        result.setType(type);
        result.setName(name);
        result.setVariableArity(variableArity);
        return result;
    }

    /**
     * 新しい{@link DocText}を生成して返す。
     * @param string
     *     テキストを構成する文字列
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code string}に{@code null}が指定された場合
     */
    @Override
    public DocText newDocText(
            String string) {
        return this.newDocText0(
            string
        );
    }

    private DocTextImpl newDocText0(
            String string) {
        Util.notNull(string, "string"); //$NON-NLS-1$
        DocTextImpl result = new DocTextImpl();
        result.setString(string);
        return result;
    }

    /**
     * 新しい{@link EmptyStatement}を生成して返す。
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     */
    @Override
    public EmptyStatement newEmptyStatement(
            ) {
        return this.newEmptyStatement0(

        );
    }

    private EmptyStatementImpl newEmptyStatement0(
            ) {
        EmptyStatementImpl result = new EmptyStatementImpl();
        return result;
    }

    /**
     * 新しい{@link EnhancedForStatement}を生成して返す。
     * @param parameter
     *     ループ変数
     * @param expression
     *     ループ対象式
     * @param body
     *     ループ本体
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code parameter}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code body}に{@code null}が指定された場合
     */
    @Override
    public EnhancedForStatement newEnhancedForStatement(
            FormalParameterDeclaration parameter,
            Expression expression,
            Statement body) {
        return this.newEnhancedForStatement0(
            parameter,
            expression,
            body
        );
    }

    private EnhancedForStatementImpl newEnhancedForStatement0(
            FormalParameterDeclaration parameter,
            Expression expression,
            Statement body) {
        Util.notNull(parameter, "parameter"); //$NON-NLS-1$
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        Util.notNull(body, "body"); //$NON-NLS-1$
        EnhancedForStatementImpl result = new EnhancedForStatementImpl();
        result.setParameter(parameter);
        result.setExpression(expression);
        result.setBody(body);
        return result;
    }

    /**
     * 新しい{@link EnumConstantDeclaration}を生成して返す。
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param name
     *     列挙定数の名前
     * @param arguments
     *     コンストラクタ引数の一覧
     * @param body
     *     クラス本体の宣言、
     *     ただしクラスの本体が宣言されない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code arguments}に{@code null}が指定された場合
     */
    @Override
    public EnumConstantDeclaration newEnumConstantDeclaration(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            SimpleName name,
            List<? extends Expression> arguments,
            ClassBody body) {
        return this.newEnumConstantDeclaration0(
            javadoc,
            modifiers,
            name,
            arguments,
            body
        );
    }

    private EnumConstantDeclarationImpl newEnumConstantDeclaration0(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            SimpleName name,
            List<? extends Expression> arguments,
            ClassBody body) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        Util.notNull(arguments, "arguments"); //$NON-NLS-1$
        Util.notContainNull(arguments, "arguments"); //$NON-NLS-1$
        EnumConstantDeclarationImpl result = new EnumConstantDeclarationImpl();
        result.setJavadoc(javadoc);
        result.setModifiers(modifiers);
        result.setName(name);
        result.setArguments(arguments);
        result.setBody(body);
        return result;
    }

    /**
     * 新しい{@link EnumDeclaration}を生成して返す。
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param name
     *     型の単純名
     * @param superInterfaceTypes
     *     親インターフェースの一覧
     * @param constantDeclarations
     *     列挙定数の一覧
     * @param bodyDeclarations
     *     メンバの一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code superInterfaceTypes}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code constantDeclarations}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code bodyDeclarations}に{@code null}が指定された場合
     */
    @Override
    public EnumDeclaration newEnumDeclaration(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            SimpleName name,
            List<? extends Type> superInterfaceTypes,
            List<? extends EnumConstantDeclaration> constantDeclarations,
            List<? extends TypeBodyDeclaration> bodyDeclarations) {
        return this.newEnumDeclaration0(
            javadoc,
            modifiers,
            name,
            superInterfaceTypes,
            constantDeclarations,
            bodyDeclarations
        );
    }

    private EnumDeclarationImpl newEnumDeclaration0(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            SimpleName name,
            List<? extends Type> superInterfaceTypes,
            List<? extends EnumConstantDeclaration> constantDeclarations,
            List<? extends TypeBodyDeclaration> bodyDeclarations) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        Util.notNull(superInterfaceTypes, "superInterfaceTypes"); //$NON-NLS-1$
        Util.notContainNull(superInterfaceTypes, "superInterfaceTypes"); //$NON-NLS-1$
        Util.notNull(constantDeclarations, "constantDeclarations"); //$NON-NLS-1$
        Util.notContainNull(constantDeclarations, "constantDeclarations"); //$NON-NLS-1$
        Util.notNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        Util.notContainNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        EnumDeclarationImpl result = new EnumDeclarationImpl();
        result.setJavadoc(javadoc);
        result.setModifiers(modifiers);
        result.setName(name);
        result.setSuperInterfaceTypes(superInterfaceTypes);
        result.setConstantDeclarations(constantDeclarations);
        result.setBodyDeclarations(bodyDeclarations);
        return result;
    }

    /**
     * 新しい{@link ExpressionStatement}を生成して返す。
     * @param expression
     *     内包する式
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     */
    @Override
    public ExpressionStatement newExpressionStatement(
            Expression expression) {
        return this.newExpressionStatement0(
            expression
        );
    }

    private ExpressionStatementImpl newExpressionStatement0(
            Expression expression) {
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        ExpressionStatementImpl result = new ExpressionStatementImpl();
        result.setExpression(expression);
        return result;
    }

    /**
     * 新しい{@link FieldAccessExpression}を生成して返す。
     * @param qualifier
     *     限定式
     * @param name
     *     フィールドの名前
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code qualifier}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     */
    @Override
    public FieldAccessExpression newFieldAccessExpression(
            Expression qualifier,
            SimpleName name) {
        return this.newFieldAccessExpression0(
            qualifier,
            name
        );
    }

    private FieldAccessExpressionImpl newFieldAccessExpression0(
            Expression qualifier,
            SimpleName name) {
        Util.notNull(qualifier, "qualifier"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        FieldAccessExpressionImpl result = new FieldAccessExpressionImpl();
        result.setQualifier(qualifier);
        result.setName(name);
        return result;
    }

    /**
     * 新しい{@link FieldDeclaration}を生成して返す。
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param type
     *     フィールドの型
     * @param variableDeclarators
     *     宣言するフィールドの一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code variableDeclarators}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code variableDeclarators}に空が指定された場合
     */
    @Override
    public FieldDeclaration newFieldDeclaration(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            Type type,
            List<? extends VariableDeclarator> variableDeclarators) {
        return this.newFieldDeclaration0(
            javadoc,
            modifiers,
            type,
            variableDeclarators
        );
    }

    private FieldDeclarationImpl newFieldDeclaration0(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            Type type,
            List<? extends VariableDeclarator> variableDeclarators) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(type, "type"); //$NON-NLS-1$
        Util.notNull(variableDeclarators, "variableDeclarators"); //$NON-NLS-1$
        Util.notContainNull(variableDeclarators, "variableDeclarators"); //$NON-NLS-1$
        Util.notEmpty(variableDeclarators, "variableDeclarators"); //$NON-NLS-1$
        FieldDeclarationImpl result = new FieldDeclarationImpl();
        result.setJavadoc(javadoc);
        result.setModifiers(modifiers);
        result.setType(type);
        result.setVariableDeclarators(variableDeclarators);
        return result;
    }

    /**
     * 新しい{@link ForStatement}を生成して返す。
     * @param initialization
     *     ループ初期化部、
     *     ただしループ初期化部が指定されない場合は{@code null}
     * @param condition
     *     ループ条件式、
     *     ただしループ条件が指定されない場合は{@code null}
     * @param update
     *     ループ更新部、
     *     ただしループ更新部が指定されない場合は{@code null}
     * @param body
     *     ループ本体
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code body}に{@code null}が指定された場合
     */
    @Override
    public ForStatement newForStatement(
            ForInitializer initialization,
            Expression condition,
            StatementExpressionList update,
            Statement body) {
        return this.newForStatement0(
            initialization,
            condition,
            update,
            body
        );
    }

    private ForStatementImpl newForStatement0(
            ForInitializer initialization,
            Expression condition,
            StatementExpressionList update,
            Statement body) {
        Util.notNull(body, "body"); //$NON-NLS-1$
        ForStatementImpl result = new ForStatementImpl();
        result.setInitialization(initialization);
        result.setCondition(condition);
        result.setUpdate(update);
        result.setBody(body);
        return result;
    }

    /**
     * 新しい{@link FormalParameterDeclaration}を生成して返す。
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param type
     *     宣言する変数の型
     * @param variableArity
     *     可変長引数
     * @param name
     *     仮引数の名前
     * @param extraDimensions
     *     追加次元数の宣言
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code extraDimensions}に負の値が指定された場合
     */
    @Override
    public FormalParameterDeclaration newFormalParameterDeclaration(
            List<? extends Attribute> modifiers,
            Type type,
            boolean variableArity,
            SimpleName name,
            int extraDimensions) {
        return this.newFormalParameterDeclaration0(
            modifiers,
            type,
            variableArity,
            name,
            extraDimensions
        );
    }

    private FormalParameterDeclarationImpl newFormalParameterDeclaration0(
            List<? extends Attribute> modifiers,
            Type type,
            boolean variableArity,
            SimpleName name,
            int extraDimensions) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(type, "type"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        FormalParameterDeclarationImpl result = new FormalParameterDeclarationImpl();
        result.setModifiers(modifiers);
        result.setType(type);
        result.setVariableArity(variableArity);
        result.setName(name);
        result.setExtraDimensions(extraDimensions);
        return result;
    }

    /**
     * 新しい{@link IfStatement}を生成して返す。
     * @param condition
     *     条件式
     * @param thenStatement
     *     条件成立時に実行される文
     * @param elseStatement
     *     条件不成立時に実行される文、
     *     ただしこの文が{@code if-then}文である場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code condition}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code thenStatement}に{@code null}が指定された場合
     */
    @Override
    public IfStatement newIfStatement(
            Expression condition,
            Statement thenStatement,
            Statement elseStatement) {
        return this.newIfStatement0(
            condition,
            thenStatement,
            elseStatement
        );
    }

    private IfStatementImpl newIfStatement0(
            Expression condition,
            Statement thenStatement,
            Statement elseStatement) {
        Util.notNull(condition, "condition"); //$NON-NLS-1$
        Util.notNull(thenStatement, "thenStatement"); //$NON-NLS-1$
        IfStatementImpl result = new IfStatementImpl();
        result.setCondition(condition);
        result.setThenStatement(thenStatement);
        result.setElseStatement(elseStatement);
        return result;
    }

    /**
     * 新しい{@link ImportDeclaration}を生成して返す。
     * @param importKind
     *     インポートの種類
     * @param name
     *     インポートする型およびメンバの名前
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code importKind}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     */
    @Override
    public ImportDeclaration newImportDeclaration(
            ImportKind importKind,
            Name name) {
        return this.newImportDeclaration0(
            importKind,
            name
        );
    }

    private ImportDeclarationImpl newImportDeclaration0(
            ImportKind importKind,
            Name name) {
        Util.notNull(importKind, "importKind"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        ImportDeclarationImpl result = new ImportDeclarationImpl();
        result.setImportKind(importKind);
        result.setName(name);
        return result;
    }

    /**
     * 新しい{@link InfixExpression}を生成して返す。
     * @param leftOperand
     *     第一演算項
     * @param operator
     *     二項演算子
     * @param rightOperand
     *     第二演算項
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code leftOperand}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code operator}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code rightOperand}に{@code null}が指定された場合
     */
    @Override
    public InfixExpression newInfixExpression(
            Expression leftOperand,
            InfixOperator operator,
            Expression rightOperand) {
        return this.newInfixExpression0(
            leftOperand,
            operator,
            rightOperand
        );
    }

    private InfixExpressionImpl newInfixExpression0(
            Expression leftOperand,
            InfixOperator operator,
            Expression rightOperand) {
        Util.notNull(leftOperand, "leftOperand"); //$NON-NLS-1$
        Util.notNull(operator, "operator"); //$NON-NLS-1$
        Util.notNull(rightOperand, "rightOperand"); //$NON-NLS-1$
        InfixExpressionImpl result = new InfixExpressionImpl();
        result.setLeftOperand(leftOperand);
        result.setOperator(operator);
        result.setRightOperand(rightOperand);
        return result;
    }

    /**
     * 新しい{@link InitializerDeclaration}を生成して返す。
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param body
     *     初期化子の本体
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code body}に{@code null}が指定された場合
     */
    @Override
    public InitializerDeclaration newInitializerDeclaration(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            Block body) {
        return this.newInitializerDeclaration0(
            javadoc,
            modifiers,
            body
        );
    }

    private InitializerDeclarationImpl newInitializerDeclaration0(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            Block body) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(body, "body"); //$NON-NLS-1$
        InitializerDeclarationImpl result = new InitializerDeclarationImpl();
        result.setJavadoc(javadoc);
        result.setModifiers(modifiers);
        result.setBody(body);
        return result;
    }

    /**
     * 新しい{@link InstanceofExpression}を生成して返す。
     * @param expression
     *     被演算項
     * @param type
     *     比較対象型
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     */
    @Override
    public InstanceofExpression newInstanceofExpression(
            Expression expression,
            Type type) {
        return this.newInstanceofExpression0(
            expression,
            type
        );
    }

    private InstanceofExpressionImpl newInstanceofExpression0(
            Expression expression,
            Type type) {
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        Util.notNull(type, "type"); //$NON-NLS-1$
        InstanceofExpressionImpl result = new InstanceofExpressionImpl();
        result.setExpression(expression);
        result.setType(type);
        return result;
    }

    /**
     * 新しい{@link InterfaceDeclaration}を生成して返す。
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param name
     *     型の単純名
     * @param typeParameters
     *     仮型引数宣言の一覧
     * @param superInterfaceTypes
     *     親インターフェースの一覧
     * @param bodyDeclarations
     *     メンバの一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeParameters}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code superInterfaceTypes}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code bodyDeclarations}に{@code null}が指定された場合
     */
    @Override
    public InterfaceDeclaration newInterfaceDeclaration(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            SimpleName name,
            List<? extends TypeParameterDeclaration> typeParameters,
            List<? extends Type> superInterfaceTypes,
            List<? extends TypeBodyDeclaration> bodyDeclarations) {
        return this.newInterfaceDeclaration0(
            javadoc,
            modifiers,
            name,
            typeParameters,
            superInterfaceTypes,
            bodyDeclarations
        );
    }

    private InterfaceDeclarationImpl newInterfaceDeclaration0(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            SimpleName name,
            List<? extends TypeParameterDeclaration> typeParameters,
            List<? extends Type> superInterfaceTypes,
            List<? extends TypeBodyDeclaration> bodyDeclarations) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        Util.notNull(typeParameters, "typeParameters"); //$NON-NLS-1$
        Util.notContainNull(typeParameters, "typeParameters"); //$NON-NLS-1$
        Util.notNull(superInterfaceTypes, "superInterfaceTypes"); //$NON-NLS-1$
        Util.notContainNull(superInterfaceTypes, "superInterfaceTypes"); //$NON-NLS-1$
        Util.notNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        Util.notContainNull(bodyDeclarations, "bodyDeclarations"); //$NON-NLS-1$
        InterfaceDeclarationImpl result = new InterfaceDeclarationImpl();
        result.setJavadoc(javadoc);
        result.setModifiers(modifiers);
        result.setName(name);
        result.setTypeParameters(typeParameters);
        result.setSuperInterfaceTypes(superInterfaceTypes);
        result.setBodyDeclarations(bodyDeclarations);
        return result;
    }

    /**
     * 新しい{@link Javadoc}を生成して返す。
     * @param blocks
     *     ブロックの一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code blocks}に{@code null}が指定された場合
     */
    @Override
    public Javadoc newJavadoc(
            List<? extends DocBlock> blocks) {
        return this.newJavadoc0(
            blocks
        );
    }

    private JavadocImpl newJavadoc0(
            List<? extends DocBlock> blocks) {
        Util.notNull(blocks, "blocks"); //$NON-NLS-1$
        Util.notContainNull(blocks, "blocks"); //$NON-NLS-1$
        JavadocImpl result = new JavadocImpl();
        result.setBlocks(blocks);
        return result;
    }

    /**
     * 新しい{@link LabeledStatement}を生成して返す。
     * @param label
     *     ラベルの名前
     * @param body
     *     対象の文
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code label}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code body}に{@code null}が指定された場合
     */
    @Override
    public LabeledStatement newLabeledStatement(
            SimpleName label,
            Statement body) {
        return this.newLabeledStatement0(
            label,
            body
        );
    }

    private LabeledStatementImpl newLabeledStatement0(
            SimpleName label,
            Statement body) {
        Util.notNull(label, "label"); //$NON-NLS-1$
        Util.notNull(body, "body"); //$NON-NLS-1$
        LabeledStatementImpl result = new LabeledStatementImpl();
        result.setLabel(label);
        result.setBody(body);
        return result;
    }

    /**
     * 新しい{@link LineComment}を生成して返す。
     * @param string
     *     コメント文字列
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code string}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code string}に空が指定された場合
     */
    @Override
    public LineComment newLineComment(
            String string) {
        return this.newLineComment0(
            string
        );
    }

    private LineCommentImpl newLineComment0(
            String string) {
        Util.notNull(string, "string"); //$NON-NLS-1$
        LineCommentImpl result = new LineCommentImpl();
        result.setString(string);
        return result;
    }

    /**
     * 新しい{@link Literal}を生成して返す。
     * @param token
     *     このリテラルを構成する字句
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code token}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code token}に空が指定された場合
     */
    @Override
    public Literal newLiteral(
            String token) {
        return this.newLiteral0(
            token
        );
    }

    private LiteralImpl newLiteral0(
            String token) {
        Util.notNull(token, "token"); //$NON-NLS-1$
        LiteralImpl result = new LiteralImpl();
        result.setToken(token);
        return result;
    }

    /**
     * 新しい{@link LocalClassDeclaration}を生成して返す。
     * @param declaration
     *     宣言するクラス
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code declaration}に{@code null}が指定された場合
     */
    @Override
    public LocalClassDeclaration newLocalClassDeclaration(
            ClassDeclaration declaration) {
        return this.newLocalClassDeclaration0(
            declaration
        );
    }

    private LocalClassDeclarationImpl newLocalClassDeclaration0(
            ClassDeclaration declaration) {
        Util.notNull(declaration, "declaration"); //$NON-NLS-1$
        LocalClassDeclarationImpl result = new LocalClassDeclarationImpl();
        result.setDeclaration(declaration);
        return result;
    }

    /**
     * 新しい{@link LocalVariableDeclaration}を生成して返す。
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param type
     *     宣言する変数の型
     * @param variableDeclarators
     *     宣言する変数の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code variableDeclarators}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code variableDeclarators}に空が指定された場合
     */
    @Override
    public LocalVariableDeclaration newLocalVariableDeclaration(
            List<? extends Attribute> modifiers,
            Type type,
            List<? extends VariableDeclarator> variableDeclarators) {
        return this.newLocalVariableDeclaration0(
            modifiers,
            type,
            variableDeclarators
        );
    }

    private LocalVariableDeclarationImpl newLocalVariableDeclaration0(
            List<? extends Attribute> modifiers,
            Type type,
            List<? extends VariableDeclarator> variableDeclarators) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(type, "type"); //$NON-NLS-1$
        Util.notNull(variableDeclarators, "variableDeclarators"); //$NON-NLS-1$
        Util.notContainNull(variableDeclarators, "variableDeclarators"); //$NON-NLS-1$
        Util.notEmpty(variableDeclarators, "variableDeclarators"); //$NON-NLS-1$
        LocalVariableDeclarationImpl result = new LocalVariableDeclarationImpl();
        result.setModifiers(modifiers);
        result.setType(type);
        result.setVariableDeclarators(variableDeclarators);
        return result;
    }

    /**
     * 新しい{@link MarkerAnnotation}を生成して返す。
     * @param type
     *     注釈の型
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     */
    @Override
    public MarkerAnnotation newMarkerAnnotation(
            NamedType type) {
        return this.newMarkerAnnotation0(
            type
        );
    }

    private MarkerAnnotationImpl newMarkerAnnotation0(
            NamedType type) {
        Util.notNull(type, "type"); //$NON-NLS-1$
        MarkerAnnotationImpl result = new MarkerAnnotationImpl();
        result.setType(type);
        return result;
    }

    /**
     * 新しい{@link MethodDeclaration}を生成して返す。
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     * @param modifiers
     *     修飾子および注釈の一覧
     * @param typeParameters
     *     型引数宣言の一覧
     * @param returnType
     *     戻り値の型
     * @param name
     *     メソッドまたはコンストラクタの名前
     * @param formalParameters
     *     仮引数宣言の一覧
     * @param extraDimensions
     *     戻り値の次元数
     * @param exceptionTypes
     *     例外型宣言の一覧
     * @param body
     *     メソッドまたはコンストラクタ本体、
     *     ただしこのメソッドが本体を提供されない抽象メソッドやインターフェースメソッドである場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifiers}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeParameters}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code returnType}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code formalParameters}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code extraDimensions}に負の値が指定された場合
     * @throws IllegalArgumentException
     *     {@code exceptionTypes}に{@code null}が指定された場合
     */
    @Override
    public MethodDeclaration newMethodDeclaration(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            List<? extends TypeParameterDeclaration> typeParameters,
            Type returnType,
            SimpleName name,
            List<? extends FormalParameterDeclaration> formalParameters,
            int extraDimensions,
            List<? extends Type> exceptionTypes,
            Block body) {
        return this.newMethodDeclaration0(
            javadoc,
            modifiers,
            typeParameters,
            returnType,
            name,
            formalParameters,
            extraDimensions,
            exceptionTypes,
            body
        );
    }

    private MethodDeclarationImpl newMethodDeclaration0(
            Javadoc javadoc,
            List<? extends Attribute> modifiers,
            List<? extends TypeParameterDeclaration> typeParameters,
            Type returnType,
            SimpleName name,
            List<? extends FormalParameterDeclaration> formalParameters,
            int extraDimensions,
            List<? extends Type> exceptionTypes,
            Block body) {
        Util.notNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notContainNull(modifiers, "modifiers"); //$NON-NLS-1$
        Util.notNull(typeParameters, "typeParameters"); //$NON-NLS-1$
        Util.notContainNull(typeParameters, "typeParameters"); //$NON-NLS-1$
        Util.notNull(returnType, "returnType"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        Util.notNull(formalParameters, "formalParameters"); //$NON-NLS-1$
        Util.notContainNull(formalParameters, "formalParameters"); //$NON-NLS-1$
        Util.notNull(exceptionTypes, "exceptionTypes"); //$NON-NLS-1$
        Util.notContainNull(exceptionTypes, "exceptionTypes"); //$NON-NLS-1$
        MethodDeclarationImpl result = new MethodDeclarationImpl();
        result.setJavadoc(javadoc);
        result.setModifiers(modifiers);
        result.setTypeParameters(typeParameters);
        result.setReturnType(returnType);
        result.setName(name);
        result.setFormalParameters(formalParameters);
        result.setExtraDimensions(extraDimensions);
        result.setExceptionTypes(exceptionTypes);
        result.setBody(body);
        return result;
    }

    /**
     * 新しい{@link MethodInvocationExpression}を生成して返す。
     * @param qualifier
     *     限定式、または型限定子、
     *     ただし限定式が指定されない場合(単純メソッド起動)は{@code null}
     * @param typeArguments
     *     型引数の一覧
     * @param name
     *     メソッドの名前
     * @param arguments
     *     実引数の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeArguments}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code arguments}に{@code null}が指定された場合
     */
    @Override
    public MethodInvocationExpression newMethodInvocationExpression(
            Expression qualifier,
            List<? extends Type> typeArguments,
            SimpleName name,
            List<? extends Expression> arguments) {
        return this.newMethodInvocationExpression0(
            qualifier,
            typeArguments,
            name,
            arguments
        );
    }

    private MethodInvocationExpressionImpl newMethodInvocationExpression0(
            Expression qualifier,
            List<? extends Type> typeArguments,
            SimpleName name,
            List<? extends Expression> arguments) {
        Util.notNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        Util.notContainNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        Util.notNull(arguments, "arguments"); //$NON-NLS-1$
        Util.notContainNull(arguments, "arguments"); //$NON-NLS-1$
        MethodInvocationExpressionImpl result = new MethodInvocationExpressionImpl();
        result.setQualifier(qualifier);
        result.setTypeArguments(typeArguments);
        result.setName(name);
        result.setArguments(arguments);
        return result;
    }

    /**
     * 新しい{@link Modifier}を生成して返す。
     * @param modifierKind
     *     修飾子の種類
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code modifierKind}に{@code null}が指定された場合
     */
    @Override
    public Modifier newModifier(
            ModifierKind modifierKind) {
        return this.newModifier0(
            modifierKind
        );
    }

    private ModifierImpl newModifier0(
            ModifierKind modifierKind) {
        Util.notNull(modifierKind, "modifierKind"); //$NON-NLS-1$
        ModifierImpl result = new ModifierImpl();
        result.setModifierKind(modifierKind);
        return result;
    }

    /**
     * 新しい{@link NamedType}を生成して返す。
     * @param name
     *     型の名前
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     */
    @Override
    public NamedType newNamedType(
            Name name) {
        return this.newNamedType0(
            name
        );
    }

    private NamedTypeImpl newNamedType0(
            Name name) {
        Util.notNull(name, "name"); //$NON-NLS-1$
        NamedTypeImpl result = new NamedTypeImpl();
        result.setName(name);
        return result;
    }

    /**
     * 新しい{@link NormalAnnotation}を生成して返す。
     * @param type
     *     注釈の型
     * @param elements
     *     注釈要素の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code elements}に{@code null}が指定された場合
     */
    @Override
    public NormalAnnotation newNormalAnnotation(
            NamedType type,
            List<? extends AnnotationElement> elements) {
        return this.newNormalAnnotation0(
            type,
            elements
        );
    }

    private NormalAnnotationImpl newNormalAnnotation0(
            NamedType type,
            List<? extends AnnotationElement> elements) {
        Util.notNull(type, "type"); //$NON-NLS-1$
        Util.notNull(elements, "elements"); //$NON-NLS-1$
        Util.notContainNull(elements, "elements"); //$NON-NLS-1$
        NormalAnnotationImpl result = new NormalAnnotationImpl();
        result.setType(type);
        result.setElements(elements);
        return result;
    }

    /**
     * 新しい{@link PackageDeclaration}を生成して返す。
     * @param javadoc
     *     ドキュメンテーションコメント、
     *     ただしドキュメンテーションコメントが存在しない場合は{@code null}
     * @param annotations
     *     注釈の一覧
     * @param name
     *     宣言するパッケージの名称
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code annotations}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     */
    @Override
    public PackageDeclaration newPackageDeclaration(
            Javadoc javadoc,
            List<? extends Annotation> annotations,
            Name name) {
        return this.newPackageDeclaration0(
            javadoc,
            annotations,
            name
        );
    }

    private PackageDeclarationImpl newPackageDeclaration0(
            Javadoc javadoc,
            List<? extends Annotation> annotations,
            Name name) {
        Util.notNull(annotations, "annotations"); //$NON-NLS-1$
        Util.notContainNull(annotations, "annotations"); //$NON-NLS-1$
        Util.notNull(name, "name"); //$NON-NLS-1$
        PackageDeclarationImpl result = new PackageDeclarationImpl();
        result.setJavadoc(javadoc);
        result.setAnnotations(annotations);
        result.setName(name);
        return result;
    }

    /**
     * 新しい{@link ParameterizedType}を生成して返す。
     * @param type
     *     パラメータ化されていない型
     * @param typeArguments
     *     型引数の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeArguments}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeArguments}に空が指定された場合
     */
    @Override
    public ParameterizedType newParameterizedType(
            Type type,
            List<? extends Type> typeArguments) {
        return this.newParameterizedType0(
            type,
            typeArguments
        );
    }

    private ParameterizedTypeImpl newParameterizedType0(
            Type type,
            List<? extends Type> typeArguments) {
        Util.notNull(type, "type"); //$NON-NLS-1$
        Util.notNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        Util.notContainNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        Util.notEmpty(typeArguments, "typeArguments"); //$NON-NLS-1$
        ParameterizedTypeImpl result = new ParameterizedTypeImpl();
        result.setType(type);
        result.setTypeArguments(typeArguments);
        return result;
    }

    /**
     * 新しい{@link ParenthesizedExpression}を生成して返す。
     * @param expression
     *     内包する式
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     */
    @Override
    public ParenthesizedExpression newParenthesizedExpression(
            Expression expression) {
        return this.newParenthesizedExpression0(
            expression
        );
    }

    private ParenthesizedExpressionImpl newParenthesizedExpression0(
            Expression expression) {
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        ParenthesizedExpressionImpl result = new ParenthesizedExpressionImpl();
        result.setExpression(expression);
        return result;
    }

    /**
     * 新しい{@link PostfixExpression}を生成して返す。
     * @param operand
     *     後置演算項
     * @param operator
     *     演算子
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code operand}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code operator}に{@code null}が指定された場合
     */
    @Override
    public PostfixExpression newPostfixExpression(
            Expression operand,
            PostfixOperator operator) {
        return this.newPostfixExpression0(
            operand,
            operator
        );
    }

    private PostfixExpressionImpl newPostfixExpression0(
            Expression operand,
            PostfixOperator operator) {
        Util.notNull(operand, "operand"); //$NON-NLS-1$
        Util.notNull(operator, "operator"); //$NON-NLS-1$
        PostfixExpressionImpl result = new PostfixExpressionImpl();
        result.setOperand(operand);
        result.setOperator(operator);
        return result;
    }

    /**
     * 新しい{@link QualifiedName}を生成して返す。
     * @param qualifier
     *     限定子
     * @param simpleName
     *     この限定名の末尾にある単純名
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code qualifier}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code simpleName}に{@code null}が指定された場合
     */
    @Override
    public QualifiedName newQualifiedName(
            Name qualifier,
            SimpleName simpleName) {
        return this.newQualifiedName0(
            qualifier,
            simpleName
        );
    }

    private QualifiedNameImpl newQualifiedName0(
            Name qualifier,
            SimpleName simpleName) {
        Util.notNull(qualifier, "qualifier"); //$NON-NLS-1$
        Util.notNull(simpleName, "simpleName"); //$NON-NLS-1$
        QualifiedNameImpl result = new QualifiedNameImpl();
        result.setQualifier(qualifier);
        result.setSimpleName(simpleName);
        return result;
    }

    /**
     * 新しい{@link QualifiedType}を生成して返す。
     * @param qualifier
     *     型限定子
     * @param simpleName
     *     型の単純名
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code qualifier}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code simpleName}に{@code null}が指定された場合
     */
    @Override
    public QualifiedType newQualifiedType(
            Type qualifier,
            SimpleName simpleName) {
        return this.newQualifiedType0(
            qualifier,
            simpleName
        );
    }

    private QualifiedTypeImpl newQualifiedType0(
            Type qualifier,
            SimpleName simpleName) {
        Util.notNull(qualifier, "qualifier"); //$NON-NLS-1$
        Util.notNull(simpleName, "simpleName"); //$NON-NLS-1$
        QualifiedTypeImpl result = new QualifiedTypeImpl();
        result.setQualifier(qualifier);
        result.setSimpleName(simpleName);
        return result;
    }

    /**
     * 新しい{@link ReturnStatement}を生成して返す。
     * @param expression
     *     返戻値、
     *     ただし返戻値が指定されない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     */
    @Override
    public ReturnStatement newReturnStatement(
            Expression expression) {
        return this.newReturnStatement0(
            expression
        );
    }

    private ReturnStatementImpl newReturnStatement0(
            Expression expression) {
        ReturnStatementImpl result = new ReturnStatementImpl();
        result.setExpression(expression);
        return result;
    }

    /**
     * 新しい{@link SimpleName}を生成して返す。
     * @param string
     *     この単純名を表現する文字列
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code string}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code string}に空が指定された場合
     */
    @Override
    public SimpleName newSimpleName(
            String string) {
        return this.newSimpleName0(
            string
        );
    }

    private SimpleNameImpl newSimpleName0(
            String string) {
        Util.notNull(string, "string"); //$NON-NLS-1$
        SimpleNameImpl result = new SimpleNameImpl();
        result.setToken(string);
        return result;
    }

    /**
     * 新しい{@link SingleElementAnnotation}を生成して返す。
     * @param type
     *     注釈の型
     * @param expression
     *     {@code value}要素値の式
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code type}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     */
    @Override
    public SingleElementAnnotation newSingleElementAnnotation(
            NamedType type,
            Expression expression) {
        return this.newSingleElementAnnotation0(
            type,
            expression
        );
    }

    private SingleElementAnnotationImpl newSingleElementAnnotation0(
            NamedType type,
            Expression expression) {
        Util.notNull(type, "type"); //$NON-NLS-1$
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        SingleElementAnnotationImpl result = new SingleElementAnnotationImpl();
        result.setType(type);
        result.setExpression(expression);
        return result;
    }

    /**
     * 新しい{@link StatementExpressionList}を生成して返す。
     * @param expressions
     *     式の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expressions}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expressions}に空が指定された場合
     */
    @Override
    public StatementExpressionList newStatementExpressionList(
            List<? extends Expression> expressions) {
        return this.newStatementExpressionList0(
            expressions
        );
    }

    private StatementExpressionListImpl newStatementExpressionList0(
            List<? extends Expression> expressions) {
        Util.notNull(expressions, "expressions"); //$NON-NLS-1$
        Util.notContainNull(expressions, "expressions"); //$NON-NLS-1$
        Util.notEmpty(expressions, "expressions"); //$NON-NLS-1$
        StatementExpressionListImpl result = new StatementExpressionListImpl();
        result.setExpressions(expressions);
        return result;
    }

    /**
     * 新しい{@link Super}を生成して返す。
     * @param qualifier
     *     型限定子、
     *     ただし限定子が指定されない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     */
    @Override
    public Super newSuper(
            NamedType qualifier) {
        return this.newSuper0(
            qualifier
        );
    }

    private SuperImpl newSuper0(
            NamedType qualifier) {
        SuperImpl result = new SuperImpl();
        result.setQualifier(qualifier);
        return result;
    }

    /**
     * 新しい{@link SuperConstructorInvocation}を生成して返す。
     * @param qualifier
     *     限定式、
     *     ただし限定式が指定されない場合は{@code null}
     * @param typeArguments
     *     型引数の一覧
     * @param arguments
     *     実引数の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeArguments}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code arguments}に{@code null}が指定された場合
     */
    @Override
    public SuperConstructorInvocation newSuperConstructorInvocation(
            Expression qualifier,
            List<? extends Type> typeArguments,
            List<? extends Expression> arguments) {
        return this.newSuperConstructorInvocation0(
            qualifier,
            typeArguments,
            arguments
        );
    }

    private SuperConstructorInvocationImpl newSuperConstructorInvocation0(
            Expression qualifier,
            List<? extends Type> typeArguments,
            List<? extends Expression> arguments) {
        Util.notNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        Util.notContainNull(typeArguments, "typeArguments"); //$NON-NLS-1$
        Util.notNull(arguments, "arguments"); //$NON-NLS-1$
        Util.notContainNull(arguments, "arguments"); //$NON-NLS-1$
        SuperConstructorInvocationImpl result = new SuperConstructorInvocationImpl();
        result.setQualifier(qualifier);
        result.setTypeArguments(typeArguments);
        result.setArguments(arguments);
        return result;
    }

    /**
     * 新しい{@link SwitchCaseLabel}を生成して返す。
     * @param expression
     *     {@code case}ラベルの値
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     */
    @Override
    public SwitchCaseLabel newSwitchCaseLabel(
            Expression expression) {
        return this.newSwitchCaseLabel0(
            expression
        );
    }

    private SwitchCaseLabelImpl newSwitchCaseLabel0(
            Expression expression) {
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        SwitchCaseLabelImpl result = new SwitchCaseLabelImpl();
        result.setExpression(expression);
        return result;
    }

    /**
     * 新しい{@link SwitchDefaultLabel}を生成して返す。
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     */
    @Override
    public SwitchDefaultLabel newSwitchDefaultLabel(
            ) {
        return this.newSwitchDefaultLabel0(

        );
    }

    private SwitchDefaultLabelImpl newSwitchDefaultLabel0(
            ) {
        SwitchDefaultLabelImpl result = new SwitchDefaultLabelImpl();
        return result;
    }

    /**
     * 新しい{@link SwitchStatement}を生成して返す。
     * @param expression
     *     セレクタ式
     * @param statements
     *     {@code switch}文の本体
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code statements}に{@code null}が指定された場合
     */
    @Override
    public SwitchStatement newSwitchStatement(
            Expression expression,
            List<? extends Statement> statements) {
        return this.newSwitchStatement0(
            expression,
            statements
        );
    }

    private SwitchStatementImpl newSwitchStatement0(
            Expression expression,
            List<? extends Statement> statements) {
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        Util.notNull(statements, "statements"); //$NON-NLS-1$
        Util.notContainNull(statements, "statements"); //$NON-NLS-1$
        SwitchStatementImpl result = new SwitchStatementImpl();
        result.setExpression(expression);
        result.setStatements(statements);
        return result;
    }

    /**
     * 新しい{@link SynchronizedStatement}を生成して返す。
     * @param expression
     *     同期オブジェクト
     * @param body
     *     本体ブロック
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code body}に{@code null}が指定された場合
     */
    @Override
    public SynchronizedStatement newSynchronizedStatement(
            Expression expression,
            Block body) {
        return this.newSynchronizedStatement0(
            expression,
            body
        );
    }

    private SynchronizedStatementImpl newSynchronizedStatement0(
            Expression expression,
            Block body) {
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        Util.notNull(body, "body"); //$NON-NLS-1$
        SynchronizedStatementImpl result = new SynchronizedStatementImpl();
        result.setExpression(expression);
        result.setBody(body);
        return result;
    }

    /**
     * 新しい{@link This}を生成して返す。
     * @param qualifier
     *     型限定子、
     *     ただし限定子が指定されない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     */
    @Override
    public This newThis(
            NamedType qualifier) {
        return this.newThis0(
            qualifier
        );
    }

    private ThisImpl newThis0(
            NamedType qualifier) {
        ThisImpl result = new ThisImpl();
        result.setQualifier(qualifier);
        return result;
    }

    /**
     * 新しい{@link ThrowStatement}を生成して返す。
     * @param expression
     *     例外オブジェクト
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code expression}に{@code null}が指定された場合
     */
    @Override
    public ThrowStatement newThrowStatement(
            Expression expression) {
        return this.newThrowStatement0(
            expression
        );
    }

    private ThrowStatementImpl newThrowStatement0(
            Expression expression) {
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        ThrowStatementImpl result = new ThrowStatementImpl();
        result.setExpression(expression);
        return result;
    }

    /**
     * 新しい{@link TryStatement}を生成して返す。
     * @param tryBlock
     *     {@code try}節
     * @param catchClauses
     *     {@code catch}節の一覧
     * @param finallyBlock
     *     {@code finally}節、
     *     ただし{@code finally}節が指定されない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code tryBlock}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code catchClauses}に{@code null}が指定された場合
     */
    @Override
    public TryStatement newTryStatement(
            Block tryBlock,
            List<? extends CatchClause> catchClauses,
            Block finallyBlock) {
        return this.newTryStatement0(
            tryBlock,
            catchClauses,
            finallyBlock
        );
    }

    private TryStatementImpl newTryStatement0(
            Block tryBlock,
            List<? extends CatchClause> catchClauses,
            Block finallyBlock) {
        Util.notNull(tryBlock, "tryBlock"); //$NON-NLS-1$
        Util.notNull(catchClauses, "catchClauses"); //$NON-NLS-1$
        Util.notContainNull(catchClauses, "catchClauses"); //$NON-NLS-1$
        TryStatementImpl result = new TryStatementImpl();
        result.setTryBlock(tryBlock);
        result.setCatchClauses(catchClauses);
        result.setFinallyBlock(finallyBlock);
        return result;
    }

    /**
     * 新しい{@link TypeParameterDeclaration}を生成して返す。
     * @param name
     *     型引数の名前
     * @param typeBounds
     *     境界型の一覧
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code typeBounds}に{@code null}が指定された場合
     */
    @Override
    public TypeParameterDeclaration newTypeParameterDeclaration(
            SimpleName name,
            List<? extends Type> typeBounds) {
        return this.newTypeParameterDeclaration0(
            name,
            typeBounds
        );
    }

    private TypeParameterDeclarationImpl newTypeParameterDeclaration0(
            SimpleName name,
            List<? extends Type> typeBounds) {
        Util.notNull(name, "name"); //$NON-NLS-1$
        Util.notNull(typeBounds, "typeBounds"); //$NON-NLS-1$
        Util.notContainNull(typeBounds, "typeBounds"); //$NON-NLS-1$
        TypeParameterDeclarationImpl result = new TypeParameterDeclarationImpl();
        result.setName(name);
        result.setTypeBounds(typeBounds);
        return result;
    }

    /**
     * 新しい{@link UnaryExpression}を生成して返す。
     * @param operator
     *     単項演算子
     * @param operand
     *     演算項
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code operator}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code operand}に{@code null}が指定された場合
     */
    @Override
    public UnaryExpression newUnaryExpression(
            UnaryOperator operator,
            Expression operand) {
        return this.newUnaryExpression0(
            operator,
            operand
        );
    }

    private UnaryExpressionImpl newUnaryExpression0(
            UnaryOperator operator,
            Expression operand) {
        Util.notNull(operator, "operator"); //$NON-NLS-1$
        Util.notNull(operand, "operand"); //$NON-NLS-1$
        UnaryExpressionImpl result = new UnaryExpressionImpl();
        result.setOperator(operator);
        result.setOperand(operand);
        return result;
    }

    /**
     * 新しい{@link VariableDeclarator}を生成して返す。
     * @param name
     *     変数の名前
     * @param extraDimensions
     *     追加次元数の宣言
     * @param initializer
     *     初期化式、
     *     ただし初期化式が指定されない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code name}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code extraDimensions}に負の値が指定された場合
     */
    @Override
    public VariableDeclarator newVariableDeclarator(
            SimpleName name,
            int extraDimensions,
            Expression initializer) {
        return this.newVariableDeclarator0(
            name,
            extraDimensions,
            initializer
        );
    }

    private VariableDeclaratorImpl newVariableDeclarator0(
            SimpleName name,
            int extraDimensions,
            Expression initializer) {
        Util.notNull(name, "name"); //$NON-NLS-1$
        VariableDeclaratorImpl result = new VariableDeclaratorImpl();
        result.setName(name);
        result.setExtraDimensions(extraDimensions);
        result.setInitializer(initializer);
        return result;
    }

    /**
     * 新しい{@link WhileStatement}を生成して返す。
     * @param condition
     *     条件式
     * @param body
     *     ループ文
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code condition}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code body}に{@code null}が指定された場合
     */
    @Override
    public WhileStatement newWhileStatement(
            Expression condition,
            Statement body) {
        return this.newWhileStatement0(
            condition,
            body
        );
    }

    private WhileStatementImpl newWhileStatement0(
            Expression condition,
            Statement body) {
        Util.notNull(condition, "condition"); //$NON-NLS-1$
        Util.notNull(body, "body"); //$NON-NLS-1$
        WhileStatementImpl result = new WhileStatementImpl();
        result.setCondition(condition);
        result.setBody(body);
        return result;
    }

    /**
     * 新しい{@link Wildcard}を生成して返す。
     * @param boundKind
     *     型境界の種類
     * @param typeBound
     *     境界型、
     *     ただし境界型が指定されない場合は{@code null}
     * @return 生成した要素
     * @throws IllegalArgumentException
     *     {@code region}に{@code null}が指定された場合
     * @throws IllegalArgumentException
     *     {@code boundKind}に{@code null}が指定された場合
     */
    @Override
    public Wildcard newWildcard(
            WildcardBoundKind boundKind,
            Type typeBound) {
        return this.newWildcard0(
            boundKind,
            typeBound
        );
    }

    private WildcardImpl newWildcard0(
            WildcardBoundKind boundKind,
            Type typeBound) {
        Util.notNull(boundKind, "boundKind"); //$NON-NLS-1$
        WildcardImpl result = new WildcardImpl();
        result.setBoundKind(boundKind);
        result.setTypeBound(typeBound);
        return result;
    }
}
