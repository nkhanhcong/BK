package bkool.astgen
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import java.io.{File, PrintWriter}

import bkool.parser.BKOOLParser._
import org.antlr.v4.runtime.ANTLRFileStream
import bkool.utils._

import scala.collection.JavaConverters._
import org.antlr.v4.runtime.tree._
import bkool.parser._
import bkool.parser.BKOOLBaseVisitor


class ASTGeneration extends BKOOLBaseVisitor[Object] {
  override def visitProgram(ctx:BKOOLParser.ProgramContext) = Program(ctx.classDecl().asScala.toList.map(x => x.accept(this).asInstanceOf[ClassDecl]))
  override def visitClassDecl(ctx: BKOOLParser.ClassDeclContext) = {
    if( ctx.ID(1) !=null)
      ClassDecl(Id(ctx.ID(0).getText), Id(ctx.ID(1).getText), ctx.member().asScala.toList.map(x => x.accept(this).asInstanceOf[List[MemDecl]]).foldLeft(List[MemDecl]())((a,b)=>a:::b))
    else
      ClassDecl(Id(ctx.ID(0).getText),null, ctx.member().asScala.toList.map(x => x.accept(this).asInstanceOf[List[MemDecl]]).foldLeft(List[MemDecl]())((a,b)=>a:::b))
  }
  // RETURN TYPE
  def returnTypeMethod(ctx: BKOOLParser.Method_decContext): Type={
    if (ctx.element_type_method()==null) null
    else if(ctx.element_type_method().element_type()!= null) returnElementType(ctx.element_type_method().element_type())
    else VoidType
  }
  def returnElementType(ctx: BKOOLParser.Element_typeContext): Type={
    if(ctx.type_notvoid()!= null) returnTypeNotVoid(ctx.type_notvoid())
    else if (ctx.array_type() != null) visitArray_type(ctx.array_type())
    else visitClass_type(ctx.class_type())

  }
  def returnTypeNotVoid(ctx:BKOOLParser.Type_notvoidContext):Type={
    if(ctx.BOOLEAN()!=null) BoolType
    else if(ctx.FLOAT()!= null) FloatType
    else if(ctx.STRING()!= null) StringType
    else IntType
  }
  def returnTypeArray(ctx: BKOOLParser.Array_typeContext): Type={
    if(ctx.typeArray().type_notvoid()!= null) returnTypeNotVoid(ctx.typeArray().type_notvoid())
    else ClassType(ctx.typeArray().ID().getText)
  }
  override def visitClass_type(ctx: BKOOLParser.Class_typeContext)= ClassType(ctx.ID().getText)
  override def visitArray_type(ctx: BKOOLParser.Array_typeContext)= ArrayType(IntLiteral(ctx.size().INTLIT().getText.toInt),returnTypeArray(ctx))
  // start METHOD
  override def visitMethod_dec(ctx: BKOOLParser.Method_decContext)= {
    if(ctx.STATIC()==null) List(MethodDecl(Instance, Id(ctx.ID().getText), ctx.listPara().para().asScala.toList.map(x=>x.accept(this).asInstanceOf[List[ParamDecl]]).foldLeft(List[ParamDecl]())((a,b)=>a:::b), returnTypeMethod(ctx), ctx.block_stm().accept(this).asInstanceOf[Stmt]))
    else List(MethodDecl(Static, Id(ctx.ID().getText), ctx.listPara().para().asScala.toList.map(x => x.accept(this).asInstanceOf[List[ParamDecl]]).foldLeft(List[ParamDecl]())((a,b)=>a:::b), returnTypeMethod(ctx), ctx.block_stm().accept(this).asInstanceOf[Stmt]))
  }

  // ------------------------------------finish Method decl----------------------
  //--------------------
  //MEMBER
  override def visitMember(ctx: BKOOLParser.MemberContext) = ctx.getChild(0).accept(this)
  //STMT


  override def visitStatement(ctx: BKOOLParser.StatementContext) = ctx.getChild(0).accept(this)
  override def visitBlock_stm(ctx: BKOOLParser.Block_stmContext) ={
    val stmt= if(ctx.statement()!= null)ctx.statement().asScala.toList.map(x=>x.accept(this)).asInstanceOf[List[Stmt]]/*.foldLeft(List[Stmt]())((a,b)=> a ::: b) */else List()
    val decl= if(ctx.decl()!= null)ctx.decl().asScala.toList.map(x=>x.accept(this).asInstanceOf[List[Decl]]).foldLeft(List[Decl]())((a,b) => a:::b )else List()
    Block(decl,stmt)
  }
  override def visitIf_statement(ctx: BKOOLParser.If_statementContext)=If(ctx.expression().accept(this).asInstanceOf[Expr],ctx.statement(0).accept(this).asInstanceOf[Stmt],ctx.statement().size match{case 1=>None case 2=>Some(ctx.statement(1).accept(this).asInstanceOf[Stmt])})
  override def visitReturn_statement(ctx: BKOOLParser.Return_statementContext) = Return(ctx.expression().accept(this).asInstanceOf[Expr])
  override def visitBreak_statement(ctx: BKOOLParser.Break_statementContext)= Break

