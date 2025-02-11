
delete all containers:

```bash
docker ps -a
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker ps -a
```

delete all images:

```bash
docker image ls
docker image rm $(docker image ls -q)
docker image ls
```

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

pull an image using a specific tag:

```bash
docker pull redis:6.0.9
docker image ls
```

pull an image using a specific digest:

```bash
docker pull redis@sha256:
docker image ls
```


tag an image:

```bash
docker tag redis:latest redis:dev
docker image ls
```


A tool for exploring each layer in a docker image:
https://github.com/wagoodman/dive


demo-1: build a spring-boot-app image

```bash
cd greeting-service
docker build -t greeting-service:latest .
docker image ls
docker inspect greeting-service
```

demo-2: build a angular app image
    
```bash
cd angular-app
docker build -t angular-app:latest .
docker image ls
docker run -d -p 80:80 --name angular-app angular-app:latest
```

build an image for multi-architecture:

```bash
docker buildx build --platform linux/amd64,linux/arm64 -t greeting-service:multiarch .
docker image ls
docker inspect greeting-service:multiarch
```

pull an imgae with a specific architecture:

```bash
docker pull --platform linux/arm64 redis
docker image ls
```


scan images for vulnerabilities:

```bash
docker scan angular-app:latest
docker scan greeting-service:latest
```

setup a private registry:

```bash
docker run -d -p 5000:5000 --name registry registry:2
docker ps
```

tag an image and push it to the private registry:

```bash
docker tag greeting-service:latest localhost:5000/greeting-service:latest
docker image ls
docker push localhost:5000/greeting-service:latest
```

pull an image from the private registry:

```bash
docker pull localhost:5000/greeting-service:latest
docker image ls
```

