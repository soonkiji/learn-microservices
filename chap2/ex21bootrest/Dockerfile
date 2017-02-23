FROM alpine:3.2
RUN apk --update add openjdk7-jre
ADD target/ex21bootrest-0.0.1-SNAPSHOT.jar ex21bootrest-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "ex21bootrest-0.0.1-SNAPSHOT.jar"]