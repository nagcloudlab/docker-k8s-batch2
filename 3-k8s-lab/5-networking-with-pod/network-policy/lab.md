




```bash
kubectl apply -f nginx.yaml
```

```bash
kubectl run curl --image=alpine --restart=Never -- sh -c "sleep 3600"
kubectl exec -it curl -- apk update
kubectl exec -it curl -- apk add curl
```

```bash
kubectl exec -it curl -- curl nginx:80
```

Default Deny Policy (Block All Traffic)
```bash
kubectl apply -f default-deny.yaml
kubectl delete -f default-deny.yaml
```


Allow Ingress from Curl-Pod to Nginx
```bash
kubectl apply -f allow-curl-to-nginx.yaml
kubectl delete -f allow-curl-to-nginx.yaml
```

 Allow Egress from Curl-Pod to Nginx
```bash
kubectl apply -f allow-curl-egress.yaml
kubectl delete -f allow-curl-egress.yaml
```
