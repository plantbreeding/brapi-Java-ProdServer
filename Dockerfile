# build image : `docker build -t brapicoordinatorselby/brapi-java-server ./`
# run container (dev): `docker run --name=brapi-test-server --network=bridge -p 8081:8081 -d brapicoordinatorselby/brapi-java-server`
# run container (prod): `docker run --name=brapi-test-server --restart always --network=brapi_net -d brapicoordinatorselby/brapi-java-server`

FROM adoptopenjdk/openjdk8

EXPOSE 8080 8008

RUN mkdir /home/brapi

COPY target/brapi-Java-TestServer-0.1.0.jar src/main/resources/ /home/brapi/

CMD java -cp "/home/brapi/:/home/brapi/brapi-Java-TestServer-0.1.0.jar" org.springframework.boot.loader.JarLauncher