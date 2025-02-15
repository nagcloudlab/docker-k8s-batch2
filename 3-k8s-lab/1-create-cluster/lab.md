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


