pull & inspect images:

```bash
docker images
docker image ls

docker pull docker.io/redis:latest
docker pull redis

docker inspect redis
docker history redis

docker image ls

```

A tool for exploring each layer in a docker image:
https://github.com/wagoodman/dive

tag images:

```bash
docker tag redis:latest redis:dev
docker image ls
```

how to build an image:

```bash
cd greeting-service
./mvnw clean package
ls -l target/greeting-service-0.0.1-SNAPSHOT.jar

docker build -t greeting-service:latest .

```
