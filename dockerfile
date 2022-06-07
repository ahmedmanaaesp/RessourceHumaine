FROM java:8
EXPOSE 8091
ADD /target/Ressource-0.0.1-SNAPSHOT.jar project.jar
ENTRYPOINT ["java",".jar","project.jar"]