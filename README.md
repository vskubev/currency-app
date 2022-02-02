###Start application locally

0. Create cluster:\
_$ minikube start_


3. Run deployments and services:\
_$ kubectl create -f {#path}/currency-app-service.yaml\
$ kubectl create -f {#path}/currency-app-deployment.yaml\
$ kubectl create -f {#path}/redis-cache-service.yaml\
$ kubectl create -f {#path}/redis-cache-deployment.yaml_


4. Run tunnel in a separate terminal:\
_$ minikube tunnel_


5. Get application ip and port:\
_$ kubectl get service_\
and get external-ip and external port