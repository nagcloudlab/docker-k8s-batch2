



### Volume: EmptyDir

```bash
kubectl apply -f volume-emptydir.yaml
kubectl exec -it pod1 -c reader -- sh
cat /data/file.txt

kubectl delete pod pod1

```

### Volume: HostPath

```bash
kubectl apply -f volume-hostpath.yaml
kubectl exec -it hostpath-demo -- cat /mnt/logs/app.log

kubectl delete pod hostpath-demo
kubectl apply -f volume-hostpath.yaml

kubectl exec -it hostpath-demo -- cat /mnt/logs/app.log

kubectl delete pod hostpath-demo

```

### Persistent Volume and Persistent Volume Claim (PV and PVC)

```bash
kubectl apply -f pv.yaml
kubectl apply -f pvc.yaml
kubectl apply -f pvc-pod.yaml

kubectl exec -it pvc-pod -- cat /data/test.txt

kubectl delete pod pvc-pod
kubectl apply -f pvc-pod.yaml

kubectl exec -it pvc-pod -- cat /data/test.txt

kubectl delete pvc my-pvc
kubectl get pv

kubectl delete pv my-pv

```







