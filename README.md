# jenkins-docker

Simple example of how to install Docker inside of Jenkins, mount the socket,
and use the entrypoint to give jenkins access to that socket with the docker
gid permissions.



## Jenkins and Kubernetes:
Start Minikube
```
minikube start
```
Make Image available in Minikube
```
eval $(minikube docker-env)

```

Build Image
```
docker build -t ilja07/jenkins-docker:1.0 .
```



Apply manifest
```
kubectl apply -f manifest.yml
```


Check Pods, Deployments, Services - everything from UI:
```
minikube dashboard
```


### Open Jenkins UI
1. find out IP of the cluster
```
minikube ip
```
2. Get port number of the service
```
kubectl get service
```

### Configure Jenkins Salves
In order to configure the Jenkins slaves. We need to know the URL of the Kubernetes master and the internal cluster URL of the Jenkins pod
```
kubectl cluster-info | grep master
```
https://192.168.64.4:8443

Pods IP
1. find out pod ID
```
kubectl get pods | grep jenkins 
```
2. get pod IP
```
kubectl describe pod <ID>
```
172.17.0.7

## Resources:
1. [How to Setup Scalable Jenkins on Top of a Kubernetes Cluster](https://www.blazemeter.com/blog/how-to-setup-scalable-jenkins-on-top-of-a-kubernetes-cluster/)
1. [Custom jenkins images with plugins pre-installed](https://dev.to/rubiin/custom-jenkins-images-with-plugins-pre-installed-1pok)
1. [Official Jenkins Docker image](https://github.com/jenkinsci/docker/blob/master/README.md)