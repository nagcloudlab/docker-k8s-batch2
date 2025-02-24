### install kubectl

```bash
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
chmod +x kubectl
sudo mv kubectl /usr/local/bin/kubectl
kubectl version --client
```

### install kind

```bash
curl -Lo ./kind https://kind.sigs.k8s.io/dl/latest/kind-linux-amd64
chmod +x ./kind
sudo mv ./kind /usr/local/bin/kind
kind version
```

### create k8s cluster

```bash
kind create cluster --config kind-cluster.yaml --name my-cluster
```

### verify the cluster

```bash
kubectl cluster-info --context kind-my-cluster
kubectl get nodes -o wide
```

### delete the cluster

```bash
kind delete cluster --name my-cluster
```

## Azure Aks cluster

```bash
az group delete -n aks-k8s-rg -y
az group create --name aks-k8s-rg --location centralindia
az aks create \
 --resource-group aks-k8s-rg \
 --name aks-k8s \
 --generate-ssh-keys \
 --node-count 3 \
 --zones 1 2 3
kubectl get nodes -o wide
kubectl get nodes --show-labels
```

### Ingress-nginx setup on Aks

```bash
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update

helm install ingress-nginx ingress-nginx/ingress-nginx \
 --create-namespace \
 --namespace ingress \
 --set controller.service.annotations."service\.beta\.kubernetes\.io/azure-load-balancer-health-probe-request-path"=/healthz

kubectl get services --namespace ingress -o wide ingress-nginx-controller
```

### SSL Passthrough

```bash
kubectl get deployments --all-namespaces | grep ingress-nginx
kubectl edit deployment ingress-nginx-controller -n ingress
```

```yaml
spec:
  template:
    spec:
      containers:
        - args:
            - /nginx-ingress-controller
            - --publish-service=$(POD_NAMESPACE)/ingress-nginx-controller
            - --election-id=ingress-controller-leader
            - --ingress-class=nginx
            - --configmap=$(POD_NAMESPACE)/ingress-nginx-controller
            - --validating-webhook=:8443
            - --validating-webhook-certificate=/usr/local/certificates/cert
            - --validating-webhook-key=/usr/local/certificates/key
            - --default-ssl-certificate=$(POD_NAMESPACE)/tls-secret
            - --enable-ssl-passthrough
            - --v=2
          image: k8s.gcr.io/ingress-nginx/controller:v1.0.0
```

```bash
kubectl rollout status deployment ingress-nginx-controller -n ingress
kubectl describe deployment ingress-nginx-controller -n ingress
kubectl get pods -n ingress
```
