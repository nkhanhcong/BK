cd bkool
if [ ! -d ./bin ]; then 
	mkdir ./bin
fi
scalac -d ./bin -cp ./bin:/home/khanhcong/Downloads/Software/ANTLR4/antlr-4.5.3-complete.jar ./src/bkool/*.scala ../grammar/target/generated-sources/antlr4/*.java ./src/bkool/parser/*.scala 
cd ../grammar
javac -d ../bkool/bin -cp /home/khanhcong/Downloads/Software/Scala/lib/scala-library.jar:/home/khanhcong/Downloads/Software/ANTLR4/antlr-4.5.3-complete.jar:../bkool/bin:../bkool/bin/bkool/parser ./target/generated-sources/antlr4/*.java
cd ..