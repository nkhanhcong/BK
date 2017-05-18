SET DEST=cgsolutions\
cd ..\
for /l %%i in (1,1,1) do (
	java -jar .\tools\Jasmin\jasmin.jar -d %DEST%%%i %DEST%%%i\*.j
	java -cp %DEST%%%i;.\lib\;.\bin\;"D:\Software\Scala\Install\lib\scala-library.jar" TAPPLClass > %DEST%%%i.txt
)
cd .\script
