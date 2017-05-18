/**
 *	@author Nguyen Hua Phung
 *	@version 1.0
 *	23/10/2015
 * 	This file provides a simple version of code generator
 *
 */

package bkool.codegen





import bkool.checker._
import bkool.utils._
import java.io.{PrintWriter, File}

case class MethodType(in:List[Type],out:Type) extends Type

class GlobalEnvironment(env:List[ClassData]) extends BaseVisitor {
    override def visitProgram(ast:Program,o:Context) = ast.decl.foldLeft(ListClass(env))((x,y) => visit(y,x).asInstanceOf[ListClass])
    
    override def visitClassDecl(ast:ClassDecl,o:Context) = {
      val env = o.asInstanceOf[ListClass].value
      ListClass(ClassData(ast.name.name,if (ast.parent == null) "" else ast.parent.name,
              ast.decl.foldLeft(List[Member]())((x,y) => visit(y,ListMember(x)).asInstanceOf[List[Member]]))::env)
    }
    //case class Member(val name:String,val skind:SIKind,val kind:Kind,val mtype:BKType,val value:Option[Expr])

    override def visitAttributeDecl(ast: AttributeDecl,o: Context)={
     val env= o.asInstanceOf[ListMember].value
     val decl= visit(ast.decl,o).asInstanceOf[Member]
    //println(varDecl.name)
      Member(decl.name,ast.kind,decl.kind,decl.mtype,None)::env
    }
    override def visitConstDecl(ast: ConstDecl,o: Context)={
      val env= o.asInstanceOf[ListMember].value

     // val envConst= Access()
      Member(ast.id.name,Instance,Constant,visit(ast.constType,o).asInstanceOf[DType],Option(ast.const))
    }
    override def visitVarDecl(ast: VarDecl,o: Context)={
     // val env= o.asInstanceOf[ListMember].value
     val variable= ast.variable.name
     val varType= ast.varType
    // println(varType)
    Member(variable,Instance,Variable,visit(varType,o).asInstanceOf[DType],None)
    }
    
    override def visitMethodDecl(ast:MethodDecl,o:Context) = {
      val env = o.asInstanceOf[ListMember].value
      Member(ast.name.name,ast.kind,if(ast.returnType == null ) SpecialMethod else Method,
            MType(ast.param.map(x=>visit(x.paramType,o)).asInstanceOf[List[DType]],if (ast.returnType != null) visit(ast.returnType,o).asInstanceOf[DType] else VType),None) ::env
    }
    
    override def visitIntType(ast:IntType.type,o:Context) = IType
    override def visitFloatType(ast:FloatType.type,o:Context) = FType
    override def visitStringType(ast:StringType.type,o:Context) = SType
    override def visitBoolType(ast:BoolType.type,o:Context) = BType
    override def visitVoidType(ast:VoidType.type,o:Context) = VType
    override def visitArrayType(ast:ArrayType,o:Context) = AType(visit(ast.eleType,o).asInstanceOf[PType],ast.dimen.value)
    override def visitClassType(ast:ClassType,o:Context) = CType(ast.classType)
       
}

object CodeGenerator extends Utils {
  def init() = {
    val mem = List( Member("readInt",Static,Method,MType(List(),IType),None),
                      Member("writeInt",Static,Method,MType(List(IType),VType),None),
                      Member("writeIntLn",Static,Method,MType(List(IType),VType),None),
                      Member("readFloat",Static,Method,MType(List(),FType),None),
                      Member("writeFloat",Static,Method,MType(List(FType),VType),None),
                      Member("writeFloatLn",Static,Method,MType(List(FType),VType),None),
                      Member("readBool",Static,Method,MType(List(),BType),None),
                      Member("writeBool",Static,Method,MType(List(BType),VType),None),
                      Member("writeBoolLn",Static,Method,MType(List(BType),VType),None),
                      Member("readStr",Static,Method,MType(List(),SType),None),
                      Member("writeStr",Static,Method,MType(List(SType),VType),None),
                      Member("writeStrLn",Static,Method,MType(List(SType),VType),None)
                    )
    ClassData("io","",mem)
  }
	def check(ast:AST,dir:File) = {

    val io = init() 
		val ge = new GlobalEnvironment(List(io))
    val sl = ge.visit(ast,null).asInstanceOf[ListClass]
    
		val gc = new CodeGenVisitor(ast,sl.value,dir)
    
		gc.visit(ast, null);
    
	}
}




trait BKType
trait DType extends BKType
trait PType extends DType
case object IType extends PType
case object FType extends PType
case object VType extends PType
case object SType extends PType
case object BType extends PType
case object NType extends PType
case class CType(cname:String) extends PType
case class AType(memtype:PType,dim:Int) extends DType
case class MType(partype:List[DType],rettype:DType) extends BKType

case class Member(val name:String,val skind:SIKind,val kind:Kind,val mtype:BKType,val value:Option[Expr])
case class ClassData(val cname:String,val pname:String,val mem:List[Member])

case class ListMember(value:List[Member]) extends Context
case class ListClass(value:List[ClassData]) extends Context

case class SuperClass(parent:String) extends Context
case class SubContext(emit:Emitter,classname:String,parent:String,decl:List[Decl]) extends Context // dùng cho các khai báo field
case class SubBody(emit:Emitter,classname:String,frame:Frame,sym:List[(String,Type,Val)]) extends Context
// SubBody dùng sinh mã cho method
class Access(val emit:Emitter,val classname:String,val frame:Frame,val sym:List[(String,Type,Val)],val isLeft:Boolean,val isFirst:Boolean) extends Context
// Access dùng cho sinh mã biểu thức
trait Val
  case class Index(value:Int) extends Val
  case class Const(value:Expr) extends Val
  
