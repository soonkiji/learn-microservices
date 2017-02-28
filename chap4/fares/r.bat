@echo off
setlocal enabledelayedexpansion
call setjava18.bat
set jarName=target\fares-0.0.1-SNAPSHOT.jar (
if not exist !jarName! (
	call b.bat
)
if exist !jarName! (
	start "fares" java -jar !jarName!
)