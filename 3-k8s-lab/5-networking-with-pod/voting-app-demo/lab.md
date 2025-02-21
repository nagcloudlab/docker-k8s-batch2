





```bash
kubectl get all
kubectl apply -f https://kind.sigs.k8s.io/examples/ingress/deploy-ingress-nginx.yaml
kubectl apply -f app_v3.yaml
```


```bash
sudo /etc/hosts
<node-ip> vote.local
<node-ip> result.local
```

open browser

http://vote.local:<ingress-service-port>
http://result.local:<ingress-service-port>
