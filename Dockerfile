FROM amazoncorretto:17-alpine3.16

MAINTAINER francodavidbaretta

COPY target/backendportfolio-0.0.1-SNAPSHOT.jar backendportfolio-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/backendportfolio-0.0.1-SNAPSHOT.jar"]