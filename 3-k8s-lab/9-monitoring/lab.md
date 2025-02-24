

```bash
kubectl create namespace monitoring
kubectl apply -f prometheus-clusterrole.yaml
kubectl apply -f prometheus-clusterrolebinding.yaml

kubectl apply -f prometheus-cm.yaml
kubectl apply -f prometheus-deploy.yaml
kubectl apply -f grafana-deploy.yaml
kubectl apply -f nginx-cm.yaml
kubectl apply -f nginx-deploy.yaml
kubectl apply -f nginx-service.yaml

kubectl port-forward svc/prometheus-service 9090:9090 -n monitoring
kubectl port-forward svc/grafana 3000:3000 -n monitoring
kubectl port-forward svc/nginx-service 8080:80
```

