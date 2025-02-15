create a resource group

```bash
az group create --name myResourceGroup --location centralindia
```

delete a resource group

```bash
az group delete --name myResourceGroup
```

create a ubuntu virtual machine

```bash
az vm create \
  --resource-group myResourceGroup \
  --name myVM \
  --image Ubuntu2404 \
  --size Standard_D4s_v3 \
  --admin-username azureuser \
  --ssh-key-values ~/.ssh/id_rsa.pub \
  --public-ip-sku Standard
```

delete the virtual machine

```bash
az vm delete --resource-group myResourceGroup --name myVM
```

open port 80 to allow web traffic to host

```bash
az vm open-port --port 22 --resource-group myResourceGroup --name myVM --priority 1001
az vm open-port --port 8080 --resource-group myResourceGroup --name myVM --priority 1002
```

get the public IP address of the VM

```bash
az vm list-ip-addresses --resource-group myResourceGroup --name myVM --output table
```

ssh into the VM

```bash
chmod 600 ~/.ssh/id_rsa
sudo ssh -i ~/.ssh/id_rsa azureuser@4.213.140.237
```

---

```bash
cat /etc/os-release
```

install zsh in ubuntu 24.04

```bash
sudo apt update
sudo apt install zsh
```

install oh-my-zsh

```bash
sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```
