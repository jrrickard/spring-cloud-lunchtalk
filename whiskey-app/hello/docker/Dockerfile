FROM java:8
RUN mkdir /opt/vmware
COPY hello1-1.0.0-SNAPSHOT.jar /opt/vmware/
WORKDIR /opt/vmware
ENTRYPOINT ["java","-jar","hello1-1.0.0-SNAPSHOT.jar"]
