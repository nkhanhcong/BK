cd bkool
IF NOT EXIST .\bin (mkdir .\bin)
scalac -d .\bin -classpath .\bin;C:\scala\lib\antlr-4.5.3-complete.jar .\src\bkool\*.scala ..\bkool\grammar\generated-sources\antlr4\*.java .\src\bkool\parser\*.scala
cd ..
