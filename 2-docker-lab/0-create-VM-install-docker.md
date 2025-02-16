create a resource group

```bash
az group create --name myResourceGroup --location centralindia
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

delete a resource group

```bash
az group delete --name myResourceGroup
```

open port 80 on the VM

```bash
az vm open-port --resource-group myResourceGroup --name myVM --port 80
```

get the public IP address of the VM

```bash
az vm list-ip-addresses --resource-group myResourceGroup --name myVM --output table
```

ssh into the VM

```bash
chmod 600 ~/.ssh/id_rsa
sudo ssh -i ~/.ssh/id_rsa azureuser@74.225.195.59
```

---

```bash
cat /etc/os-release
```

install zsh in ubuntu 24.04

```bash
sudo apt update
sudo apt install zsh -y
```

install oh-my-zsh

```bash
sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)" -y
```

### install docker

```bash
sudo apt update -y
sudo apt install apt-transport-https ca-certificates curl software-properties-common -y
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
apt-cache policy docker-ce
sudo apt install docker-ce -y
sudo systemctl status docker
sudo usermod -aG docker ${USER}
docker version
```

### install multipass on ubuntu

```bash
egrep -c '(vmx|svm)' /proc/cpuinfo
sudo snap install multipass
multipass version
multipass list
multipass launch -n my-instance -c 2 -d 5G
multipass shell my-instance
```
