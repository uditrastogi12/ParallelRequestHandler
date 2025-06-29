# Billing Microservice and eSign Microservice

## Overview

This repository contains two microservices:

- billingms: Handles client quota validation.
- esignms: Uses the billing service to validate and consume client quota for API requests.

## Running Locally

1️⃣ Billing Microservice

- Port: 8081
- Start using your IDE or:

  cd billingms
  mvn spring-boot:run

2️⃣ eSign Microservice

- Port: 8080
- Start using your IDE or:

 cd esignms
 mvn spring-boot:run


DB SETUP :
 http://localhost:8081/h2-console

 INSERT INTO client_quotas (client_id, balance, version) VALUES ('client123', 100, 0);



Note :
Uses optimistic locking (@Version) to handle concurrency.
H2 in-memory DB configured by default.



Testing :
Used Postman to send parallel requests to:


a) Create Collection

In Postman, create new Collection: Test Parallel Billing.

Add a request:

Method: POST

URL: http://localhost:8081/billing/validate-consume?clientId=client123

Save request to collection.

b) Run Collection with 100 Iterations

Click Collection → click Run.

Set Iterations to 100.

Click Run.

Postman will fire 100 parallel requests.



ScreenShots:

As you can see that till 80 parallel request, I am getting message as "Allowed" . After 80th request, all request send message as Rejected.

![image](https://github.com/user-attachments/assets/51a5b540-8d99-49f5-96f7-d0b476349bae)


![image](https://github.com/user-attachments/assets/8a84552e-2544-416c-ba6c-b0a72ea55b4f)











