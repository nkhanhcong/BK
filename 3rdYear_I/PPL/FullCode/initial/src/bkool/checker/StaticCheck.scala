package bkool.checker

/**
  * @author nhphung
  *Nguyen Khanh Cong 1410407
  */

import bkool.utils._
import bkool.parser._
import java.io.{PrintWriter, File}
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree._
import scala.collection.JavaConverters._
import bkool.astgen.ASTGeneration
import org.antlr.v4.codegen.model.BaseVisitorFile


trait MyClass extends Visitor{

  def visitProgram(ast: Program, c: Context): Object = null
  def visitClassDecl(ast: ClassDecl, c: Context): Object = null

  def visitVarDecl(ast: VarDecl, c: Context): Object = null
  def visitConstDecl(ast: ConstDecl, c: Context): Object = null
  def visitParamDecl(ast: ParamDecl, c: Context): Object = null

  def visitMethodDecl(ast: MethodDecl, c: Context): Object = null
  def visitAttributeDecl(ast: AttributeDecl, c: Context): Object = null

  def visitInstance(ast: Instance.type, c: Context): Object = null
  def visitStatic(ast: Static.type, c: Context): Object = null
  def visitIntType(ast: IntType.type, c: Context): Object = null
  def visitFloatType(ast: FloatType.type, c: Context): Object = null
  def visitBoolType(ast: BoolType.type, c: Context): Object = null
  def visitStringType(ast: StringType.type, c: Context): Object = null
  def visitVoidType(ast: VoidType.type, c: Context): Object = null
  def visitArrayType(ast: ArrayType, c: Context): Object = null
  def visitClassType(ast: ClassType, c: Context): Object = null
  def visitBinaryOp(ast: BinaryOp, c: Context): Object = null
  def visitUnaryOp(ast: UnaryOp, c: Context): Object = null
  def visitNewExpr(ast: NewExpr, c: Context): Object = null
  def visitCallExpr(ast: CallExpr, c: Context): Object = null
  def visitId(ast: Id, c: Context): Object = null
  def visitArrayCell(ast: ArrayCell, c: Context): Object = null
  def visitFieldAccess(ast: FieldAccess, c: Context): Object = null
  def visitBlock(ast: Block, c: Context): Object = null
  def visitAssign(ast: Assign, c: Context): Object = null
  def visitIf(ast: If, c: Context): Object = null
  def visitCall(ast: Call, c: Context): Object = null
  def visitFor(ast: For, c: Context): Object = null
  def visitBreak(ast: Break.type, c: Context): Object = null
  def visitContinue(ast: Continue.type, c: Context): Object = null
  def visitReturn(ast: Return, c: Context): Object = null
  def visitIntLiteral(ast: IntLiteral, c: Context): Object = null
  def visitFloatLiteral(ast: FloatLiteral, c: Context): Object = null
  def visitStringLiteral(ast: StringLiteral, c: Context): Object = null
  def visitBooleanLiteral(ast: BooleanLiteral, c: Context): Object = null
  def visitNullLiteral(ast: NullLiteral.type, c: Context): Object = null
  def visitSelfLiteral(ast: SelfLiteral.type, c: Context): Object = null
}
case class CheckClass(lst:List[(String,Type,Int,List[(String,Type)])]) extends Context
case class CheckProg(lst:List[(String,String,List[(String,Type,Int,List[(String,Type)])])]) extends Context
case class CheckPara(lst:List[(String,Type)]) extends Context

case class CheckMethod1(lst:List[(String,Type,Int)]) extends Context
case class CheckMethod2(lst: List[List[(String,Type,Int)]]) extends Context



