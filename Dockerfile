FROM openjdk:8
EXPOSE 8080
ADD /target/kaluza-gatling-1.0-SNAPSHOT.jar kaluza-gatling.jar
ENTRYPOINT ["java","-jar","kaluza-gatling.jar"]
