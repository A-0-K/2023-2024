::	Syntax: mcheck.bat
::
::	For each input file "x.in", check whether "x.out2" and "x.out" are the same.

@echo off
setlocal EnableDelayedExpansion

SET "Pattern=in"
SET "Replace1=out"
SET "Replace2=out2"

for %%a in ("testData\*.in") do (
REM	echo %%a

	SET "File=%%~nxa"

	java checkfiles "testData\!File:%Pattern%=%Replace1%!" "testData\!File:%Pattern%=%Replace2%!"

)

::	checkfiles "testData\!File:%Pattern%=%Replace1%!" "testData\!File:%Pattern%=%Replace2%!"

::	java -cp c:\users\team\JavaBin checkfiles "testData\!File:%Pattern%=%Replace1%!" "testData\!File:%Pattern%=%Replace2%!"

::	SET "file1 = testData\!File:%Pattern%=%Replace1%!"

::	SET "file2 = testData\!File:%Pattern%=%Replace2%!"

::	echo file1
	
::	echo file2

::	java checkfiles "testData\!File:%Pattern%=%Replace1%!" "testData\!File:%Pattern%=%Replace2%!"


