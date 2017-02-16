# build and run
* mvnw clean install
* java -jar <artifact-jar>

# dev endpoint
* java -jar -Dspring.profiles.active=development target\bootadvanced-0.0.1-SNAPSHOT.jar
* http://localhost:9090

# prod endpoint
* java -jar -Dspring.profiles.active=development target\bootadvanced-0.0.1-SNAPSHOT.jar
* http://localhost:8080
