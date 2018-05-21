# Spring Boot

Spring boot let you to develop Spring application with more agility and more focus on the business rather deal with the configurations.
It will help us with the common configuration & dependencies.

Example :
---
Configuration :

To create a Spring rest application we need to deal with specific configuration such as web.xml, servlets and filters (Spring's DispatcherServlet)
Spring boot will configure this for us.

Dependencies :

Spring boot help us to provide with already selected dependencies.

Examining Spring Boot essentials 

* Automatic configuration
* Starter dependencies
* The Actuators
* Spring boot fat jar
* The command-line interface (optional)

Deep dive
---
### Auto-configuration

For example, prior to Spring boot to access a relational database with Jdbc, we need to configure Spring's Jdbc template.
Spring boot can automatically configure/create these beans.

### Starter dependencies

Starter dependencies is a special Maven (or Gradle) dependencies that take advantage of transitive dependency resolution to regroup commonly used library.
Example Spring MVC :
* org.springframework:spring-core
* org.springframework:spring-web
* org.springframework:spring-webmvc
* com.fasterxml/jackson.core:jackson-databind
* org.hibernate:hibernate-validator
* org.apache.tomcat.embed:tomcat-embed-core
* org.apache.tomcat.embed:tomcat-embed-el
* org.apache.tomcat.embed:tomcat-embed-logging-juli

Will be regrouped to ```org.springframework.boot:spring-boot-starter-web```.
We can leave also for spring boot to make sure the version compatibility between those dependencies.

### The Actuators

This is how Spring boot magic lies.
This is where Spring boot activate (or not) some beans based on the existing dependencies or existing bean.
We can also create our own actuator.
For example step component use the actuators to create step beans for monitoring.

### Spring Fat jar

Spring simplify the deployment by creating a single jar : fat jar, which contains all the dependencies classes.
Then we just run the spring fat jar as an simple runnable jar.

What Spring Boot isn't
---

Spring boot is not an application server. 
Spring boot embed the application server such as tomcat, undertow, jetty etc. 


Ref
---
Spring Boot in Action - Craig Walls - Manning
 






  