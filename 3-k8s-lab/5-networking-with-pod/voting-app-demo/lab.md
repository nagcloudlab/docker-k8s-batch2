


```bash
kubectl get all
kubectl delete -f https://kind.sigs.k8s.io/examples/ingress/deploy-ingress-nginx.yaml
kubectl delete -f app_v3.yaml
```


```bash
sudo /etc/hosts

<node-ip> vote.local
<node-ip> result.local

kubectl get all -n ingress-nginx
curl http://vote.local:<ingress-nginx-service-port>
curl http://result.local:<ingress-nginx-service-port>

```
