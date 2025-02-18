


Container-to-Container Communication (Inside a Pod)


kubectl apply -f multi-container-pod.yaml 
kubectl get pods
kubectl exec -it multi-container-pod -c sidecar -- /bin/sh
ip a


