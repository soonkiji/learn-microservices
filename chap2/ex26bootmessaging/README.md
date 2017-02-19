# content
* mvc
* actuator
* rabbitmq

# rabbitmq docker
* docker run -d --name rabbitmq --restart=always -p 5672:5672 -e RABBITMQ_DEFAULT_USER=guest -e RABBITMQ_DEFAULT_PASS=guest rabbitmq

# build and run
* mvnw clean install
* java -jar [artifact.jar]

# controller endpoint
* http://localhost:8080/

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
