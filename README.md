# 

## Model
www.msaez.io/#/98381715/storming/165f4bd23cbb8ce9518795f21d28d4c0

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- member
- author
- book
- bookworkflow


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- member
```
 http :8088/users id="id"name="name"password="password"phoneNumber="phoneNumber"subscriptionStartAt="subscriptionStartAt"subscriptionEndAt="subscriptionEndAt"pointBalance="pointBalance"createdAt="createdAt"updatedAt="updatedAt"isKtVerified="isKtVerified"
```
- author
```
 http :8088/authors id="id"name="name"description="description"createdAt="createdAt"updatedAt="updatedAt"
```
- book
```
 http :8088/books id="id"title="title"content="content"viewCount="viewCount"createdAt="createdAt"updatedAt="updatedAt"isBookPublished="isBookPublished"price="price"summary="summary"bookReleaseAdminId="bookReleaseAdminId"authorId="authorId"isBestseller="isBestseller"
```
- bookworkflow
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
