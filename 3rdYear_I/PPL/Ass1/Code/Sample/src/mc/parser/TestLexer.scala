

/**
 * @author nhphung
 */
package mc.parser
import org.antlr.v4.runtime.Token
import java.io.{PrintWriter,File}
import org.antlr.v4.runtime.ANTLRFileStream


object TestLexer extends ProcessError {
  type MyLexer = MCLexer
  def main(args:Array[String]):Unit = {
      val file = if (args.length > 0) args(0) else "test.txt";
      val infile = new ANTLRFileStream(file)
      val out = if (args.length > 1) args(1) else "output.txt" 
      val outFile = new PrintWriter(new File(out));
      test(infile,outFile)
      outFile.close()
  }
  def test(infile:ANTLRFileStream,outfile:PrintWriter) = {
      val lexer = new MyLexer(infile);
      val _listener = createRecoverErrorListener(outfile);
      lexer.removeErrorListeners();
      lexer.addErrorListener(_listener);
      printAll(lexer,outfile)

  }
  def printAtt(lexer:MyLexer,dev:PrintWriter,prn:Token=>String):Unit = {
    
      val tok = lexer.nextToken()
      if (tok.getType() != Token.EOF) {
        dev.println(prn(tok))
        printAtt(lexer,dev,prn)
      } else dev.print("EOF")
    
    
  }
  
  
  def printLexeme(lexer:MyLexer,dev:PrintWriter) = printAtt(lexer,dev,_.getText())
  
  def printToken(lexer:MyLexer,dev:PrintWriter) = printAtt(lexer,dev,x => lexer.getRuleNames()(x.getType()-1))
  
  def printAll(lexer:MyLexer,dev:PrintWriter) = printAtt(lexer,dev,x => x.getText() +"\t"+ lexer.getRuleNames()(x.getType()-1))
  

}