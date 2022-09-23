FROM openjdk:20-ea-11-jdk-slim
VOLUME /tmp
# 키 파일을 컨테이너의 루트 디렉토리에 복사
COPY apiEncryptionKey.jks apiEncryptionKey.jks
COPY target/config-service-1.0.jar ConfigService.jar

ENTRYPOINT ["java", "-jar", "ConfigService.jar"]