class CheckClassImple extends MyClass with utils {
  var _currentClass=""
  override def visitProgram(ast: Program, c: Context)={
    val tem=("io",null,List(("readInt",IntType,3,List((null,null))),("writeInt",VoidType,3,List(("anArg",IntType))),
      ("writeIntLn",VoidType,3,List(("anArg",IntType))),("readFloat",FloatType,3,List((null,null))),
      ("writeFloat",VoidType,3,List(("anArg",FloatType))),("writeFloatLn",VoidType,3,List(("anArg",FloatType))),
      ("readBool",BoolType,3,List((null,null))),("writeBool",VoidType,3,List(("anArg",BoolType))),
      ("writeBoolLn",VoidType,3,List(("anArg",BoolType))),("readStr",StringType,3,List((null,null))),
      ("writeStr",VoidType,3,List(("anArg",StringType))),("writeStrLn",VoidType,3,List(("anArg",StringType)))))
    val env= List[(String,String,List[(String,Type,Int,List[(String,Type)])])]()
    val tmp= tem::env
    ast.decl.foldLeft(tmp)((a,b)=>b.accept(this,CheckProg(a)).asInstanceOf[List[(String,String,List[(String,Type,Int,List[(String,Type)])])]])
  }

  override def visitClassDecl(ast: ClassDecl, c: Context)={
    _currentClass=ast.name.name
    val env= c.asInstanceOf[CheckProg].lst
    if(env.exists(x=>x._1== ast.name.name)) throw Redeclared(Class,ast.name.name)
    else {
      val classE=ast.decl.foldLeft(List[(String,Type,Int,List[(String,Type)])]())((a,b)=>b.accept(this,CheckClass(a)).asInstanceOf[List[(String,Type,Int,List[(String,Type)])]])
     //System.out.println(classE)
      (ast.name.name,if(ast.parent!=null)ast.parent.name else null,classE)::env
    }
  }

  override def visitAttributeDecl(ast: AttributeDecl, c: Context)={
   ast.decl.accept(this,c)
  }

  override def visitConstDecl(ast: ConstDecl, c: Context)={
    val env= c.asInstanceOf[CheckClass].lst
    if(env.exists(x=>x._1==ast.id.name)|| ast.id.name==_currentClass) throw Redeclared(Attribute,ast.id.name)
    else (ast.id.name,ast.constType,1,null)::env
  }

  override def visitVarDecl(ast: VarDecl, c: Context)={
    val env= c.asInstanceOf[CheckClass].lst
    if(env.exists(x=>x._1== ast.variable.name)|| ast.variable.name==_currentClass) throw Redeclared(Attribute,ast.variable.name)
    else (ast.variable.name,ast.varType,2,null)::env
  }

  override def visitMethodDecl(ast: MethodDecl, c: Context)={
    val env=c.asInstanceOf[CheckClass].lst
    if(env.exists(x=>x._1== ast.name.name)) throw Redeclared(Method,ast.name.name)
    else {
      val param= ast.param.foldLeft(List[(String,Type)]())((a,b)=>b.accept(this,CheckPara(a)).asInstanceOf[List[(String,Type)]])
      (ast.name.name,ast.returnType,3,param)::env
    }
  }

  override def visitParamDecl(ast: ParamDecl, c: Context)={
    val env= c.asInstanceOf[CheckPara].lst
    if(env.exists(x=>x._1==ast.id.name)) throw Redeclared(Parameter,ast.id.name)
    else(ast.id.name,ast.paramType)::env
  }
}
class StaticChecker(ast:AST) {
  def check() = {
    val prog= new CheckClassImple
    val program = ast.accept(prog,null).asInstanceOf[List[(String,String,List[(String,Type,Int,List[(String,Type)])])]]
   // System.out.println(program)
    val classE = new CheckMethodImple(program)
    val classEImplement= ast.accept(classE,null)


  }
}
class CheckMethodImple(lst:List[(String,String,List[(String,Type,Int,List[(String,Type)])])]) extends MyClass with utils{
  var _className=List[Type]()
  var _currentClass=""
  var flagParam= false
  var _flagConst=false

