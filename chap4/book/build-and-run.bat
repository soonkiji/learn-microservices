@echo off
setlocal enabledelayedexpansion
call mvn -DskipTests clean package
start "book" java -jar target\book-0.0.1-SNAPSHOT.jar
mysleep 15
set "url=http://localhost:8060/inventories/search/findByFlightNumberAndFlightDate?flightNumber=BF101&flightDate=22-JAN-16"
echo start !url!
start !url!