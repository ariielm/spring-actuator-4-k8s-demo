FROM openjdk:15-jdk-alpine

COPY target/spring-actuator-4-k8s-demo-*.jar spring-actuator-4-k8s-demo.jar

ENTRYPOINT exec java -jar spring-actuator-4-k8s-demo.jar