case object StringBuff extends Type
case object NullType extends Type





class CodeGenVisitor(astTree:AST,env:List[ClassData],dir:File) extends BaseVisitor with Utils {
	 var generateConstructor=true
   var outLoop= false
   override def visitProgram(ast:Program,c:Context) = ast.decl.map(visit(_,c))

   override def visitClassDecl(ast:ClassDecl,o:Context) = {
      val path = dir.getPath()
      val emit = new Emitter(path+"/"+ast.name.name+".j")
      val parent= ast.parent
      
      if(parent!=null) {

        emit.printout(emit.emitPROLOG(ast.name.name,ast.parent.name))
       // println("true")
        val declAttribute= ast.decl.filter(_.isInstanceOf[AttributeDecl]).map(x=> visit(x,SubContext(emit,ast.name.name,ast.parent.name,List()))).asInstanceOf[List[Decl]]
        val declMethod =    ast.decl.filter(_.isInstanceOf[MethodDecl]).map(x=> visit(x,SubContext(emit,ast.name.name,ast.parent.name,declAttribute)))
        //println(declAttribute)
        if(generateConstructor){
          genMETHOD(ast.name.name,ast.parent.name,
            MethodDecl(Instance,ast.name,List(),null,Block(List(),List())),o,List(),new Frame("<init>",VoidType),emit) 
          generateConstructor=true  
        }
      }
      else {
        emit.printout(emit.emitPROLOG(ast.name.name, "java.lang.Object"))    
        val declAttribute= ast.decl.filter(_.isInstanceOf[AttributeDecl]).map(x=> visit(x,SubContext(emit,ast.name.name,"java.lang.Object",List()))).asInstanceOf[List[Decl]]
        val declMethod =    ast.decl.filter(_.isInstanceOf[MethodDecl]).map(x=> visit(x,SubContext(emit,ast.name.name,"java.lang.Object",List())))
        if(generateConstructor){
         genMETHOD(ast.name.name,"",
            MethodDecl(Instance,ast.name,List(),null,Block(List(),List())),o,List(),new Frame("<init>",VoidType),emit) 
          generateConstructor= true
        }
            
    }
      // generate default constructor 
      emit.emitEPILOG()
      o   
  }
  
 
    /** generate code for default constructor 
   *  @param classname the name of the enclosing class
   *  @param lst the list of instance attributes (array type or immutable) that need to initialize
   *  @param frame the frame where the initialization happen 
   *  @param v the visitor that visits the sub-node to generate code
   */
  def genMETHOD(classname:String,classParent: String,consdecl:MethodDecl,o:Context,lst:List[Decl],frame:Frame,emit:Emitter) = {
    
    val isInit = consdecl.returnType == null
    val isMain = consdecl.kind == Static && consdecl.name.name == "main" && consdecl.param.length == 0 && consdecl.returnType == VoidType
    val returnType = if (isInit) VoidType else consdecl.returnType
    val methodName = if (isInit) "<init>" else consdecl.name.name
    val param = if (isMain) List(ParamDecl(Id("args"), ArrayType(IntLiteral(0),StringType))) else consdecl.param
    val mtype =  MethodType(param.map(_.paramType),returnType)
    
    emit.printout(emit.emitMETHOD(methodName, mtype, consdecl.kind==Static,frame));
    frame.enterScope(true);
    
    // Generate code for parameter declarations
    if (consdecl.kind == Instance) emit.printout(emit.emitVAR(frame.getNewIndex,"this",ClassType(classname),frame.getStartLabel,frame.getEndLabel,frame))
    val env = param.foldLeft(List[(String,Type,Val)]())((y,x) => visit(x,SubBody(emit,classname,frame,y)).asInstanceOf[List[(String,Type,Val)]])
    //env for param+

    val body = consdecl.body.asInstanceOf[Block]
    
    //Generate code for local declarations
    //env for body of method
    val newenv = body.decl.foldLeft(List[(String,Type,Val)]())((y,x) => visit(x,SubBody(emit,classname,frame,y)).asInstanceOf[List[(String,Type,Val)]])
    emit.printout(emit.emitLABEL(frame.getStartLabel(),frame))
   // println(newenv++env)
    //Generate code for statements
    if (isInit) {
     // println(classname+" access init")
      generateConstructor=false
      emit.printout(emit.emitREADVAR("this",ClassType(classname),0,frame))
      if(classParent!="")
        emit.printout(emit.emitINVOKESPECIAL(frame,classParent))
      else
        emit.printout(emit.emitINVOKESPECIAL(frame))
    }
    //println(newenv++env)
    body.stmt.map(x=>visit(x,SubBody(emit,classname,frame,newenv++env)))

    //println(body)
    emit.printout(emit.emitLABEL(frame.getEndLabel(),frame))
    if (returnType == VoidType) emit.printout(emit.emitRETURN(VoidType,frame));
    else emit.printout(emit.emitRETURN(returnType,frame))
    emit.printout(emit.emitENDMETHOD(frame));
    frame.exitScope();
  }
  override def visitMethodDecl(ast:MethodDecl,o:Context) = {
    val subctxt = o.asInstanceOf[SubContext]
    val emit = subctxt.emit
    val frame = new Frame(ast.name.name,ast.returnType)
    genMETHOD(subctxt.classname,"",ast,o,subctxt.decl,frame,emit)
    o
  }
  