  override def visitProgram(ast: Program, c: Context)= ast.decl.map(x=>x.accept(this,null))
  override def visitClassDecl(ast: ClassDecl, c: Context)={
    if(ast.parent!=null) {
      val cond=lst.exists(x => x._1 == ast.parent.name)
      if (cond==false) throw Undeclared(Class, ast.parent.name)
    }
    _currentClass=ast.name.name

    val declAttribute= ast.decl.filter(_.isInstanceOf[AttributeDecl]).foldLeft(List[(String,Type,Int)]())((a,b)=>b.accept(this,CheckMethod1(a)).asInstanceOf[List[(String,Type,Int)]])
    //  val env= declAttribute::tmp
    val declMethod= ast.decl.filter(_.isInstanceOf[MethodDecl]).map(x=>x.accept(this,CheckMethod2(List(declAttribute))))
    null
  }

  override def visitAttributeDecl(ast: AttributeDecl, c: Context) ={
    ast.decl.accept(this,c)
  }

  override def visitVarDecl(ast: VarDecl, c: Context)={
    val env= c.asInstanceOf[CheckMethod1].lst
    ast.varType.accept(this,c)
   // if(ast.varType.isInstanceOf[ArrayType]) System.out.println(ast.varType)
    if(env.exists(x=>x._1==ast.variable.name))throw Redeclared(Variable,ast.variable.name)
    else
    (ast.variable.name,ast.varType.accept(this,c),2)::env
  }

  override def visitConstDecl(ast: ConstDecl, c: Context)={
    val env= c.asInstanceOf[CheckMethod1].lst
    val left=ast.constType.accept(this,CheckMethod2(List(env))).asInstanceOf[Type]
    val right=ast.const.accept(this,CheckMethod2(List(env))).asInstanceOf[Type]
    if(_flagConst==false) {
      if (coercion(left, right) == false) throw TypeMismatchInConstant(ast)
    }else throw NotConstantExpression(ast.const)
    _flagConst=false
    if(env.exists(x=>x._1== ast.id.name)) throw Redeclared(Constant,ast.id.name)
    else
    (ast.id.name,ast.constType,1)::env
  }

  override def visitClassType(ast: ClassType, c: Context)={
 //   val className= ast.classType.substring(10,ast.classType.length-1)
  //  System.out.println(lst.exists(x=>x._1== ast.classType))

    if(lst.exists(x=>x._1== ast.classType)) ast
    else throw Undeclared(Class,ast.classType)
  }

  //======================= METHOD DECLARED=========================
  override def visitMethodDecl(ast: MethodDecl, c: Context)={
    val env= c.asInstanceOf[CheckMethod2].lst
    flagParam=true
    val param= ast.param.foldLeft(List[(String,Type,Int)]())((a,b)=>b.accept(this,CheckMethod1(a)).asInstanceOf[List[(String,Type,Int)]])
    val newEnv= param::env

    val body= ast.body.accept(this,CheckMethod2(newEnv))
    flagParam=false
    env
  }

  override def visitParamDecl(ast: ParamDecl, c: Context)={
    val env= c.asInstanceOf[CheckMethod1].lst
    ast.paramType.accept(this,c)
    (ast.id.name,ast.paramType,2)::env
  }
//========================== visit Stmt======================
  override def visitBlock(ast: Block, c: Context)={
    val env=c.asInstanceOf[CheckMethod2].lst
    if(flagParam==true){
     // val envBlk=env.head
      val declMethod= ast.decl.foldLeft(env.head)((a,b)=>b.accept(this,CheckMethod1(a)).asInstanceOf[List[(String,Type,Int)]])
      val stmtEnv=declMethod::env.tail
      flagParam=false
     // System.out.println(stmtEnv)
      val stmt= ast.stmt.map(x=>x.accept(this,CheckMethod2(stmtEnv)))
    }
    else{
      val envBlk= ast.decl.foldLeft(List[(String,Type,Int)]())((a,b)=>b.accept(this,CheckMethod1(a)).asInstanceOf[List[(String,Type,Int)]])
      val stmtEnv=envBlk::env
      val stmt= ast.stmt.map(x=>x.accept(this,CheckMethod2(stmtEnv)))
    }
    env
  }

