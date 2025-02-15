


### 1️⃣ Default Scheduling (Kube-Scheduler)

```bash
kubectl apply -f default-scheduled-pod.yaml
kubectl get pods -o wide
kubectl describe pod default-scheduled-pod
kubectl delete pod default-scheduled-pod
```

### 2️⃣ Node Selector

```bash
kubectl get nodes --show-labels
kubectl label nodes my-cluster-worker2 disktype=ssd
kubectl apply -f node-selector-pod.yaml
kubectl get pods -o wide
kubectl describe pod node-selector-pod
kubectl delete -f node-selector-pod.yaml
kubectl label nodes my-cluster-worker2 disktype-
```


### 3️⃣ Node Affinity

```bash
kubectl get nodes --show-labels
kubectl get nodes -l disktype
kubectl get nodes -L disktype
kubectl label nodes my-cluster-worker2 disktype=ssd
kubectl apply -f node-affinity-pod.yaml
kubectl get pods -o wide
kubectl describe pod node-affinity-pod
kubectl delete -f node-affinity-pod.yaml
```

### 4️⃣ Pod Affinity & Anti-Affinity


```bash
kubectl apply -f pod-affinity-pod.yaml
kubectl get pods -o wide
kubectl describe pod pod-affinity-pod
kubectl delete -f pod-affinity-pod.yaml
```

### 5️⃣ Taints & Tolerations

```bash
kubectl describe node my-cluster-worker2
kubectl taint nodes my-cluster-worker2 ssd=true:NoSchedule
kubectl apply -f taint-toleration-pod.yaml
kubectl get pods -o wide
kubectl describe pod taint-toleration-pod
kubectl delete -f taint-toleration-pod.yaml
```


### 6️⃣ Resource Requests & Limits

```bash
kubectl apply -f resource-limits.yaml
kubectl get pods -o wide
kubectl top pods
kubectl describe pod resource-limits
kubectl delete -f resource-limits.yaml
```


### 7️⃣ Priority Classes

```bash
kubectl apply -f priority-class.yaml
kubectl apply -f priority-pod.yaml
kubectl get pods -o wide
kubectl describe pod priority-pod
kubectl delete -f priority-pod.yaml
kubectl delete -f priority-class.yaml
```

### 8️⃣ Manual Scheduling (Node Name)

```bash
kubectl apply -f manual-scheduled-pod.yaml
kubectl get pods -o wide
kubectl describe pod manual-scheduled-pod
kubectl delete -f manual-scheduled-pod.yaml
```

### remove all the labels and taints

```bash
kubectl label nodes my-cluster-worker3 disktype-
kubectl taint nodes my-cluster-worker3 ssd-
```