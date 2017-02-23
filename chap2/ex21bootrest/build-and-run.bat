call mvn -DskipTests clean package
docker build -t ex21bootrest:0.0.1 .
docker run -d -p 8080:8080 ex21bootrest:0.0.1
mysleep 10
start http://192.168.99.100:8080