  override def visitIf(ast: If, c: Context)={
    val env= c.asInstanceOf[CheckMethod2].lst
    val cond=ast.expr.accept(this,c)
    _className=List()
    if(cond!=BoolType) throw TypeMismatchInStatement(ast)
    ast.thenStmt.accept(this,c)
    ast.elseStmt match {
      case None => env
      case Some(x) => {
        visit(x, c)
        _className = List()

      }
    }
    env
  }

  override def visitAssign(ast: Assign, c: Context)={
    val env= c.asInstanceOf[CheckMethod2].lst
    val left= ast.leftHandSide.accept(this,c)
    val envF= env.flatten
    val cond= envF.find(x=>x._1== ast.leftHandSide.toString)
    if(cond!=None){
      if(cond.toList.map(x=>x._3).head==1){
       throw CannotAssignToConstant(ast)
      }
    }

    if(left== VoidType) throw TypeMismatchInStatement(ast)
    _className=List()
    val right= ast.expr.accept(this,c)
    if(right== VoidType) throw TypeMismatchInStatement(ast)
    _className=List()
   // System.out.println(coercion(left,right))
   // if(left.isInstanceOf[ArrayType]) System.out.println(left.asInstanceOf[Type])
   if(coercion(left.asInstanceOf[Type],right.asInstanceOf[Type])==false) throw TypeMismatchInStatement(ast)
    //System.out.println(right)
    env
  }

  override def visitFor(ast: For, c: Context)={
    val env= c.asInstanceOf[CheckMethod2].lst
    val envF= env.flatten
    val id= envF.find(x=>x._1== ast.idx)
    if(id!=None){
      if(id.toList.head._3==1) throw CannotAssignToConstant(Assign(Id(ast.idx),ast.expr1))
      else{
        if(id.toList.head._2!=IntType) throw TypeMismatchInStatement(ast)
        else{
          val expr1= ast.expr1.accept(this,c)
          if(expr1!=IntType) throw TypeMismatchInStatement(ast)
          _className=List()
          val expr2 =ast.expr2.accept(this,c)
          if(expr2!=IntType) throw TypeMismatchInStatement(ast)
          _className=List()
          ast.loop.accept(this,c)
        }
      }
    }
    else throw Undeclared(Attribute,ast.idx)
    env
  }

  override def visitCall(ast: Call, c: Context)={
    val env= c.asInstanceOf[CheckMethod2].lst
    val parent= ast.parent.accept(this,c)
    if(parent.isInstanceOf[ClassType]){
      val className= parent.toString.substring(10,parent.toString.length-1)
      val findClass= lst.find(x=>x._1==className).toList.head
      val findMethod= findClass._3.find(x=>x._1==ast.method.name&& x._2==VoidType&& x._3==3)
      if(findMethod!=None){
        val paramPattern= findMethod.toList.head._4.map(x=>x._2)
        val paramTrans=ast.params.map(x=>x.accept(this,c)).asInstanceOf[List[Type]]
        if(lookUpParam(paramPattern,paramTrans)==false) throw TypeMismatchInStatement(ast)
      }else{
        if(findClass._2!=null){
          val findParent= lst.find(x=>x._1==findClass._2).toList.head
          val findMethodParent= findParent._3.find(x=>x._1==ast.method.name&& x._2==VoidType&& x._3==3)
          if(findMethodParent!=None){
            val paramPattern= findMethodParent.toList.head._4.map(x=>x._2)
            val paramTrans=ast.params.map(x=>x.accept(this,c)).asInstanceOf[List[Type]]
            if(lookUpParam(paramPattern,paramTrans)==false) throw TypeMismatchInStatement(ast)
          }
          else throw Undeclared(Method,ast.method.name)
        }
        else throw Undeclared(Method,ast.method.name)
      }
    }
    else throw TypeMismatchInStatement(ast)
  env
  }
//=================end visit Stmt===================

