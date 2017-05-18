package bkool.utils


trait Utils {
	def lookup[T](name:String,lst:List[T],func:T=>String):Option[T] = lst match {
    	case List() => None
    	case head::tail => if (name == func(head)) Some(head) else lookup(name,tail,func)
  	}
	
	
}

/*case object IType extends PType
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
*/