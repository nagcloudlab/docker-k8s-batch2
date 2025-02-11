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


demo-1: build a spring boot app image

```bash
cd greeting-service

sudo apt-get update
sudo apt-get install openjdk-17-jdk openjdk-17-jre
java -version
./mvnw clean package
ls -l target/greeting-service-0.0.1-SNAPSHOT.jar

docker build -t greeting-service:latest .
docker image ls
docker inspect greeting-service

```

demo-2: build a angular app image
    
```bash

sudo apt install nodejs npm -y
node -v 
npm -v

sudo npm install -g @angular/cli
ng --version
ng new angular-app


cd angular-app
docker build -t angular-app:latest .
docker image ls
docker run -d -p 80:80 --name angular-app angular-app:latest
```
