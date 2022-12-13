FROM openjdk:8-jdk-alpine
MAINTAINER MauElian
VOLUME /tmp
EXPOSE 8080
ADD build/libs/library-0.0.1-SNAPSHOT.jar library.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/library.jar"]