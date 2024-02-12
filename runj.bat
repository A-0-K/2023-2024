::	Syntax: runj.bat <program_name>
::
::	example: runj billboard
::
::	For each input file "x.in", run the program and save the result to "x.out2".
::
::	To increase the stack size, use the option "-Xss". 
::	The default size is 256k.
::		java -Xss16384k -cp bin "%1"
::
::  Starting 2021, the input and output for USACO problems are standard IO.
::  This batch file has also adjusted.

@echo off
setlocal EnableDelayedExpansion

SET "Pattern=in"
SET "Replace=out2"

:: It is okay to have multiple lines of comments outside of a loop,
:: but not inside.

:: Run the program with input files in the sub-folder "\testData\x.in"
:: and then save the results as "\testData\x.out2".

for %%a in ("testData\*.in") do (
	echo %%a
	SET "File=%%~nxa"

	java -Xss50m "%1" < %%a > "testdata\!File:%Pattern%=%Replace%!"
	echo.
)

:: Need more work to add the feature to each input file
:: (display the execution time for each input file)
::	set start=%time%

::	set end=%time%
::	set start_ms=%start:*.=%
::	set end_ms=%end:*.=%
::	set ms=%end_ms%-%start_ms%
::	echo "1" : %start_ms% : %end_ms%
::	echo %%a : %start% : %end%

::	if %ms% lss 0 set ms = %ms% + 100
::	set /a totalms = %ms%*10
::	echo %totalms%

