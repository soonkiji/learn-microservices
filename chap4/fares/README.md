# fares
* web
* actuator
* data-jpa
* h2
* hal-browser

# build and run
* mvn clean install
* java -jar target\fares-0.0.1-SNAPSHOT.jar

# hal browser
* http://localhost:8080
* http://localhost:8080/browser/index.html#/
* http://localhost:8080/fares
* http://localhost:8080/fares/1
* http://localhost:8080/fares/search
* http://localhost:8080/fares/search/getFareByFlightNumberAndFlightDate?flightNumber=BF101&flightDate=22-JAN-16

# controller endpoint
* http://localhost:8080/fares/get?flightNumber=BF101&flightDate=22-JAN-16

# actuator endpoints
* http://localhost:8080/env
* http://localhost:8080/autoconfig
* http://localhost:8080/metrics
* http://localhost:8080/health
* http://localhost:8080/info
* http://localhost:8080/mappings
* http://localhost:8080/beans
* http://localhost:8080/dump
* http://localhost:8080/trace