  override def visitFor_statement(ctx: BKOOLParser.For_statementContext) = ctx.DOWNTO() match {
    case null => For(ctx.scalar_variable().ID().getText,ctx.expression(0).accept(this).asInstanceOf[Expr],true,ctx.expression(1).accept(this).asInstanceOf[Expr],ctx.statement().accept(this).asInstanceOf[Stmt])
    case _ => For(ctx.scalar_variable().ID().getText,ctx.expression(0).accept(this).asInstanceOf[Expr],false,ctx.expression(1).accept(this).asInstanceOf[Expr],ctx.statement().accept(this).asInstanceOf[Stmt])
  }
  override def visitMethod_inovation(ctx: BKOOLParser.Method_inovationContext)= Call(ctx.expression().accept(this).asInstanceOf[Expr],Id(ctx.ID().getText),List_expression(ctx.list_expression()))

  override def visitContinue_statement(ctx: BKOOLParser.Continue_statementContext) = Continue
  override def visitAsignment_statement(ctx: BKOOLParser.Asignment_statementContext) =Assign(ctx.lhs().accept(this).asInstanceOf[LHS],ctx.expression().accept(this).asInstanceOf[Expr])

  //-----------------------finish STMT--------------------------------------------
  // ----------------------------------Support STMT----------------------
  def List_expression(ctx: BKOOLParser.List_expressionContext) = ctx.expression().asScala.toList.map(x=> x.accept(this).asInstanceOf[Expr])
  // ---------------------finish Support STMT--------------------------------
  //  override def visit
  def attributeConst(ctx: BKOOLParser.Constant_dec_globalContext)={
    if(ctx.STATIC()!= null)
      AttributeDecl(Static, ConstDecl(Id(ctx.ID().getText), returnElementType(ctx.element_type()), ctx.expression().accept(this).asInstanceOf[Expr]))
    else
      AttributeDecl(Instance, ConstDecl(Id(ctx.ID().getText), returnElementType(ctx.element_type()), ctx.expression().accept(this).asInstanceOf[Expr]))
  }
  def attributeVar(ctx: BKOOLParser.Variable_dec_globalContext)= {
    val kind: SIKind= if(ctx.STATIC()!= null) Static else Instance
    val typ: Type= returnElementType(ctx.element_type())
    val manyVar= ctx.iden_list().ID().asScala.toList.map(x=> VarDecl(Id(x.getText),typ))
    manyVar.map(x=>AttributeDecl(kind,x))
  }
  //----------------Decl---------------------------------
  override def visitConstant_dec(ctx: BKOOLParser.Constant_decContext)= List(ConstDecl(Id(ctx.ID().getText),returnElementType(ctx.element_type()),ctx.expression().accept(this).asInstanceOf[Expr]))
  override def visitVariable_dec(ctx: BKOOLParser.Variable_decContext)= {
    val kind: SIKind= if(ctx.STATIC()!= null) Static else Instance
    val typ: Type= returnElementType(ctx.element_type())
    val lsid= ctx.iden_list().ID().asScala.toList
    lsid.map(x=> VarDecl(Id(x.getText),typ))
  }
  override def visitConstant_dec_global(ctx: BKOOLParser.Constant_dec_globalContext)= List(attributeConst(ctx))
  override def visitVariable_dec_global(ctx: BKOOLParser.Variable_dec_globalContext) = attributeVar(ctx)


  override def visitDecl(ctx: BKOOLParser.DeclContext) = ctx.getChild(0).accept(this)
  //------------------ finish Decl---------------------------
  override def visitPara(ctx: BKOOLParser.ParaContext)=  ctx.iden_list().ID().asScala.toList.map(x =>ParamDecl(Id(x.getText),returnElementType(ctx.element_type())))

  //-----------------Start Litteral-------------
  override def visitDomain(ctx: BKOOLParser.DomainContext) ={
    if(ctx.INTLIT()!= null) IntLiteral(ctx.INTLIT().getText.toInt)
    else if(ctx.STRINGLIT()!= null) StringLiteral(ctx.STRINGLIT().getText)
    else if(ctx.FLOATLIT()!= null) FloatLiteral(ctx.FLOATLIT().getText.toFloat)
    else if(ctx.BOOLEANLIT()!= null) BooleanLiteral(ctx.BOOLEANLIT().getText.toBoolean)
    else if(ctx.THIS()!= null) SelfLiteral
    else if(ctx.ID()!= null) Id(ctx.ID().getText())
    else NullLiteral
  }
  //------------------Finish Litteral-------------------
  //-----------Start LHS---------------
  override def visitLhs(ctx: BKOOLParser.LhsContext)= ctx.expression().size match {
    case 2=> ArrayCell(ctx.expression(0).accept(this).asInstanceOf[Expr],ctx.expression(1).accept(this).asInstanceOf[Expr])
    case 1=> FieldAccess(ctx.expression(0).accept(this).asInstanceOf[Expr], Id(ctx.ID().getText))
    case _=> Id(ctx.ID().getText)
  }

