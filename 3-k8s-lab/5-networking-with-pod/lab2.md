



```bash
kubectl run curl-pod --image=curlimages/curl --restart=Never -it --rm -- sh
kubectl run curl2 --image=curlimages/curl --restart=Never -it --rm -- sh
```


```bash
kubectl apply -f pod.yaml
```