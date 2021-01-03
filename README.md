### Business Requirement Specification

To develop a website to manage Oompa Loompa's crew of Willy Wonka's chocolate factory. Code a server that provides a tool to manage all Oompa Loompas.

##### 1. Each Oompa Loompa owns the following information:
    - Name
    - Age
    - Job
    - Height
    - Weight
    - Description

##### 2. The server must fulfill the following API features:
    - Get the list of Oompa Loompas. For that list, only name, age and job are required per
      Oompa Looma.
    - Get the full detail of an Oompa Loompa
    - Add a new Oompa Loompa
    - Edit a current Oompa Loompa
##### 3. Tech Specifications:
    - Use Spring Boot framework
    - Use as many third party libraries as you want but, please, document all libraries you
      have used and explain the reason why you’ve used them.
    - Use docker
    - Use either Couchbase, MongoDB or MySql for your database

##### 4. Nice to have features (Bonus):
    - Be creative!
    - Error handling
    - Response caching
    - Hystrix/Resilience4j usage
    - RxJava/reactor usage
    - Paginate the list of Oompa Loompas
    - Fork your repo and use a different database

### Deployment Instructions

Docker has been used for containerization and docker compose for deployment in the project, for further
detailed information about deployment, go to `documentations` folder and see the detailed instructions given in [Deployment.md](https://github.com/riyas90cse/oompa-loomba-crud/blob/main/documentations/Deployment.md) file.

### Solution Approach

###### API Contract Specs

The API Specs Contract Documentation is find in the [Api-contract.md](https://github.com/riyas90cse/oompa-loomba-crud/blob/main/documentations/Api-contract.md) from the `documentations` folder.

###### Tools & Technology Stack Used
* Java 11
* Spring Boot
* MongoDB
* Spring WebFlux
* REST API
* Lombok
* JUnit 5 & Mockito
* Gradle (Build Tool)
* Logback (For logging)
* Jasypt Spring Boot (For encryption)
* Reactor (Reactive Programming)
* Apache Commons
* Embedded Mongo DB (For Development and Test Environment)
* Mongo Docker Container (For Staging Environment)
* OpenAPI (Swagger Documentation)
* Docker (For containerization)
* Docker Compose (For Deployment)

The Above tools and technology stack specifications are find in the document [HELP.md](https://github.com/riyas90cse/oompa-loomba-crud/blob/main/documentations/HELP.md) from `documentations` folder.

##### Execute the application:
The app uses JasyptSpringBoot for encrypting plain text in the application properties. The encryption requires environment based password. The spring boot application has two profiles defined.

* dev
* prod

In order to execute the application, there are two values set in the system environment.

1. SPRING_PROFILES_ACTIVE=`dev` or `prod`
2. APP_ENCRYPTION_PASSWORD=napptilus-service

The value `napptilus-service` is used to encrypt the plaintext. You can use a different password to encrypt the values which might require changing the ENC() values defined in this application properties.

After setting up the system environment values, you can execute the following commands.

##### Open mongo shell and run this:
To run it in production mode, we need to run this query before starting.

> use admin;

> db.createUser(
>  {
>  user: "root",
>  pwd: "root",
>  roles: [ "readWrite", "dbAdmin" ]
>  }
> );

##### Build without tests:
`./gradlew clean build -x test`

##### Build with tests:
`./gradlew clean build`

dev profile will be executed with embedded mongodb. The following command is used to execute dev profile.

`./gradlew clean bootRun -Pembedded`

To run only tests, execute the following.

`./gradlew test`

###### Gotcha #1:
In order to test the application, CORS is enabled for all. You can find `*` in the app origins.

napptilus.app.origins = https://oompa-service.napptilus.com,*

`*` is added for testing. This should be removed in prod environment

###### Gotcha #2:
Docker is used for deployment, Mongo Express for connecting to mongodb.

###### Gotcha #3:
Apache is considered to be used in this application as proxy server. Use the below configuration for routing the service.

    <VirtualHost *:80>
        ServerName oompa-service.napptilus.com

        ServerAdmin webmaster@localhost
        DocumentRoot /var/www/html

        ErrorLog ${APACHE_LOG_DIR}/error.log
        CustomLog ${APACHE_LOG_DIR}/access.log combined

        ProxyPass / http://localhost:20211/
        ProxyPassReverse / http://localhost:20211/
    </VirtualHost>
    <VirtualHost *:80>
        ServerName mongoexpress.napptilus.com

        ServerAdmin webmaster@localhost
        DocumentRoot /var/www/html

        ErrorLog ${APACHE_LOG_DIR}/error.log
        CustomLog ${APACHE_LOG_DIR}/access.log combined

        ProxyPass / http://localhost:8082/
        ProxyPassReverse / http://localhost:8082/
    </VirtualHost>

###### Gotcha #4:
Letsencrypt from ACME can be used for creating ssl certificates.

***

### DevOps Setup [github repo](https://github.com/riyas90cse/oompa-loompa-devops)
There is a dedicated project to set up docker container. It has various scripts to run.

> 1. docker_setup.sh will be used to create a base image. Make sure the docker_setup.sh has execute permission on your machine.
> 2. services.Dockerfile is creating the base image.
> 3. docker-compose.yml has definitions to generate 3 docker containers. One api service, one mongodb, and one mongo express to connect with mongo container.
> 4. Dockerfile is placed under napptilus-web/api folder.
> 5. oompaloompa.env is used to setup the system environment.

#### Run docker compose:

1. `./docker_setup.sh`
2. `docker-compose build`
3. `docker-compose up -d`

`docker ps -a` to check the services.

***

### Tests
JUnit 5, Spring Test have been used along with Mockito, reactor-test. There are 3 tests.

* 1 unit test
* 2 integration tests

Test coverage is 45-50%. Tests are aimed to cover most required test cases.

***

### Improvements to consider:
1. Hamcrest can be used.
2. Avoid setter injection, use constructor injection.
3. The application can be slightly modified to cover more tests.
4. Use kubernetes instead of docker compose.

*** 

### Postman collection:
Use this [postman collection](https://github.com/riyas90cse/oompa-loomba-crud/blob/main/documentations/data/napptilus-api.json) to test the api service.

*** 

### Swagger UI

OpenAPI(Swagger3) has been used for API Documentation. As soon as application is up, the swagger ui can be found under the below URI.

> http://localhost:20211/swagger-ui/


