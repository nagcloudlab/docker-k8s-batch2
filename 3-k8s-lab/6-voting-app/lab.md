


```bash
kubectl apply -f voting-app-deployment-service.yaml
kubectl get all
```



kubectl port-forward with nodeport

```bash
kubectl get svc
kubectl port-forward svc/voting-app-service 8080:80
```




