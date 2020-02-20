FROM registry.redhat.io/redhat-openjdk-18/openjdk18-openshift
COPY src/main/resources/keystore.jks /opt/jboss/
ARG JAR_FILE=target/kafka-producer-ocp-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} kafka-producer-ocp.jar
ENTRYPOINT ["java","-jar","kafka-producer-ocp.jar"]
