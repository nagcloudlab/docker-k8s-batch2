
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
docker pull redis@sha256:48c1431bed43fb2645314e4a22d6ca03cf36c5541d034de6a4f3330e7174915b
docker image ls
```


pull un-official images:

```bash
docker pull docker.io/nagabhushanamn/greeting-service:v1
docker image ls
```


tag an image:

```bash
docker tag nagabhushanamn/greeting-service:v1 nagabhushanamn/greeting-service:training
docker image ls
```


A tool for exploring each layer in a docker image:
https://github.com/wagoodman/dive

```bash
DIVE_VERSION=$(curl -sL "https://api.github.com/repos/wagoodman/dive/releases/latest" | grep '"tag_name":' | sed -E 's/.*"v([^"]+)".*/\1/')
curl -OL https://github.com/wagoodman/dive/releases/download/v${DIVE_VERSION}/dive_${DIVE_VERSION}_linux_amd64.deb
sudo apt install ./dive_${DIVE_VERSION}_linux_amd64.deb
```

```bash
dive nagabhushanamn/greeting-service:v1
```


Demo-1: build a spring-boot-app image

```bash
cd services/greeting-service
docker build -t greeting-service:latest .
docker image ls
docker inspect greeting-service
```


Demo-3: build a python-app image

```bash
cd cd services/python-web-service
docker build -t python-app:latest .
docker image ls
docker run -d -p 8080:8080 --name python-app python-app:latest
curl http://localhost:8080
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

