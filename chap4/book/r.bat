@echo off
setlocal enabledelayedexpansion
call setjava18.bat > NUL 2>&1
echo JAVA_HOME=!JAVA_HOME!
set jarName=target\book-0.0.1-SNAPSHOT.jar
if not exist !jarName! (
	call b.bat
)
if exist !jarName! (
	start "3 book 8060" java -jar !jarName!
)