  //====================visit Expr=================
  override def visitCallExpr(ast: CallExpr, c: Context)={
    val env= c.asInstanceOf[CheckMethod2].lst
    ast.cName.accept(this,c)
    val env2= env.flatten
    if(_className==List()){
      val typ= env2.find(x=>x._1==ast.cName.toString).toList.map(x=>x._2)
      _className=typ
    }
    if(_className.head.isInstanceOf[ClassType]){
      val className=_className.head.toString.substring(10,_className.head.toString.length-1)
      val findClass= lst.find(x=>x._1==className)
      val findMethod= findClass.toList.map(x=>x._3).flatten.find(x=>x._1==ast.method.name&& x._3==3)
      if(findMethod!=None){

        _className=findMethod.toList.map(x=>x._2)//find class close
       // if(_className.head== VoidType) throw TypeMismatchInExpression(ast)
        val paramPattern=findMethod.toList.map(x=>x._4).flatten.map(x=>x._2).reverse
        val paramType= ast.params.map(x=>x.accept(this,c)).asInstanceOf[List[Type]]
       // System.out.println(paramPattern)
       if(lookUpParam(paramPattern,paramType)==false) throw TypeMismatchInExpression(ast)
      }
      else{
        if(findClass.toList.map(x=>x._2).head!= null) {
          val parentClass = lst.find(x => x._1 == findClass.toList.map(x=>x._2).head)
          val findMethod= parentClass.toList.map(x=>x._3).flatten.find(x=>x._1== ast.method.name&& x._3==3)
          if(findMethod!=None){
            _className=findMethod.toList.map(x=>x._2)
         //   if(_className.head== VoidType) throw TypeMismatchInExpression(ast)
            val paramPattern=findMethod.toList.map(x=>x._4).flatten.map(x=>x._2).reverse
            val paramType= ast.params.map(x=>x.accept(this,c)).asInstanceOf[List[Type]]
            if(lookUpParam(paramPattern,paramType)==false) throw TypeMismatchInExpression(ast)
          }
          else throw Undeclared(Method,ast.method.name)
        }
        else throw Undeclared(Method,ast.method.name)
      }
      _className.head
    }else throw TypeMismatchInExpression(ast)
  }

  override def visitFieldAccess(ast: FieldAccess, c: Context)={
    val expr= ast.name.accept(this,c)
    //System.out.println(expr)
    if(expr.toString.equals("this")){
      val findClass= lst.find(x=>x._1==_currentClass).toList.map(x=>x._3).flatten
      val findAtt= findClass.find(x=>x._1== ast.field.name&& x._3!=3)
      if(findAtt!=None) {
        _className = List(findAtt.toList.head._2)

        //System.out.println(findClass)
      }
      else throw Undeclared(Attribute,ast.field.name)
    }
    else{
      if(expr.isInstanceOf[ClassType]){
        val className= expr.toString.substring(10,expr.toString.length-1)
        val findClass= lst.find(x=>x._1==className).toList.head
        if(findClass._2==null) {// if class doesn't have parent
          val findAttClose = findClass._3.find(x => x._1 == ast.field.name&&x._3!=3)
          if (findAttClose != None) {

              _className = findAttClose.toList.map(x => x._2)

          }else throw Undeclared(Attribute,ast.field.name)
        }else{
          val findAttClose = findClass._3.find(x => x._1 == ast.field.name&& x._3!=3)
          if (findAttClose != None) {

            _className = findAttClose.toList.map(x => x._2)
          }
          else{
            val findParrent=lst.find(x=>x._1==findClass._2).toList.head._3
            val findAttParent=findParrent.find(x=>x._1==ast.field.name&& x._3!=3)
            if(findAttParent!=None) {
              _className = findAttParent.toList.map(x => x._2)
            }
            else throw Undeclared(Attribute,ast.field.name)
          }
        }
      }
      else throw TypeMismatchInExpression(ast)
    }
    _className.head
  }