  //--------------------- finish LHS------------
  //------------------Expression------------------------
  // override def visitExpression(ctx: BKOOLParser.ExpressionContext)= ctx.getChild(0).accept(this)
  override def visitBraceExp(ctx: BKOOLParser.BraceExpContext) =ctx.expression().accept(this)

  override def visitList_expression(ctx: BKOOLParser.List_expressionContext)= ctx.expression() match
  {case null=> List()
    case _ =>ctx.expression().asScala.map(visit).toList}
  override def visitNewExp(ctx: BKOOLParser.NewExpContext)= NewExpr(ctx.expression().accept(this).asInstanceOf[Id],ctx.list_expression().accept(this).asInstanceOf[List[Expr]])

  override def visitCallExp(ctx: BKOOLParser.CallExpContext)= {
    if (ctx.brace_list_expression()== null) {
      FieldAccess(ctx.expression().accept(this).asInstanceOf[Expr], Id(ctx.ID().getText()))
    }
    else {
      if (ctx.brace_list_expression().list_expression() == null) CallExpr(ctx.expression().accept(this).asInstanceOf[Expr], Id(ctx.ID().getText), List())
      else {
        val t = ctx.brace_list_expression().list_expression().expression().asScala.toList.map(x => x.accept(this).asInstanceOf[Expr])
        CallExpr(ctx.expression().accept(this).asInstanceOf[Expr], Id(ctx.ID().getText), t)
      }
    }
  }

  override def visitIndexExp(ctx: BKOOLParser.IndexExpContext)=ArrayCell(ctx.expression(0).accept(this).asInstanceOf[Expr],ctx.expression(1).accept(this).asInstanceOf[Expr])

  override def visitUnaryPSOp(ctx: BKOOLParser.UnaryPSOpContext) = ctx.PLUS() match{
    case null=> UnaryOp(ctx.SUB().getText,ctx.expression().accept(this).asInstanceOf[Expr])
    case _=> UnaryOp(ctx.PLUS().getText,ctx.expression().accept(this).asInstanceOf[Expr])
  }

  override def visitUnaryNOp(ctx: BKOOLParser.UnaryNOpContext)= UnaryOp(ctx.NOT().getText,ctx.expression().accept(this).asInstanceOf[Expr])

  override def visitBinaryCOp(ctx: BKOOLParser.BinaryCOpContext) = BinaryOp(ctx.CONCAT().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])

  override def visitBinaryMFIMOp(ctx: BKOOLParser.BinaryMFIMOpContext)= {
    if(ctx.MUL()!= null) BinaryOp(ctx.MUL().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])
    else if(ctx.FLOAT_DIV()!= null)BinaryOp(ctx.FLOAT_DIV().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])
    else if(ctx.IN_DIV()!= null )BinaryOp(ctx.IN_DIV().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])
    else BinaryOp(ctx.MODULUS().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])
  }

  override def visitBinaryPSOp(ctx: BKOOLParser.BinaryPSOpContext)= ctx.PLUS() match{
    case null => BinaryOp(ctx.SUB().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])
    case _ => BinaryOp(ctx.PLUS().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])
  }

  override def visitBinaryAOOp(ctx: BKOOLParser.BinaryAOOpContext)=ctx.AND() match{
    case null=> BinaryOp(ctx.OR().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])
    case _ => BinaryOp(ctx.AND().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])

  }

  override def visitBinaryEQOp(ctx: BKOOLParser.BinaryEQOpContext)= ctx.EQUAL() match{
    case null => BinaryOp(ctx.NOTEQUAL().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])
    case _ => BinaryOp(ctx.EQUAL().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])

  }

  override def visitBinaryGLOp(ctx: BKOOLParser.BinaryGLOpContext)={
    if(ctx.GREATER()!= null) BinaryOp(ctx.GREATER().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])
    else if(ctx.GREATEREQUAL()!= null) BinaryOp(ctx.GREATEREQUAL().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])
    else if(ctx.LESS()!= null) BinaryOp(ctx.LESS().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])
    else BinaryOp(ctx.LESSEQUAL().getText,ctx.expression(0).accept(this).asInstanceOf[Expr], ctx.expression(1).accept(this).asInstanceOf[Expr])

  }

  //-------------finish Expression-------------------

}