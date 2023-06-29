FROM eclipse-temurin:8-jdk-focal
ENV TZ=Europe/Madrid
ADD target/test-memoria-1.0.jar test-memoria-1.0.jar
ENTRYPOINT ["java", "-jar", "test-memoria-1.0.jar"]