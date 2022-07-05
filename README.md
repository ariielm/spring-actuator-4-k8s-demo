# spring-actuator-4-k8s-demo
Spring actuator demo for usage with K8s

## Demo Goal

Show the Spring actuator configurations and its integration with Kubernetes probes.

## Build

To build the application and the Docker image execute:

```
./mvnw clean package
```

## Run only the application

The application runs in a Docker container. To run it, just execute:

```
./mvnw clean install
```

## Deploying on Kubernetes

After [building the image](#build), execute:

```
docker build -t spring-actuator-4-k8s-demo .
kubectl apply -f k8s/deployment.yaml 
```

#### Fixing minikube errors:

* If errors pulling the Docker image occurs (_ErrImagePull_ or _ImagePullBackOff_), then execute the commands so the kubectl can download Docker images from minikube:
```
minikube docker-env
eval $(minikube -p minikube docker-env)
```

* If your load balancer service cannot locate an _EXTERNAL-IP_, keeping the status _<pending_>, then run:
```
minikube tunnel
```

## Usage

With the application running, access the actuator endpoint on `http://localhost:8080/actuator` to check all the actuators available.

The main objective with this application is to show the Kubernetes probes working with the Spring actuators.

To do so, check the two endpoints available for Kubernetes probes: `/actuator/health/liveness` and `/actuator/health/readiness`

The readiness endpoint has two custom health indicators which you can interact with.

* `customLiveness` - [Custom Liveness Health Indicator](src/main/java/com/ariielm/springactuator4k8sdemo/healthindicator/customliveness/CustomLivenessHealthIndicator.java)
* `customReadiness` - [Custom Readiness Health Indicator](src/main/java/com/ariielm/springactuator4k8sdemo/healthindicator/customreadiness/CustomReadinessHealthIndicator.java)

There are four endpoints on the application that makes the `customLiveness` and `customReadiness` Health Indicator switch to `UP` or `DOWN`.

* `/liveness/healthy` - makes the Custom Liveness Health Indicator switch to `UP`;
* `/liveness/unhealthy` - makes the Custom Liveness Health Indicator switch to `DOWN`, and it returns to `UP` after 20 seconds;
* `/readiness/healthy` - makes the Custom Readiness Health Indicator switch to `UP`;
* `/readiness/unhealthy` - makes the Custom Readiness Health Indicator switch to `DOWN`, and it returns to `UP` after 20 seconds.

Interacting with these four endpoints you'll be able to check the k8s probes acting like:

* `/liveness/unhealthy` - the pod will restart the container;
* `/readiness/unhealthy` - the pod will be removed from the load balancer, and after some seconds, return to the load balancer;.
