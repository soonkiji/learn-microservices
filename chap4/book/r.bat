@echo off
setlocal enabledelayedexpansion
call setjava18.bat
set jarName=target\book-0.0.1-SNAPSHOT.jar
if not exist !jarName! (
	call b.bat
)
if exist !jarName! (
	start "book" java -jar !jarName!
)