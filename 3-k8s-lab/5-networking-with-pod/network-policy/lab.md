




```bash
kubectl apply -f nginx.yaml
```

```bash
kubectl run curl-pod-new --image=alpine --restart=Never -- sh -c "sleep 3600"
kubectl exec -it curl-pod-new -- apk update
kubectl exec -it curl-pod-new -- apk add curl
```