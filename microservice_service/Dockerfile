FROM hub.c.163.com/library/java:latest
VOLUME /tmp
EXPOSE 6666
ADD target/microservice_service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]