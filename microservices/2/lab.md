


```bash
for f in kubernetes/helm/components/*; do helm dep up $f; done
for f in kubernetes/helm/environments/*; do helm dep up $f; done
helm dep ls kubernetes/helm/environments/dev-env/
```

```bash
helm template kubernetes/helm/environments/dev-env
helm install --dry-run --debug hands-on-dev-env kubernetes/helm/environments/dev-env

helm install microservices-dev-env \
  kubernetes/helm/environments/dev-env \
  -n microservices \
  --create-namespace

PORT=30443 USE_K8S=true ./test-em-all.bash

helm upgrade microservices-dev-env \
  kubernetes/helm/environments/dev-env \
  -n microservices
```

```bash
helm uninstall microservices-dev-env -n microservices
```