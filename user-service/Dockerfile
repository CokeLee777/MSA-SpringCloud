FROM openjdk:20-ea-11-jdk-slim
# 가상의 tmp라는 디렉토리를 생성한다.
VOLUME /tmp
# user-service-0.0.1-SNAPSHOT.jar 파일을 Userservice.jar로 복사하여 만든다.
COPY target/user-service-1.0.jar Userservice.jar
# Java 프로젝트 실행
ENTRYPOINT ["java", "-jar", "Userservice.jar"]