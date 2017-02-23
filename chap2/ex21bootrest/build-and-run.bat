call mvn -DskipTests clean package
docker build -t ex21bootrest:0.0.1 .
echo docker run -it --rm --name ex21bootrest -p 8080:8080 ex21bootrest:0.0.1
start docker run -it --rm --name ex21bootrest -p 8080:8080 ex21bootrest:0.0.1
mysleep 20
echo start http://%DOCKER_MACHINE_NAME%:8080
start http://%DOCKER_MACHINE_NAME%:8080