# Intro

This repository contains a number of components that could represent a whiskey purchasing system  using Spring Cloud and the Netflix OSS components. These are wrapped as Spring Boot applications for ease of deployment. Additionally, a Dockerfile is provided for each. 

For each service, build the jar with :

```
mvn clean install
```

After the jar is built, copy it into the docker folder (from the target directory, ie for zuul, it would be zuul/target). The docker file assumes that the jar is in the same directory as the Dockerfile. 

If you'd like to build your own to run with Rocket or something, follow the examples. The major things the services expect are config via environment variables outlined below.

 

## Service Discovery

## Building the container

From the service-discovery directory:

```
docker build -t cmp/eureka .
```

## Running the container

The other images require a link to the eureka server, so to use the commands below name it eureka. 

You also want to port bind it so it can be accessed externally. If you're using something like kubernetes, make it a service so it's available externally and linkable to other containers. 

```
docker run -d -p 8761:8761 --name eureka cmp/eureka
```

## Zuul

Building this one currently requires skipping tests:

```
mvn clean install -DskipTests=trye
```

### Building the container

From the zuul directory:

```
docker build -t cmp/zuul .
```

### Running the container

This container requires the eureka service to be linked as below to set the environment variables correctly.

You also want to port bind this (or the equivalent) so that you can access it externally. 

```
docker run -d -p 8765:8765 -e "DOCKER_HOST=10.25.49.26" --name zuul --link eureka:eureka_service cmp/zuul
```

## Hystrix

### Building the container

From the hystrix-dashboard directory:

```
docker build -t cmp/hystrix .
```

### Running the container

This container requires the eureka service to be linked as below to set the environment variables correctly.

```
docker run -d -p 8081:8081 --link eureka:eureka_service cmp/hystrix
```

## Hello World Service

### Building the container

From the hello directory:

```
docker build -t cmp/hello .
```

### Running the container

This container requires the eureka service to be linked as below to set the environment variables correctly. Additionally, it currently expects an environment variable specifying what port to run on. This enables multiple instances to run on a single host without any networking overlay. 

```
docker run -d -e "PORT=9005" -e "DOCKER_HOST=10.25.49.26" --expose 9005 --link eureka:eureka_service cmp/hello
```

## Running things

Once all of the containers are running, you should be able to access them externally to the docker host (assuming you exposed ports like above).

For example, assuming the host is 10.25.49.26 as indicated above:

Eureka will be accessible at : http://10.25.49.26:8761

Zuul will be available at : http://10.25.49.26:8765

Hystrix will be available at http://10.25.49.26:8081/hystrix

The hello service will not be available because the port is not exposed! To access the hello service, you would access it via zuul:

http://10.25.49.26:8765/hello/hello

This should round robin between the hello instances (assuming you spun more than one up)


To use hystrix against the Zuul stream, use http://10.25.49.26:8765/hystrix.stream