  override def visitBinaryOp(ast: BinaryOp, c: Context)={
    val env= c.asInstanceOf[CheckMethod2].lst
    val left= ast.left.accept(this,c)
    _className=List()
    val right = ast.right.accept(this,c)
    _className=List()
    ast.op match{
      case "+"=>{
        if((left==IntType || left==FloatType)&&(right==IntType|| right==FloatType)){
          if(left==FloatType|| right==FloatType) FloatType
          else IntType
        }
        else throw TypeMismatchInExpression(ast)
      }
      case "-"=> {
        if ((left == IntType || left == FloatType) && (right == IntType || right == FloatType)) {
          if (left == FloatType || right == FloatType) FloatType
          else IntType
        }
        else throw TypeMismatchInExpression(ast)
      }
      case "*"=>{
        if((left==IntType || left==FloatType)&&(right==IntType|| right==FloatType)){
          if(left==FloatType|| right==FloatType) FloatType
          else IntType
        }
        else throw TypeMismatchInExpression(ast)
      }
      case "/"=>{
        if((left==IntType|| left==FloatType)&&(right== IntType||right==FloatType)) FloatType
        else throw TypeMismatchInExpression(ast)
      }
      case "\\"=> {
        if (left == IntType && right == IntType) IntType
        else throw TypeMismatchInExpression(ast)
      }
      case "%"=>{
        if (left == IntType && right == IntType) IntType
        else throw TypeMismatchInExpression(ast)
      }
      case "=="=>{
        if((left==IntType&& right==IntType)||(left==BoolType&& right==BoolType)) BoolType
        else throw TypeMismatchInExpression(ast)
      }
      case "!="=>{
        if((left==IntType&& right==IntType)||(left==BoolType&& right==BoolType)) BoolType
        else throw TypeMismatchInExpression(ast)
      }
      case "<"=>{
        if((left==IntType||left==FloatType)&&(right==IntType|| right==FloatType)) BoolType
        else throw TypeMismatchInExpression(ast)
      }
      case ">"=>{
        if((left==IntType||left==FloatType)&&(right==IntType|| right==FloatType)) BoolType
        else throw TypeMismatchInExpression(ast)
      }
      case "<="=>{
        if((left==IntType||left==FloatType)&&(right==IntType|| right==FloatType)) BoolType
        else throw TypeMismatchInExpression(ast)
      }
      case ">="=>{
        if((left==IntType||left==FloatType)&&(right==IntType|| right==FloatType)) BoolType
        else throw TypeMismatchInExpression(ast)
      }
      case "^"=>{
        if(left==StringType&& right==StringType) StringType
        else throw TypeMismatchInExpression(ast)
      }
      case "||"=>{
        if(left==BoolType && right== BoolType) BoolType
        else throw TypeMismatchInExpression(ast)
      }
      case "&&"=>{
        if(left==BoolType && right== BoolType) BoolType
        else throw TypeMismatchInExpression(ast)
      }
    }
  }

  override def visitUnaryOp(ast: UnaryOp, c: Context)={
    val expr=ast.body.accept(this,c)
    ast.op match{
      case "+"=>{
       if(expr==FloatType|| expr==IntType) expr
       else throw TypeMismatchInExpression(ast)
      }
      case "-"=>{
        if(expr==FloatType|| expr==IntType) expr
        else throw TypeMismatchInExpression(ast)
      }
      case "!"=>{
        if(expr==BoolType) BoolType
        else throw TypeMismatchInExpression(ast)
      }
    }
  }

