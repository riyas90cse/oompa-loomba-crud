### Specification For Tools & Technology Used
##### Java 11
###### Objective
JDK 11 is the open-source reference implementation of version 11 of the Java SE Platform as specified by JSR 384 in the Java Community Process.
###### References
* Open JDK - https://openjdk.java.net/projects/jdk/11/
* Oracle JDK - https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html

##### Spring Boot Version - 2.4.1
###### Objective
Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need minimal Spring configuration.
If you’re looking for information about a specific version, or instructions about how to upgrade from an earlier release, check out the project release notes section on our wiki.

###### Features
* Create stand-alone Spring applications
* Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)
* Provide opinionated 'starter' dependencies to simplify your build configuration
* Automatically configure Spring and 3rd party libraries whenever possible
* Provide production-ready features such as metrics, health checks, and externalized configuration
* Absolutely no code generation and no requirement for XML configuration

###### References
https://spring.io/projects/spring-boot

##### Restful API
###### Objective
###### What is REST
In a nutshell, REST APIs (which are a type of web API) involve requests and responses, not too unlike visiting a web page. You make a request to a resource stored on a server, and the server responds with the requested information.
The protocol used to transport the data is HTTP. “REST” stands for Representational State Transfer.

REST is acronym for Representational State Transfer. It is architectural style for distributed hypermedia systems and was first presented by Roy Fielding in 2000 in his famous dissertation.
Like any other architectural style, REST also does have its own 6 guiding constraints which must be satisfied if an interface needs to be referred as RESTful. These principles are listed below.

###### Guiding Principles of REST
* Client–server By separating the user interface concerns from the data storage concerns, we improve the portability of the user interface across multiple platforms and improve scalability by simplifying the server components.
* Stateless – Each request from client to server must contain all the information necessary to understand the request, and cannot take advantage of any stored context on the server. Session state is therefore kept entirely on the client.
* Cacheable – Cache constraints require that the data within a response to a request be implicitly or explicitly labeled as cacheable or non-cacheable. If a response is cacheable, then a client cache is given the right to reuse that response data for later, equivalent requests.
* Uniform interface – By applying the software engineering principle of generality to the component interface, the overall system architecture is simplified, and the visibility of interactions is improved. In order to obtain a uniform interface, multiple architectural constraints are needed to guide the behavior of components. REST is defined by four interface constraints: identification of resources; manipulation of resources through representations; self-descriptive messages; and, hypermedia as the engine of application state.
* Layered system – The layered system style allows an architecture to be composed of hierarchical layers by constraining component behavior such that each component cannot “see” beyond the immediate layer with which they are interacting.
* Code on demand (optional) – REST allows client functionality to be extended by downloading and executing code in the form of applets or scripts. This simplifies clients by reducing the number of features required to be pre-implemented.

###### References
* Spring Rest Docs - https://spring.io/guides/tutorials/rest/
* Rest API Standards - https://restfulapi.net/

##### Spring WebFulx
###### Objective
The original web framework included in the Spring Framework, Spring Web MVC, was purpose-built for the Servlet API and Servlet containers. The reactive-stack web framework, Spring WebFlux, was added later in version 5.0. It is fully non-blocking, supports Reactive Streams back pressure, and runs on such servers as Netty, Undertow, and Servlet 3.1+ containers.
Both web frameworks mirror the names of their source modules (spring-webmvc and spring-webflux) and co-exist side by side in the Spring Framework. Each module is optional. Applications can use one or the other module or, in some cases, both — for example, Spring MVC controllers with the reactive WebClient.
Spring WebFlux internally uses Project Reactor and its publisher implementations – Flux and Mono.

###### The framework supports two programming models:
* Annotation-based reactive components
* Functional routing and handling

###### References
https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#spring-webflux

##### Lombok
###### Objective
Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.

###### References
https://projectlombok.org/

##### JUnit 5 & Mockito
###### Objective
JUnit 5 is the next generation of JUnit. The goal is to create an up-to-date foundation for developer-side testing on the JVM. This includes focusing on Java 8 and above, as well as enabling many styles of testing.
JUnit is one of the most popular unit-testing frameworks in the Java ecosystem. The JUnit 5 version contains a number of exciting innovations, with the goal to support new features in Java 8 and above, as well as enabling many styles of testing.

Mockito is a java based a mocking framework, used in conjunction with other testing frameworks such as JUnit and TestNG. It internally uses Java Reflection API and allows creating objects of a service. A mock object returns a dummy data and avoids external dependencies.

Mockito allows you to create and configure mock objects. Using Mockito greatly simplifies the development of tests for classes with external dependencies. If you use Mockito in tests you typically: Mock away external dependencies and insert the mocks into the code under test.

