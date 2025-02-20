




deploy nginx pods
```bash
kubectl apply -f nginx-pods.yaml
kubectl get pods -o wide

kubectl exec -it nginx-pod-1 -- curl 10.244.203.129

kubectl run curl-pod-new --image=curlimages/curl --restart=Never -it --rm -- sh

```