  override def visitNewExpr(ast: NewExpr, c: Context)={
    val findClass=lst.find(x=>x._1==ast.name.name)
    if(findClass!=None){
      val constructor= findClass.toList.head._3.find(x=>x._1==ast.name.name&& x._3==3)
      if(constructor!=None){
        val paramPattern= constructor.toList.head._4.map(x=>x._2)
        val paramTrans= ast.exprs.map(x=>x.accept(this,c)).asInstanceOf[List[Type]]
        if(lookUpParam(paramPattern,paramTrans)==false && paramTrans.size!=0) throw TypeMismatchInExpression(ast)
      }
      else {
        val paramTrans= ast.exprs.map(x=>x.accept(this,c)).asInstanceOf[List[Type]]
        if(paramTrans.size!=0) throw TypeMismatchInExpression(ast)
      }
    }
    else throw Undeclared(Class,ast.name.name)
    ClassType(ast.name.name)
  }

  override def visitArrayCell(ast: ArrayCell, c: Context)={

    val arr= ast.arr.accept(this,c)
    val idx=ast.idx.accept(this,c)
    if (idx!=IntType) throw TypeMismatchInExpression(ast)
   // System.out.println(!arr.isInstanceOf[ArrayType])
    if(!arr.isInstanceOf[ArrayType])
     // System.out.println(!arr.isInstanceOf[ArrayType])
     throw TypeMismatchInExpression(ast)

    arr
  }


  //======================end Expression=============================
  override def visitId(ast: Id, c: Context)={
    _flagConst=true
    val env=c.asInstanceOf[CheckMethod2].lst
    val envF=env.flatten.find(x=>x._1==ast.name)

    if(envF!=None) envF.toList.map(x=>x._2).head
    else{
      val findClass=lst.find(x=>x._1==ast.name)
      if(findClass!=None) ClassType(ast.name)
      else throw Undeclared(Identifier,ast.name)
    }
  }

  override def visitReturn(ast: Return, c: Context)={
    val env= c.asInstanceOf[CheckMethod2].lst
    ast.expr.accept(this,c)
    env
  }



  override def visitIntLiteral(ast: IntLiteral, c: Context) = IntType
  override def visitFloatLiteral(ast: FloatLiteral, c: Context) = FloatType
  override def visitStringLiteral(ast: StringLiteral, c: Context) = StringType
  override def visitBooleanLiteral(ast: BooleanLiteral, c: Context) = BoolType

  //  override def visitNullLiteral(ast: NullLiteral.type, c: Context) = null
  override def visitArrayType(ast: ArrayType, c: Context)={

 //  System.out.println("visitArrayType " +ast.eleType)
    ArrayType(ast.dimen,ast.eleType)
  //  null
  }

  override def visitSelfLiteral(ast: SelfLiteral.type, c: Context)={
    "this"
  }
  override def visitIntType(ast: IntType.type, c: Context) = IntType
  override def visitFloatType(ast: FloatType.type, c: Context) = FloatType
  override def visitBoolType(ast: BoolType.type, c: Context) = BoolType
  override def visitStringType(ast: StringType.type, c: Context) = StringType
  override def visitVoidType(ast: VoidType.type, c: Context) = VoidType
}

trait utils {
def lookUpParam(paramPattern:List[Type],parameter: List[Type]) ={
  if(paramPattern.size==parameter.size){
    parameter.zip(paramPattern).forall(x=>coercion(x._2,x._1))
  }
  else false
}
  def coercion(pattern:Type,trans:Type)={
    if( pattern==FloatType && trans==IntType) true
    else{
      if(pattern.isInstanceOf[ArrayType]&& trans.isInstanceOf[ArrayType]){
        if(pattern.asInstanceOf[ArrayType].dimen==trans.asInstanceOf[ArrayType].dimen &&
          pattern.asInstanceOf[ArrayType].eleType==FloatType && trans.asInstanceOf[ArrayType].eleType==IntType) true
        else false
      }
      else pattern==trans
    }
  }
/*def globalClass(lst:List[(String,String,List[(String,Type,Int,List[(String,Type)])])],name:String)={
  val findClass= lst.find(x=>x._1== name)
  if(findClass!=None)
}*/
}