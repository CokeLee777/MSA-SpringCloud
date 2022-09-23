FROM openjdk:20-ea-11-jdk-slim
VOLUME /tmp
COPY target/apigateway-service-1.0.jar ApigatewayService.jar
# Java 프로젝트 실행
ENTRYPOINT ["java", "-jar", "ApigatewayService.jar"]