  override def visitParamDecl(ast:ParamDecl,o:Context) = {
    val ctxt = o.asInstanceOf[SubBody]
    val emit = ctxt.emit
    val frame = ctxt.frame
    val env = ctxt.sym
    val idx = frame.getNewIndex
    emit.printout(emit.emitVAR(idx,ast.id.name,ast.paramType,frame.getStartLabel(),frame.getEndLabel(),frame))
    env :+ (ast.id.name,ast.paramType,Index(idx))
  }
  /*case class Member(val name:String,val skind:SIKind,val kind:Kind,val mtype:BKType,val value:Option[Expr])
  case class ClassData(val cname:String,val pname:String,val mem:List[Member])

  case class ListClass(value:List[ClassData]) extends Context*/

  override def visitCall(ast:Call,o:Context) = {
    val ctxt = o.asInstanceOf[SubBody]
    val emit = ctxt.emit
    val frame = ctxt.frame
    val nenv = ctxt.sym
   
    var isNameOfClass= true
    var isStatic = true
    //println(frame.getStackSize())
    val (str,typ) = visit(ast.parent,new Access(emit,ctxt.classname,frame,nenv,true,true)).asInstanceOf[(String,Type)]
    //println(typ)
    //println(frame.getStackSize())
    // println("below params "+ str)
    val in = ast.params.foldLeft(("",List[Type]()))((y,x)=> //type params
      {
        val (str1,typ1) = visit(x,new Access(emit,ctxt.classname,frame,nenv,false,true)).asInstanceOf[(String,Type)]
        (y._1 + str1,y._2 :+ typ1)
      }
    )

    //println("below in "+frame.getStackSize())
   // println(frame.getStackSize())
    val nameClass= ast.parent.isInstanceOf[Id] match{
      case true=>{
        lookup(ast.parent.asInstanceOf[Id].name, nenv, (x:(String,Type,Val))=>x._1)  match {
          case Some((a,b,c))=> {

            isNameOfClass= false
            b.asInstanceOf[ClassType].classType
          }
          case _=> ast.parent.asInstanceOf[Id].name
        }
      }
      case _=> {
        isNameOfClass= false
        typ.asInstanceOf[ClassType].classType 
      }
    }

    val findClass= env.find(x=> x.cname== nameClass).toList.head
    val findAttribute = findClass.mem.find(x=> x.name== ast.method.asInstanceOf[Id].name) match{
      case None=> {
        val nameOfParent= findClass.pname
        val findParent = env.find(x=> x.cname== nameOfParent).toList.head
        val attributeInParent= findParent.mem.find(x=> x.name== ast.method.asInstanceOf[Id].name).toList.head
        
        attributeInParent
      }
      case Some(a)=> a
    }
    isStatic= findAttribute.skind == Static

   //println(isNameOfClass)
   //println(isStatic)
    if(isNameOfClass){// use class to access directly

      val code= typ.asInstanceOf[ClassType].classType

      emit.printout(in._1)
         //println("Call "+ str)
      emit.printout(emit.emitINVOKESTATIC(code+"/"+ast.method.name,MethodType(in._2,VoidType),frame))     
     
    }
    else {
 
      emit.printout(str)
      emit.printout(in._1)
      emit.printout(emit.emitINVOKEVIRTUAL(nameClass+"/"+ast.method.name,MethodType(in._2,VoidType),frame))
     // }
  }
  //println(frame.getStackSize())
  o
}
  //  case class SubBody(emit:Emitter,classname:String,frame:Frame,sym:List[(String,Type,Val)]) extends Context
//class Access(val emit:Emitter,val classname:String,val frame:Frame,val sym:List[(String,Type,Val)],val isLeft:Boolean,val isFirst:Boolean) extends Context
  override def visitBlock(ast: Block,o: Context)= {
    val ctxt= o.asInstanceOf[SubBody]
    val emit= ctxt.emit
    val frame= ctxt.frame
    val classname= ctxt.classname
    val env= ctxt.sym
    //val label1=frame.getNewLabel()
   // val label2= frame.getNewLabel()
    //val idx= frame.getNewIndex
    val scope= frame.enterScope(false)
    val newenv = ast.decl.foldLeft(List[(String,Type,Val)]())((y,x) => visit(x,SubBody(emit,classname,frame,y)).asInstanceOf[List[(String,Type,Val)]])
    //emit.printout(emit.emitLABEL(frame.getStartLabel(),frame))
    ast.stmt.map(x=>visit(x,SubBody(emit,classname,frame,newenv++env)))
   // emit.printout(emit.emitLABEL(frame.getEndLabel(),frame))
    frame.exitScope();
    o
  }
  
