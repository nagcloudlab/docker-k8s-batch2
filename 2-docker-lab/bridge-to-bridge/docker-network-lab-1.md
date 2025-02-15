````bash
docker build . -t nhttpd
docker network create frontend --subnet 10.0.1.0/24
docker network create backend --subnet 10.0.0.0/24


docker run --name s1 --network backend --cap-add=NET_ADMIN -d nhttpd
docker run --name s2 --network frontend --cap-add=NET_ADMIN -d nhttpd


```bash
docker run -d --name gw --network backend nhttpd
docker network connect frontend gw

docker inspect gw
docker exec -it gw bash
docker inspect s1
docker inspect s2
docker inspect gw

# add it on s2
docker exec -it s2 bash
ip route add 10.0.0.0/24 via 10.0.1.3
exit
docker exec -it s1 bash
# add it on s1
ip route add 10.0.1.0/24 via 10.0.0.3
````

```bash
docker inspect s1
docker exec -it s2 bash
```
