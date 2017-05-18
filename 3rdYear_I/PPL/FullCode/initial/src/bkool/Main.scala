/**
 * @author nhphung
 */
package bkool

import java.io.{PrintWriter,File}
import java.lang.RuntimeException
import java.util.concurrent.{Executors,TimeUnit,TimeoutException}
import org.antlr.v4.runtime.ANTLRFileStream
//import bkool.utils._
import bkool.parser._
import bkool.astgen._
import bkool.codegen._

trait Timed {
  def timeoutAfter(timeout: Long)(codeToTest: => Unit): Unit = {
    val executor = Executors.newSingleThreadExecutor
    val future = executor.submit(new Runnable {
      def run = codeToTest
    })

    try {
      future.get(timeout, TimeUnit.MILLISECONDS)
    }
    finally {
      executor.shutdown()
    }
  }
}

object Main extends  Timed {
  
  val sepa = "/" // dung cho linux
  val a4option = "testa4"
  val a4boption = "testa4b"
  val a2option = "testa2"
  

  def main(args: Array[String]): Unit = {
    if (args.length > 0) {
      val option = args(0).drop(1)
      
      val starta4 = 1
      val enda4 = 1
      val indira4 = "cgtestcases"
      val outdira4 = "cgsolutions"
      
      val indira4b = "cgasttestcases"
      val outdira4b = "cgastsolutions"

      val indira2 = "cgtestcases"
      val outdira2 = "cgasttestcases"
      
      option match {
        
        /*case "testphase1" => runTest(option,startphase1,endphase1,indirphase1,outdirphase1)
        case "testphase2" => {
            runTest("testphase1",startphase1,endphase1,indirphase1,outdirphase1)
            runTest(option,startphase2,endphase2,indirphase2,outdirphase2)
        }
        case "testphase3" => {
            //runTest("testphase1",startphase1,endphase1,indirphase1,outdirphase1)
            //runTest("testphase2",startphase2,endphase2,indirphase2,outdirphase2)
            runTest(option,startphase3,endphase3,indirphase3,outdirphase3)
        }
        case "testp1a3" => runTest("testp1a3",startp1a3,endp1a3,indira3,outdira3)
        case "testp2a3" => runTest("testp2a3",startp1a3,endp2a3,indira3,outdira3)
        case "testp3a3" => runTest("testp3a3",startp1a3,endp3a3,indira3,outdira3)*/
        case `a2option` => runTest(a2option,starta4,enda4,indira2,outdira2)
        case `a4option` => runTest(a4option,starta4,enda4,indira4,outdira4)
        case `a4boption` => runTest(a4boption,starta4,enda4,indira4b,outdira4b)
        
        case _ => throw new ClassCastException
      }
    }
    else  println("Usage: scala Main -option ")
  }
  
  def runTest(opt:String,start:Int,end:Int,indir:String,outdir:String) = {
    
    for (i <- start to end) {
      
      println("Test "+i)
      
      
      val source = new ANTLRFileStream(s"$indir$sepa$i.txt")
      val dest = new PrintWriter(new File(s"$outdir$sepa$i.txt"))
      
      try 
      {
        timeoutAfter(1000)  
        {
            opt match {
              /*case "testphase1" => TestLexer.test(source,dest) 
              case "testphase2" => TestParser.test(source,dest)              
              
              case ("testp1a3"|"testp2a3"|"testp3a3") => TestChecker.test(source,dest)*/
              case `a2option`  => TestAst.test(source,dest)
              case `a4option` => TestCodeGen.test(source,outdir,sepa,i,true)
              case `a4boption` => TestCodeGen.test(source,outdir,sepa,i,false)
              
              case _ => throw new ClassCastException
          }
        }
      } 
      catch 
      {
        case te: TimeoutException => dest.println("Test runs timeout")
        case re: RuntimeException => dest.println(re.getMessage())
        //case e : Exception => dest.println(e)
      } 
      finally 
      {
        //source.close()
        dest.close()

      }
    }
  } 
}