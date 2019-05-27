FROM openjdk:11-jdk-stretch

ADD /target/userservice-0.0.1-SNAPSHOT.jar /src/app/music/userservice-0.0.1-SNAPSHOT.jar

WORKDIR /src/app/music

ENTRYPOINT ["java","-jar","userservice-0.0.1-SNAPSHOT.jar"]