###### Features
* Parallel tests. Though still an experimental feature, this allows you to calculate the CPUs you have, how far your tests can be parallelized, and then run the tests too.
* Un-public. In JUnit 5, there’s no need to make everything public.
* Lambda. in JUnit 5, you can add Lambda support, adding visibility and reducing your code.
* 3rd party integration.
* Nested test classes.
* IDEs and tools support.

###### References
* JUnit5 Docs - https://junit.org/junit5/
* Mockito Docs - https://site.mockito.org/

##### Mongo DB
###### Objective
MongoDB is a cross-platform document-oriented database program. Classified as a NoSQL database program, MongoDB uses JSON-like documents with optional schemas. MongoDB is developed by MongoDB Inc. and licensed under the Server Side Public License

What should I use MongoDB for? MongoDB is great for transactional stores where performance is a concern. Its also great when the data structure is going to evolve over time, as its schema-less operations allow you to update the data on the fly.

MongoDB is a scalable, flexible NoSQL document database platform designed to overcome the relational databases approach and the limitations of other NoSQL solutions. MongoDB is well known for its horizontal scaling and load balancing capabilities, which has given application developers an unprecedented level of flexibility and scalability.

###### Features
* Ad-hoc queries for optimized, real-time analytics
* Indexing appropriately for better query executions
* Replication for better data availability and stability
* Sharding
* Load balancing

The Above 5 features are some of the most important core features.

###### References
https://docs.mongodb.com/

##### OpenAPI (Swagger Documentation)
###### Objective
Swagger is a set of open-source tools built around the OpenAPI Specification that can help you design, build, document and consume REST APIs. The major Swagger tools include:

* Swagger Editor – browser-based editor where you can write OpenAPI specs.
* Swagger UI – renders OpenAPI specs as interactive API documentation.
* Swagger Codegen – generates server stubs and client libraries from an OpenAPI spec.

###### Swagger UI
Swagger UI allows anyone — be it your development team, or your end consumers — to visualize and interact with the API’s resources without having any of the implementation logic in place. It’s automatically generated from your OpenAPI (formerly known as Swagger) Specification, with the visual documentation making it easy for back end implementation and client side consumption

###### References
https://swagger.io/tools/swagger-ui/

##### Logback (For logging)
###### Objective
Logback is intended as a successor to the popular log4j project, picking up where log4j leaves off.

Logback's architecture is sufficiently generic so as to apply under different circumstances. At present time, logback is divided into three modules, logback-core, logback-classic and logback-access.

The logback-core module lays the groundwork for the other two modules. The logback-classic module can be assimilated to a significantly improved version of log4j. Moreover, logback-classic natively implements the SLF4J API so that you can readily switch back and forth between logback and other logging frameworks such as log4j or java.util.logging (JUL).

The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality. Note that you could easily build your own module on top of logback-core.

###### References
http://logback.qos.ch/documentation.html

##### Jasypt Spring Boot (For encryption)
###### Objective
Enable Jasypt to encrypt configuration file attributes in a Spring Boot application for decrypting and use at runtime.

###### References
https://github.com/ulisesbocchio/jasypt-spring-boot

##### Reactor (Reactive Programming)
###### Objective
Reactor is a reactive programming library for the Java language which provides the basis for developing non-blocking applications, thus representing a change in how we think about an application's execution model.

Reactor is a fourth-generation reactive library, based on the Reactive Streams specification, for building non-blocking applications on the JVM

Reactor is fully non-blocking and provides efficient demand management. It directly interacts with Java's functional API, CompletableFuture, Stream, and Duration.

Reactor offers two reactive and composable APIs, Flux [N] and Mono [0|1], which extensively implement Reactive Extensions.

Well-suited for a microservices architecture, Reactor offers backpressure-ready network engines for HTTP (including Websockets), TCP, and UDP.

###### References
https://projectreactor.io/

##### Apache Commons
###### Objective
Apache Commons Lang, a package of Java utility classes for the classes that are in java.lang's hierarchy, or are considered to be so standard as to justify existence in java.lang.

###### References
https://commons.apache.org/

##### Docker (For containerization) && Docker Compose (For Deployment)
###### Objective

Docker is an open platform for developing, shipping, and running applications. Docker enables you to separate your applications from your infrastructure so you can deliver software quickly. With Docker, you can manage your infrastructure in the same ways you manage your applications.

Docker is a set of platform as a service products that use OS-level virtualization to deliver software in packages called containers. Containers are isolated from one another and bundle their own software, libraries and configuration files; they can communicate with each other through well-defined channels.

Compose is a tool for defining and running multi-container Docker applications. With Compose, you use a YAML file to configure your application's services.

###### References
* Docker Docs - https://docs.docker.com/get-started/overview/
* Docker Compose Doc - https://docs.docker.com/compose/