  override def visitIf(ast: If,o: Context)={
    val ctxt= o.asInstanceOf[SubBody]
    val emit = ctxt.emit
    val frame= ctxt.frame
    
    val (code, typ)= visit(ast.expr,new Access(emit,ctxt.classname,frame,ctxt.sym,false,true)).asInstanceOf[(String,Type)]
    val labelT= frame.getNewLabel()
    val labelF= frame.getNewLabel()

    emit.printout(code)
    emit.printout(emit.emitIFFALSE(labelF,frame))
    visit(ast.thenStmt,o)
   
    emit.printout(emit.emitGOTO(labelT,frame))
     emit.printout(emit.emitLABEL(labelF,frame))
    if(ast.elseStmt!=None) {
      visit(ast.elseStmt.get,o)
    }
    emit.printout(emit.emitLABEL(labelT,frame))
   
    o
  }
  override def visitFor(ast: For,o: Context)={
    val ctxt = o.asInstanceOf[SubBody]
    val emit = ctxt.emit
    val frame = ctxt.frame
    val env= ctxt.sym
    val (expr1,typExpr1)=visit(ast.expr1,new Access(emit,ctxt.classname,frame,env,false,true)).asInstanceOf[(String,Type)]
    val (cond,typCond)= visit(Id(ast.idx),new Access(emit,ctxt.classname,frame,env,true,false)).asInstanceOf[(String,Type)]
    outLoop= true
    emit.printout(expr1+cond)

    frame.enterLoop()
    val labelContinue= frame.getContinueLabel()
    val labelBreak= frame.getBreakLabel()
    emit.printout(emit.emitLABEL(labelContinue,frame))
    val (loadCompare,typLoadCompare)= visit(Id(ast.idx),new Access(emit,ctxt.classname,frame,env,true,true)).asInstanceOf[(String,Type)]

    val (expr2,typExpr2)= visit(ast.expr2, new Access(emit,ctxt.classname,frame,env,true,false)).asInstanceOf[(String,Type)]
    

    //val (toCond,typToCond)=visit(BinaryOp("<=",Id(ast.idx),ast.expr2),new Access(emit,ctxt.classname,frame,env,false,true)).asInstanceOf[(String,Type)]
    emit.printout(loadCompare+expr2)
    //println(frame.getStackSize())
    emit.printout(emit.emitIFICMPGT(labelBreak,frame))
    /*emit.printout(emit.emitPUSHCONST("true",BoolType,frame))
    frame.pop()*/
    visit(ast.loop,o)
    if(ast.up)visit(Assign(Id(ast.idx),BinaryOp("+",Id(ast.idx),IntLiteral(1))),o)
    else visit(Assign(Id(ast.idx),BinaryOp("-",Id(ast.idx),IntLiteral(1))),o)
    emit.printout(emit.emitGOTO(labelContinue,frame))
    emit.printout(emit.emitLABEL(labelBreak,frame))
    
    frame.exitLoop()
   // println(frame.getStackSize())
    o
  }
 
   override def visitReturn(ast: Return, o: Context)={
    val ctxt= o.asInstanceOf[SubBody]
    val emit= ctxt.emit
    val frame= ctxt.frame
    val (code,typ) = visit(ast.expr,new Access(emit,ctxt.classname,frame,ctxt.sym,false,false)).asInstanceOf[(String,Type)]
    emit.printout(code)
   // emit.printout(emit.emitRETURN(typ,frame))
    o
  }

  override def visitContinue(ast: Continue.type, c: Context)={
    val ctxt = c.asInstanceOf[SubBody]
    val emit = ctxt.emit
    val frame = ctxt.frame
    val continueLabel = emit.emitGOTO(frame.getContinueLabel(), frame)
    emit.printout(continueLabel)
    c
  }
   override def visitBreak(ast: Break.type, o: Context) = {
    val ctxt = o.asInstanceOf[SubBody]
    val emit = ctxt.emit
    val frame = ctxt.frame
    val breakLabel = emit.emitGOTO(frame.getBreakLabel(), frame)
    emit.printout(breakLabel)
    
  }
  override def visitId(ast:Id,o:Context) = {  
      val ctxt = o.asInstanceOf[Access]
      val envBlock = ctxt.sym
      val emit= ctxt.emit
      val frame= ctxt.frame
     // println(envBlock)
    // println(ast.name)
      //println("visit Id "+ ast.name)
      //println(envBlock)
      lookup(ast.name,envBlock,(x:(String,Type,Val)) => x._1) match {
        case Some((a,b,c))=>{
          //println("Some")
          if(c.isInstanceOf[Const]){
           // println("const")
            val res = visit(c.asInstanceOf[Const].value,new Access(ctxt.emit,ctxt.classname,ctxt.frame,envBlock,false,true))
            res
          }
          else{
           // println("not const")
            if(ctxt.isLeft&& !ctxt.isFirst){
             // println("ctxt is first false")
             
                val res= emit.emitWRITEVAR(a,b,c.asInstanceOf[Index].value,ctxt.frame)
                (res,b)
             
            } 
            else{
             // println(a+" "+frame.getStackSize())
             // println(" not left and first")
            
                val res= emit.emitREADVAR(a,b,c.asInstanceOf[Index].value,ctxt.frame)
                                       //println("id "+frame.getStackSize())
                                       //println(res)
                (res,b)
              

           } 
          }
        }
        case _ => {
          //println(ast.name)
          val findClass= env.find(x=>x.cname== ctxt.classname ).toList.head

          val attributeSome= findClass.mem.find(x=>x.name == ast.name) match{
            case None=>{
              if(!findClass.pname.equals("")){
                var findParent= env.find(x=> x.cname== findClass.pname).toList.head
                var nameParent= findParent.pname
                var attributeInParent= findParent.mem.find(x=>x.name == ast.name)
                while(attributeInParent==None && !findParent.pname.equals("")){
                  nameParent= findParent.pname
                  findParent= env.find(x=> x.cname== nameParent).toList.head
                  attributeInParent= findParent.mem.find(x=>x.name == ast.name) 
                //println(ast.name)
               // println(findParent.pname.equals(""))
                }
                attributeInParent
              }
              else None
            }
            case Some(a)=> Some(a)
          }
          
          if(attributeSome!= None) {
            val attribute=attributeSome.toList.head
            var isStatic= attribute.skind== Static 
            var isLeft= ctxt.isLeft
            if(isLeft)

            {// println("isLeft true")
              if(isStatic){
                val res= emit.emitPUTSTATIC(ctxt.classname+"."+ast.name,transType(attribute.mtype.asInstanceOf[DType]),frame)
                (res,transType(attribute.mtype.asInstanceOf[DType]))
              }
              else {
                val res= emit.emitPUTFIELD(ctxt.classname+"."+ast.name,transType(attribute.mtype.asInstanceOf[DType]),frame)
                (res,transType(attribute.mtype.asInstanceOf[DType]))
              }
            }
            else{

              if(isStatic){
                val res= emit.emitGETSTATIC(ctxt.classname+"."+ast.name,transType(attribute.mtype.asInstanceOf[DType]),frame)
                (res,transType(attribute.mtype.asInstanceOf[DType]))
              }
              else{
                val res= emit.emitGETFIELD(ctxt.classname+"."+ast.name,transType(attribute.mtype.asInstanceOf[DType]),frame)
                (res,transType(attribute.mtype.asInstanceOf[DType]))
              }
            }
          }
          else{
               //println(ast.name.equals("Self()"))
                      env.find(x=>x.cname==(if(ast.name.equals("Self()")) ctxt.classname else ast.name)) match {
                      case Some(c) => ("",ClassType(ast.name))
                      case None => throw Undeclared(Identifier,ast.name)
                      }
                    }
        }
        
      }
      /*lookup(ast.name,env,(x:ClassData)=>x.cname) match {
        case Some(c) => (ast.name,ClassType(ast.name))
        case None => throw Undeclared(Identifier,ast.name)
      }  */
     
  }
  
