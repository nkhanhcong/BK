cd ..\src\grammar
javac -d ..\..\bin -cp "D:\Software\Scala\Install\lib\scala-library.jar";D:\Software\ANTLR\antlr-4.5.3-complete.jar;..\..\bin:..\..\bin\bkool\parser -Xlint:deprecation .\target\generated-sources\antlr4\*.java 
cd ..\..\script