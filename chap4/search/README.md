# search
* mvc
* actuator
* swagger
* /search/get

# build and run
* mvn -DskipTests clean install
* java -jar target\search-0.0.1-SNAPSHOT.jar

# controller endpoint
* http://localhost:8090/search/get
* curl -X POST http://localhost:8090/search/get --header "Content-Type: application/json" -d "{\"destination\": \"SFO\",\"flightDate\":\"22-JAN-16\",\"origin\":\"NYC\"}"

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
