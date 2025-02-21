

### copy the ca.crt and ca.key from the control plane node to the local machine

```bash
docker ps
docker cp my-cluster-control-plane:/etc/kubernetes/pki/ca.crt .
docker cp my-cluster-control-plane:/etc/kubernetes/pki/ca.key .

```

### generate user1 certificate

```bash
openssl genrsa -out user1.key 2048
openssl req -new -key user1.key -out user1.csr -subj "/CN=user1/O=dev-team"
openssl x509 -req -in user1.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out user1.crt -days 365
```


### configure kubectl with user1 certificate

```bash
kubectl config set-credentials user1 --client-certificate=user1.crt --client-key=user1.key
```

### configure kubectl with user1 context

```bash
kubectl config set-context user1-context --cluster=kind-my-cluster --user=user1
```

### switch to user1 context

```bash
kubectl config get-contexts
kubectl config use-context user1-context
kubectl config use-context kind-my-cluster
```


using http-client to access the k8s api server

```bash
curl --cacert ./ca.crt \
     --cert ./user1.crt \
     --key ./user1.key \
     https://172.18.0.5:6443/api/v1/pods
```


create 'developer' role for 'default' namespace

```bash
kubectl apply -f developer-role.yaml
kubectl get roles
kubectl apply -f developer-role-binding.yaml
```




