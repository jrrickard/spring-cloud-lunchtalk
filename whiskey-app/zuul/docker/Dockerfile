FROM java:8
RUN mkdir /opt/vmware
COPY zuul-server-1.0.0.BUILD-SNAPSHOT.jar /opt/vmware/
WORKDIR /opt/vmware
EXPOSE 8765
ENTRYPOINT ["java","-jar","zuul-server-1.0.0.BUILD-SNAPSHOT.jar"]
