# Email Microservice

---
This microservice send an email using the [AWS SES](https://aws.amazon.com/pt/ses/).
Technologies used: Java 17, Java Spring, AWS.

- [Installation](#installation)
- [Configuration](#configuration)
- [Execute](#execute)
- [Docker](#docker)
- [Documentation](#documentation)
---
## Installation

1. Clone the repository:

```bash
git clone https://github.com/felipebabel/email-microservice.git
```

2. Install dependencies with Maven
```bash
mvn clean install
```
---
## Configuration

1. It's necessary to install the Lombok Plugin in settings.

![img.png](assets/img1.png)

2. It's necessary to add your AWS credentials in the environment variables.

![img_2.png](assets/img2.png)

3. Java 17 must be installed and configured on your machine

---
## Execute
To run the microservice, you can either use the following Maven command
```task
mvn spring-boot:run
```
Or run the main class directly from your IDE:
[EmailMicroserviceApplication.java](src/main/java/com/emailmicroservice/EmailMicroserviceApplication.java)

The API will be accessible at http://localhost:8080

Postman request example:

![img_1.png](assets/img3.png)

---
## Docker
The microservice can also be containerized and run using Docker.

Command to run the Docker container:
```bash
docker-compose up --build 
```
In the file [docker-compose.yml](docker-compose.yml), update the environment variables with your AWS credentials.
Example section:

![img_1.png](assets/img4.png)
---
## Documentation

Interactive API documentation is available via Swagger UI.
Access it here:
[Swagger UI](http://localhost:8080/swagger-ui/index.html#/)