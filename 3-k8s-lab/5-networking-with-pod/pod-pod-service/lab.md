




pod-to-pod communication
```bash
kubectl apply -f nginx.yaml
kubectl get pods -o wide
kubectl exec -it nginx-pod-1 -- curl 10.244.203.129
```

pod-to-service communication
```bash
kubectl apply -f nginx-service.yaml
kubectl get svc
kubectl run curl-pod-new --image=curlimages/curl --restart=Never -it --rm -- sh
```


