

/**
 * @author nhphung
 */
package mc

import java.io.{PrintWriter,File}
import java.util.concurrent.{Executors,TimeUnit,TimeoutException}
import org.antlr.v4.runtime.ANTLRFileStream
import mc.parser._

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
  val lexer="testlexer"
  def main(args: Array[String]): Unit = {
    if (args.length == 5) {
    val start = java.lang.Integer.parseInt(args(1)) //testcase bat dau, o day la 1
    val end = java.lang.Integer.parseInt(args(2)) //testcase ket thuc, o day la 100
    val indir = args(3) //thu muc chua testcase, o day la $TEST
    val outdir = args(4)  //thu muc chua file ket qua khi chay cho moi sinh vien, o day la $DEST
    //o phase 2 chi chay parser chu khong thuc hien viec check nen co the bo argument nay
    //val opt = args(4) //tuy chon che do chay
    val option = args(0).drop(1)
    val sepa = "//" // dung cho linux
      //chay tat ca testcase mot luc
    for (i <- start to end) {
      //khong in ra phan nay
      println("Test "+i)
      //file input tuong ung voi 1 testcase
      //val inputFile = indir+"\\"+i+".txt"
      
      val (source,dest) = option match {
        
        case `lexer` =>  (new ANTLRFileStream(s"$indir$sepa$i.txt"),new PrintWriter(new File(s"$outdir$sepa$i.txt"))) //dung trong linux
        case _ => throw new ClassCastException
      }
      
      
      try 
      {
        timeoutAfter(1000)  //thoi gian chay la 0.5s
        {
            option match {
              
           
              case `lexer` => TestLexer.test(source,dest)
               
              case _ => throw new ClassCastException
          }
        }
      } 
      catch 
      {
        case te: TimeoutException => dest.println("Test runs timeout")
        //case e : Exception => dest.println(e)
      } 
      finally 
      {
        //source.close()
        dest.close()

      }
      if(i == end) {
        System.exit(1)    
      }
    }
  } else  println("Usage: scala Main -option <start> <end> <in directory>  <out directory>")
  }
}