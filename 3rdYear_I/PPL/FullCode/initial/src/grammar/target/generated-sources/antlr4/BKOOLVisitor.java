// Generated from BKOOL.g4 by ANTLR 4.5.3

  package bkool.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BKOOLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BKOOLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#type_notvoid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_notvoid(BKOOLParser.Type_notvoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(BKOOLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(BKOOLParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#method_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_dec(BKOOLParser.Method_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#listPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListPara(BKOOLParser.ListParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#element_type_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement_type_method(BKOOLParser.Element_type_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#iden_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIden_list(BKOOLParser.Iden_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#list_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_expression(BKOOLParser.List_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#brace_list_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrace_list_expression(BKOOLParser.Brace_list_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(BKOOLParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(BKOOLParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#constant_dec_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_dec_global(BKOOLParser.Constant_dec_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#variable_dec_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_dec_global(BKOOLParser.Variable_dec_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#element_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement_type(BKOOLParser.Element_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#constant_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_dec(BKOOLParser.Constant_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#variable_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_dec(BKOOLParser.Variable_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPara(BKOOLParser.ParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BKOOLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#array_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_type(BKOOLParser.Array_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#typeArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArray(BKOOLParser.TypeArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#size}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSize(BKOOLParser.SizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#class_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_type(BKOOLParser.Class_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#domain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomain(BKOOLParser.DomainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExp(BKOOLParser.NewExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryPSOp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryPSOp(BKOOLParser.BinaryPSOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryPSOp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPSOp(BKOOLParser.UnaryPSOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code braceExp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraceExp(BKOOLParser.BraceExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryAOOp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryAOOp(BKOOLParser.BinaryAOOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExp(BKOOLParser.CallExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryEQOp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryEQOp(BKOOLParser.BinaryEQOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryGLOp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryGLOp(BKOOLParser.BinaryGLOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code end}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd(BKOOLParser.EndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryMFIMOp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryMFIMOp(BKOOLParser.BinaryMFIMOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryNOp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryNOp(BKOOLParser.UnaryNOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryCOp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryCOp(BKOOLParser.BinaryCOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExp}
	 * labeled alternative in {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExp(BKOOLParser.IndexExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#block_stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_stm(BKOOLParser.Block_stmContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#asignment_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignment_statement(BKOOLParser.Asignment_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhs(BKOOLParser.LhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(BKOOLParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(BKOOLParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#scalar_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalar_variable(BKOOLParser.Scalar_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#break_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_statement(BKOOLParser.Break_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#continue_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_statement(BKOOLParser.Continue_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(BKOOLParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#method_inovation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_inovation(BKOOLParser.Method_inovationContext ctx);
}