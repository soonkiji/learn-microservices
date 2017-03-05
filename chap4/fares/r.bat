@echo off
setlocal enabledelayedexpansion
call setjava18.bat > NUL 2>&1
echo JAVA_HOME=!JAVA_HOME!
set jarName=target\fares-0.0.1-SNAPSHOT.jar
if not exist !jarName! (
	call b.bat
)
if exist !jarName! (
	start "1 fares 8080" java -jar !jarName!
) else (
	echo No !jarName!
)