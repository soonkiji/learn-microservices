@echo off
setlocal enabledelayedexpansion
call mvn -DskipTests clean package
start "fares" java -jar target\fares-0.0.1-SNAPSHOT.jar
mysleep 15
set "url=http://localhost:8080/fares/search/getFareByFlightNumberAndFlightDate?flightNumber=BF101&flightDate=22-JAN-16"
echo start !url!
start !url!