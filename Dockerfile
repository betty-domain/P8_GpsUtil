FROM openjdk:8-jdk-alpine
COPY build/libs/*.jar gpsUtil.jar
ENTRYPOINT ["java","-jar","/gpsUtil.jar"]