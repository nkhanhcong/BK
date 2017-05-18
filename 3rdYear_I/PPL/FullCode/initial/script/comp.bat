cd ..
IF NOT EXIST bin mkdir .\bin
scalac -d .\bin -cp .\bin;D:\Software\ANTLR\antlr-4.5.3-complete.jar -unchecked  .\src\bkool\*.scala .\src\grammar\target\generated-sources\antlr4\*.java .\src\bkool\parser\*.scala .\src\bkool\utils\*.scala .\src\bkool\astgen\*.scala .\src\bkool\checker\*.scala .\src\bkool\codegen\*.scala && cd .\script