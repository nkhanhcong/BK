cd bkool
IF NOT EXIST .\bin (mkdir .\bin)
scalac -d .\bin -classpath .\bin;D:\Software\ANTLR\antlr-4.5.3-complete.jar .\src\bkool\*.scala ..\grammar\target\generated-sources\antlr4\*.java .\src\bkool\parser\*.scala
cd ..