 //======================LITERAL=================================
  override def visitIntLiteral(ast:IntLiteral,o:Context) = {
    val ctxt = o.asInstanceOf[Access]
    val emit = ctxt.emit
    val frame = ctxt.frame
    //println("IntLiteral")
    (emit.emitPUSHICONST(ast.value, frame),IntType)
  }
  override def visitFloatLiteral(ast: FloatLiteral,o: Context)={
    val ctxt= o.asInstanceOf[Access]
    val emit= ctxt.emit
    val frame = ctxt.frame

    (emit.emitPUSHCONST(ast.value.toString(),FloatType,frame),FloatType)

  }
  override def visitStringLiteral(ast: StringLiteral,o: Context)={
    val ctxt= o.asInstanceOf[Access]
    val emit= ctxt.emit
    val frame= ctxt.frame
    (emit.emitPUSHCONST(ast.value,StringType,frame),StringType)
  }
  override def visitBooleanLiteral(ast:BooleanLiteral,o: Context)={
    val ctxt= o.asInstanceOf[Access]
    val emit= ctxt.emit
    val frame= ctxt.frame
  // println("ok")
    (emit.emitPUSHCONST(ast.value.toString(),BoolType,frame),BoolType)
  }
  override def visitSelfLiteral(ast:SelfLiteral.type,o: Context)={
    val ctxt = o.asInstanceOf[Access]
    val emit = ctxt.emit
    val frame = ctxt.frame

    ("",ClassType(ctxt.classname))
  }
  override def visitNullLiteral(ast: NullLiteral.type,o: Context)={
    val ctxt= o.asInstanceOf[Access]
    val emit= ctxt.emit
    val frame= ctxt.frame
    (emit.emitPUSHCONST("",NullType,frame),VoidType)
  }
  //============================================
  //case class SubContext(emit:Emitter,classname:String,parent:String,decl:List[Decl]) extends Context // dùng cho các khai báo field
//case class SubBody(emit:Emitter,classname:String,frame:Frame,sym:List[(String,Type,Val)]) extends Context
//class Access(val emit:Emitter,val classname:String,val frame:Frame,val sym:List[(String,Type,Val)],val isLeft:Boolean,val isFirst:Boolean) extends Context
   override def visitNewExpr(ast: NewExpr, o: Context)={
    val ctxt = o.asInstanceOf[Access]
    val emit = ctxt.emit
    val frame = ctxt.frame
    val typParams= ast.exprs.foldLeft("")((a,b)=>a+emit.getJVMType(visit(b,new Access(emit,ctxt.classname,frame,ctxt.sym,false,true)).asInstanceOf[(String,Type)]._2))
   // println(param)
    val codeParams = ast.exprs.foldLeft("")((a,b)=>a+visit(b,new Access(emit,ctxt.classname,frame,ctxt.sym,false,true)).asInstanceOf[(String,Type)]._1)
    val res= emit.emitNEW(ClassType(ast.name.name),frame)+codeParams+emit.emitINVOKESPECIAL(frame,ast.name.name,typParams)
    (res,ClassType(ast.name.name))
  }
  /*case class Member(val name:String,val skind:SIKind,val kind:Kind,val mtype:BKType,val value:Option[Expr])
  case class ClassData(val cname:String,val pname:String,val mem:List[Member])

  case class ListClass(value:List[ClassData]) extends Context*/
  def transType(typ:DType)={
    if(typ == IType) IntType
    else if(typ.isInstanceOf[CType]) ClassType(typ.asInstanceOf[CType].cname)
    else if(typ == FType) FloatType
    else if(typ == VType) VoidType
    else if(typ == SType) StringType
    else BoolType
  }
  override def visitCallExpr(ast: CallExpr,o: Context)={
    val ctxt= o.asInstanceOf[Access]
    val emit= ctxt.emit
    val frame = ctxt.frame
    val nenv= ctxt.sym
   
    var isNameOfClass= true
    var isStatic = true
   // println("before call expr ")
    val (str,typ) = visit(ast.cName,new Access(emit,ctxt.classname,frame,nenv,false,true)).asInstanceOf[(String,Type)]
     println("call expr "+str)
    val in = ast.params.foldLeft(("",List[Type]()))((y,x)=> //type params
      {
        val (str1,typ1) = visit(x,new Access(emit,ctxt.classname,frame,nenv,false,true)).asInstanceOf[(String,Type)]
        (y._1 + str1,y._2 :+ typ1)
      }
    )

   val nameClass= ast.cName.isInstanceOf[Id] match{
      case true=>{
        lookup(ast.cName.asInstanceOf[Id].name, nenv, (x:(String,Type,Val))=>x._1)  match {
          case Some((a,b,c))=> {
            isNameOfClass= false
            b.asInstanceOf[ClassType].classType
          }
          case _=> ast.cName.asInstanceOf[Id].name
        }
      }
      case _=> {
        isNameOfClass=false
        typ.asInstanceOf[ClassType].classType 
      }
    }
    val findClass= env.find(x=> x.cname== nameClass).toList.head
    val findAttribute = findClass.mem.find(x=> x.name== ast.method.asInstanceOf[Id].name) match{
      case None=> {
        val nameOfParent= findClass.pname
        val findParent = env.find(x=> x.cname== nameOfParent).toList.head
        val attributeInParent= findParent.mem.find(x=> x.name== ast.method.asInstanceOf[Id].name).toList.head
        
        attributeInParent
      }
      case Some(a)=> a
    }
    isStatic= findAttribute.skind == Static
    val typMethod= findAttribute.mtype
      //println(transType(typMethod.asInstanceOf[MType].rettype))
     // isInvokeStatic = findMethod.skind== Static
    if(isNameOfClass){// if using class to access directly, the method has to be Static=> use emitINVOKESTATIC
        (in._1+emit.emitINVOKESTATIC(str+"/"+ast.method.name,MethodType(in._2,transType(typMethod.asInstanceOf[MType].rettype)),frame),transType(typMethod.asInstanceOf[MType].rettype) )
      }
    else{
     // println(str)
     (str+ in._1+ emit.emitINVOKEVIRTUAL(nameClass+"/"+ast.method.name,MethodType(in._2,transType(typMethod.asInstanceOf[MType].rettype)),frame),transType(typMethod.asInstanceOf[MType].rettype))
    }
  }
  override def visitFieldAccess(ast: FieldAccess,o: Context)={
    val ctxt = o.asInstanceOf[Access]
    val emit = ctxt.emit
    val frame = ctxt.frame
    val nenv = ctxt.sym

    var isClassName= true
    var isStatic= true
    //println(frame.getStackSize())

   // println("visit FieldAccess before expr "+frame.getStackSize())
   //println("kdkd "+nenv)
   //println(ctxt.isLeft)
    val (code,typ)= ctxt.isLeft match {
      case true =>  {
        if (ctxt.isFirst) visit(ast.name,new Access(emit,ctxt.classname,frame,nenv,true,ctxt.isFirst)).asInstanceOf[(String,Type)]
        else ("",ClassType(ctxt.classname)).asInstanceOf[(String,Type)]
      }
      case _=>  
      { 
        visit(ast.name,new Access(emit,ctxt.classname,frame,nenv,false,true)).asInstanceOf[(String,Type)]
        
      }
    }    

   // println("visit FieldAccess below expr "+frame.getStackSize())
//println(frame.getStackSize())
    //println("FieldAccess "+code)
    //println(code)
    val className= ast.name.isInstanceOf[Id] match{
      case true =>{
        
          lookup(ast.name.asInstanceOf[Id].name,nenv,(x:(String,Type,Val))=>x._1) match{
            case Some((a,b,c)) => {
              isClassName=false
              b.asInstanceOf[ClassType].classType
              
            }
            case _=> ast.name.asInstanceOf[Id].name
          }
        
      }
      case _=>{
        if(ast.name== SelfLiteral) {ctxt.classname}
        else
        {       isClassName= false
                typ.asInstanceOf[ClassType].classType}
        
      }
    }
   //println("kdjdjn  "+code+" "+ className)
    val findClass= env.find(x=> x.cname == className).toList.head
    var parentClassName= findClass.pname

    var attribute=findClass.mem.find(x=> x.name== ast.field.asInstanceOf[Id].name) match{
      case None=>{
        
        var findParent= env.find(x=>x.cname== parentClassName).toList.head
        var attributeInParent= findParent.mem.find(x=>x.name== ast.field.asInstanceOf[Id].name)
        while(attributeInParent==None){
          parentClassName= findParent.pname
          findParent=env.find(x=>x.cname== parentClassName).toList.head
          attributeInParent= findParent.mem.find(x=>x.name== ast.field.asInstanceOf[Id].name)
        }
        //println(attributeInParent.toList.head) 
        attributeInParent.toList.head

      }
      case Some(a)=> a
    }

     // println(attribute)
    // println(frame.getStackSize())
    //println(isClassName) 
    //println(ctxt.isFirst)

   if(isClassName){
       
       (  
         (if(ctxt.isFirst && ctxt.isLeft) ""
           else
           (if(ctxt.isLeft)
                 emit.emitPUTSTATIC(className+"."+ast.field.asInstanceOf[Id].name, transType(attribute.mtype.asInstanceOf[DType]), frame)
               else
                 emit.emitGETSTATIC(className+"."+ast.field.asInstanceOf[Id].name, transType(attribute.mtype.asInstanceOf[DType]), frame))
   
           ),
       transType(attribute.mtype.asInstanceOf[DType]))}
   else{
       // println(ctxt.isFirst)
       //println("visitFieldAccess "+ast.name.toString+" "+ast.field.toString+" "+frame.getStackSize())
        (code+
          (if(ctxt.isFirst && ctxt.isLeft) ""
                    else
                       (if(ctxt.isLeft ) 
                          emit.emitPUTFIELD(className+"."+ast.field.asInstanceOf[Id].name, transType(attribute.mtype.asInstanceOf[DType]), frame)
                        else
                          emit.emitGETFIELD(className+"."+ast.field.asInstanceOf[Id].name, transType(attribute.mtype.asInstanceOf[DType]), frame)
                       )
           ),
        transType(attribute.mtype.asInstanceOf[DType]))
      
    }
  }
  override def visitAttributeDecl(ast: AttributeDecl,o: Context)={
    //println("attributes")
    //println(env)
    val ctxt= o.asInstanceOf[SubContext]
    val emit= ctxt.emit
    val classname= ctxt.classname
    val isFinal= ast.decl.isInstanceOf[ConstDecl]
    if(isFinal) {
        val const= ast.decl.asInstanceOf[ConstDecl]
        if(const.const.isInstanceOf[IntLiteral]){
        //  println(const.constType)
          emit.printout(emit.emitATTRIBUTE(
            const.id.name,
            ast.kind,
            const.constType,
            isFinal,
            const.const.asInstanceOf[IntLiteral].value.toString()))
        }
        else if(const.const.isInstanceOf[FloatLiteral])
          emit.printout(emit.emitATTRIBUTE(
            const.id.name,
            ast.kind,
            const.constType,
            isFinal,
            const.const.asInstanceOf[IntLiteral].value.toString()))
        else if(const.const.isInstanceOf[StringLiteral])
          emit.printout(emit.emitATTRIBUTE(
            const.id.name,
            ast.kind,
            const.constType,
            isFinal,
            const.const.asInstanceOf[StringLiteral].value.toString()))
        else{
         // println(const.constType)
          emit.printout(emit.emitATTRIBUTE(
            const.id.name,
            ast.kind,
            const.constType,
            isFinal,
            const.const.asInstanceOf[BooleanLiteral].value.toString()))
        }
       /* if()
          emit.printout("\t"+"aload_0"+"\n"+)*/
       //   val frame = new Frame()


    }
    else emit.printout(emit.emitATTRIBUTE(ast.decl.asInstanceOf[VarDecl].variable.name,ast.kind,ast.decl.asInstanceOf[VarDecl].varType,isFinal,""))
    o
  }
  override def visitUnaryOp(ast: UnaryOp, o: Context) = {
   
    val ctxt = o.asInstanceOf[Access]
    val emit = ctxt.emit
    val frame = ctxt.frame
    val (str,typ) = visit(ast.body,o).asInstanceOf[(String,Type)]
    println(str)
    ast.op match {
      case "+" => (str,typ)
      case "-" => (str+emit.emitNEGOP(typ, frame),typ)
      case "!" => (str+emit.emitNOT(typ, frame),BoolType)
    }
  }
  override def visitBinaryOp(ast: BinaryOp,o: Context)={
    val ctxt = o.asInstanceOf[Access]
    val emit = ctxt.emit
    val (left,typeLeft)= ast.left.accept(this,o).asInstanceOf[(String,Type)]
    val (right,typeRight)= ast.right.accept(this,o).asInstanceOf[(String,Type)]
    val frame = ctxt.frame
    ast.op match {
      case ("+"|"-")=> {
        
        if(typeLeft==IntType&& typeRight== FloatType) 
        {

                (left+emit.emitI2F(frame)+right+emit.emitADDOP(ast.op,FloatType,frame),FloatType)
        }  
        else if(typeLeft== FloatType && typeRight== IntType)
        (left+ right+ emit.emitI2F(frame)+ emit.emitADDOP(ast.op,FloatType,frame),FloatType)
        else (left+ right+ emit.emitADDOP(ast.op,typeLeft,frame),typeLeft)
      }
      case "*"=>{
        if(typeLeft== IntType&& typeRight== FloatType)
        (left+emit.emitI2F(frame)+right+emit.emitMULOP(ast.op,FloatType,frame),FloatType)
        else if(typeLeft== FloatType&& typeRight== IntType)
        (left+ right+ emit.emitI2F(frame)+ emit.emitMULOP(ast.op,FloatType,frame),FloatType)
        else (left+ right+ emit.emitMULOP(ast.op,typeLeft,frame),typeLeft)
      }

      case "/"=> 
        (left+ (if(typeLeft== IntType) emit.emitI2F(frame) else "")+ right+ (if(typeRight==IntType)emit.emitI2F(frame)else "") + emit.emitMULOP(ast.op,FloatType,frame),FloatType)
      case "\\"=> 
        (left+ right+emit.emitMULOP(ast.op,IntType,frame),IntType)
      case "%"=> 
      (left+right+ emit.emitMOD(frame),IntType)
      case (">"|">="|"<"|"<="|"=="|"!=")=>
        if(typeLeft== IntType&& typeRight== FloatType) 
          (left+ emit.emitI2F(frame)+ right+ emit.emitREOP(ast.op,FloatType,frame),BoolType)
        else if(typeLeft== FloatType&& typeRight== IntType)
          (left+ right+ emit.emitI2F(frame)+ emit.emitREOP(ast.op,FloatType,frame),BoolType)
        else
          (left+right+ emit.emitREOP(ast.op,typeRight,frame),BoolType) 
      case "&&" => {
        //emit.emitANNOP
        val label1 = frame.getNewLabel()
        val label2 = frame.getNewLabel()
        val rep = new StringBuffer()
        rep.append(left)
        rep.append(emit.emitIFFALSE(label1, frame))
        rep.append(right)
        rep.append(emit.emitIFFALSE(label1, frame))
        rep.append(emit.emitPUSHCONST("true", BoolType, frame))
        rep.append(emit.emitGOTO(label2, frame))
        rep.append(emit.emitLABEL(label1, frame))
        rep.append(emit.emitPUSHCONST("false", BoolType, frame))
        rep.append(emit.emitLABEL(label2, frame))
        (rep.toString(),BoolType)
      }
      case "||" => {
        //emit.emitORP
        val label1 = frame.getNewLabel()
        val label2 = frame.getNewLabel()
        val rep = new StringBuffer()
        rep.append(left)
        rep.append(emit.emitIFTRUE(label1, frame))
        rep.append(right)
        rep.append(emit.emitIFTRUE(label1, frame))
        rep.append(emit.emitPUSHCONST("false", BoolType, frame))
        rep.append(emit.emitGOTO(label2, frame))
        rep.append(emit.emitLABEL(label1, frame))
        rep.append(emit.emitPUSHCONST("true", BoolType, frame))
        rep.append(emit.emitLABEL(label2, frame))
        (rep.toString(),BoolType)
      }
      case "^" => {
        var re = "\tnew java/lang/StringBuilder\n\tdup\n"
        frame.push()
        re = re + "\tinvokespecial java/lang/StringBuilder/<init>()V\n"+left+"\tinvokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;\n"
        frame.pop()
        re = re + right+"\tinvokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;\n\tinvokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;\n"
        frame.pop()
        (re, StringType)
      }
    }
  }
  override def visitVarDecl(ast:VarDecl,o:Context)={
    val ctxt= o.asInstanceOf[SubBody]
    val emit= ctxt.emit
    val frame= ctxt.frame
    val env = ctxt.sym
    val idx= frame.getNewIndex
    emit.printout(emit.emitVAR(idx,ast.variable.name,ast.varType,frame.getStartLabel(),frame.getEndLabel(),frame))
    (ast.variable.name,ast.varType,Index(idx))::env
    
  }
   
