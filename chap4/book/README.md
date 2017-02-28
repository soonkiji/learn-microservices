# book
* web, actuator
* h2, data-jpa, hal-browser
* swagger2
* /booking controller

# build and run
* mvn -DskipTests clean install
* java -jar target\book-0.0.1-SNAPSHOT.jar

# hal browser
* http://localhost:8060/
* http://localhost:8060/browser/index.html
* http://localhost:8060/inventories
* http://localhost:8060/inventories/search
* http://localhost:8060/inventories/search/findByFlightNumberAndFlightDate?flightNumber=BF101&flightDate=22-JAN-16
* http://localhost:8060/profile/inventories

# data jpa
* http://localhost:8060/bookingRecords/
* http://localhost:8060/bookingRecords/1

# actuator endpoints
* http://localhost:8060/env
* http://localhost:8060/autoconfig
* http://localhost:8060/metrics
* http://localhost:8060/health
* http://localhost:8060/info
* http://localhost:8060/mappings
* http://localhost:8060/beans
* http://localhost:8060/dump
* http://localhost:8060/trace

# book
* http://localhost:8060/booking/create
* http://localhost:8060/booking/get/{id}
* curl -s -X POST --header "Accept: */*" --header "Content-Type: application/json" -d "{\"flightNumber\":\"BF101\", \"flightDate\":\"22-JAN-16\",\"origin\":\"IFA\", \"destination\":\"IAD\", \"passengers\": [{\"firstName\":\"John\",\"lastName\":\"Doe\",\"gender\":\"M\"}]}" http://localhost:8060/booking/create
* curl http://localhost:8060/booking/get/2

# h2
* http://localhost:8060/h2-console