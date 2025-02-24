
```bash
helm create voting-app

helm package .

helm install voting-app ./voting-app
helm list
helm upgrade voting-app ./voting-app

kubectl port-forward svc/vote 8080:80 &
kubectl port-forward svc/result 8081:80 &

helm uninstall voting-app

```