  override def visitConstDecl(ast: ConstDecl, o: Context)={
   val ctxt= o.asInstanceOf[SubBody]
   val emit= ctxt.emit
   val frame = ctxt.frame
   val env= ctxt.sym
   (ast.id.name,ast.constType,Const(ast.const))::env
  }
  // body.stmt.map(x=>visit(x,SubBody(emit,classname,frame,env++newenv)))
//  case class SubBody(emit:Emitter,classname:String,frame:Frame,sym:List[(String,Type,Val)]) extends Context
//class Access(val emit:Emitter,val classname:String,val frame:Frame,val sym:List[(String,Type,Val)],val isLeft:Boolean,val isFirst:Boolean) extends Context

  override def visitAssign(ast: Assign, c: Context)={
      val ctxt= c.asInstanceOf[SubBody]
      val emit = ctxt.emit
      val frame = ctxt.frame
      val env = ctxt.sym
      //println(env)

      val (left1, typeLeft1)= if(ast.leftHandSide.isInstanceOf[Id])("",VoidType) else visit(ast.leftHandSide, new Access(emit,ctxt.classname,frame,env,true,true)).asInstanceOf[(String,Type)]
      //println("ok visitAssign"+left1)
      //println("Assign after left 1 "+ast.leftHandSide.toString+" " +frame.getStackSize())
      val (right, typeRight) = visit(ast.expr,new Access(emit,ctxt.classname,frame,env,false,false)).asInstanceOf[(String,Type)]
      //println("visitAssign pass right")
     // println(frame.getStackSize())
     //println("Assign after right "+ast.leftHandSide.toString+" " +frame.getStackSize())
      val (left2, typeLeft2) = visit(ast.leftHandSide, new Access(emit,ctxt.classname,frame,env,true,false)).asInstanceOf[(String,Type)]
      //println("visitAssign pass left2 "+left1+right+left2)
     //println("Assign after left 2 "+ast.leftHandSide.toString+" " +frame.getStackSize())
      if(typeRight==IntType && typeLeft2==FloatType)
        emit.printout(left1+right+emit.emitI2F(frame)+left2)
      else emit.printout(left1+right+left2)
      //println("Assign "+ast.leftHandSide.toString+" " +frame.getStackSize())
      ast
  }   
  /*override def visitBlock(ast: Block, o: Context)={
    val ctxt = o.asInstanceOf[SubBody]
    o
  }*/
 
}