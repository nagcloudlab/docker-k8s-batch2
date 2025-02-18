

### create a cluster with kind

```bash
kind delete cluster --name my-cluster
kind create cluster --config kind-cluster.yaml --name my-cluster
kind get clusters
```


### #Get all Nodes and their IP information, INTERNAL-IP is the real IP of the Node


```bash
kubectl get nodes -o wide
docker exec -it my-cluster-worker ls -l /etc/cni/net.d/
kubectl get pods -n kube-system -o wide
kubectl get daemonset -n kube-system
```




#Let's deploy a basic workload, hello-world with 3 replicas to create some pods on the pod network.
kubectl apply -f Deployment.yaml


#Get all Pods, we can see each Pod has a unique IP on the Pod Network.
#Our Pod Network was defined in the first course and we chose 192.168.0.0/16
kubectl get pods -o wide


#Let's hop inside a pod and check out it's networking, a single interface an IP on the Pod Network
#The line below will get a list of pods from the label query and return the name of the first pod in the list
PODNAME=$(kubectl get pods --selector=app=hello-world -o jsonpath='{ .items[0].metadata.name }')
echo $PODNAME
kubectl exec -it $PODNAME -- /bin/sh
ip addr
exit




### install calico network-plugin

```bash

kubectl get pods -n kube-system | grep -E "kindnet|flannel|calico|cilium|weave"
kubectl apply -f https://docs.projectcalico.org/manifests/calico.yaml
kubectl get daemonsets -n kube-system
kubectl delete daemonset kindnet -n kube-system
kubectl delete pod --all -n default

kubectl drain <node-name> --ignore-daemonsets
kubectl uncordon <node-name>

kubectl run nginx1 --image=nginx
kubectl run nginx2 --image=nginx

kubectl get pods -o wide

kubectl exec -it nginx1 -- curl 10.244.79.129
kubectl exec -it nginx2 -- curl 10.244.203.129

```






### deploy nginx and sleep pods

```bash
kubectl apply -f pod1.yaml
kubectl apply -f pod2.yaml
kubectl get pods -o wide
```

```bash    
docker exec -it my-cluster-worker2 bash
lsns -t pid
ip netns identify 1069
ip add
ip add | grep -A1 veth
lsns -t pid
for i in 1069 1143; do ip netns identify $i; done
ip netns exec cni-8b842c91-fbdf-4069-3f36-8b1c2916aa6e ip add
kubectl get pods -o wide
kubectl exec -it pod1 -c nginx -- curl -s localhost -vvv
kubectl exec -it pod2 -c nginx -- curl -s localhost -vvv
kubectl exec -it pod1 -c nginx -- curl -s 10.244.1.3 -vvv
```


----


cilium install --version 1.17.1
cilium status


---