# Eureka! Clinical Analytics Webapp
[Georgia Clinical and Translational Science Alliance (Georgia CTSA)](http://www.georgiactsa.org), [Emory University](http://www.emory.edu), Atlanta, GA

## What does it do?
It provides an angular-based web client for interacting with the Eureka! system. It also implements a proxy servlet and router for web clients to access the web services provided by `eureka-services` and `eureka-protempa-etl`.

## Version 1.0 development series
Latest release: [![Latest release](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-analytics-webapp/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-analytics-webapp)

The version 1.0 series is a refactoring of the eureka project's eureka-webapp module. The functionality is the same as in the last release of eureka-webapp.

## Build requirements
* [Oracle Java JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Maven 3.2.5 or greater](https://maven.apache.org)

## Runtime requirements
* [Oracle Java JRE 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Tomcat 7](https://tomcat.apache.org)
* Also running
  * The [eureka-services](https://github.com/eurekaclinical/eureka/tree/master/eureka-services) war
  * The [eureka-protempa-etl](https://github.com/eurekaclinical/eureka/tree/master/eureka-protempa-etl) war
  * The [eurekaclinical-user-webapp](https://github.com/eurekaclinical/eurekaclinical-user-webapp) war
  * The [eurekaclinical-user-service](https://github.com/eurekaclinical/eurekaclinical-user-service) war
  * The [cas-server](https://github.com/eurekaclinical/cas) war

## Proxied REST APIs
See the parent project's [README.md](https://github.com/eurekaclinical/eureka/blob/master/README.md).

## Building it
See the parent project's [README.md](https://github.com/eurekaclinical/eureka/blob/master/README.md).

## Performing system tests
See the parent project's [README.md](https://github.com/eurekaclinical/eureka/blob/master/README.md).

## Installation
### Configuration
This webapp is configured using a properties file located at `/etc/eureka/application.properties`. It supports the following properties:
* `cas.url`: https://hostname.of.casserver:port/cas-server
* `eureka.common.callbackserver`: https://hostname:port
* `eureka.common.demomode`: true or false depending on whether to act like a demonstration; default is false.
* `eureka.common.ephiprohibited`: true or false depending on whether to display that managing ePHI is prohibited; default is true.
* `eureka.webapp.registrationenabled`: true or false to enable/disable registering for an account managed by this project; default is true.
* `eureka.support.uri`: URI link for contacting support. Could be http, https, or mailto.
* `eureka.support.uri.name`: Display name of the URI link for contacting support.
* `eureka.webapp.callbackserver`: URL of the server running the webapp; default is https://localhost:8443.
* `eureka.webapp.url`: the URL of the webapp; default is https://localhost:8443/eureka-webapp.
* `eureka.webapp.ephiprohibited`: true or false depending on whether to display that managing ePHI is prohibited; default is true.
* `eureka.webapp.demomode`: true or false depending on whether to act like a demonstration; default is false.
* `eureka.services.url`: URL of the server running the services layer; default is https://localhost:8443/eureka-services.

A Tomcat restart is required to detect any changes to the configuration file.

### WAR installation
1) Stop Tomcat.
2) Remove any old copies of the unpacked war from Tomcat's webapps directory.
3) Copy the warfile into the Tomcat webapps directory, renaming it to remove the version if necessary. For example, rename `eurekaclinical-analytics-webapp-1.0.war` to `eurekaclinical-analytics-webapp.war`.
4) Start Tomcat.

## Maven dependency
```
<dependency>
    <groupId>org.eurekaclinical</groupId>
    <artifactId>eurekaclinical-analytics-webapp</artifactId>
    <version>version</version>
</dependency>
```

## Developer documentation
* [Javadoc for latest development release](http://javadoc.io/doc/org.eurekaclinical/eurekaclinical-analytics-webapp) [![Javadocs](http://javadoc.io/badge/org.eurekaclinical/eurekaclinical-analytics-webapp.svg)](http://javadoc.io/doc/org.eurekaclinical/eurekaclinical-analytics-webapp)

## Getting help
Feel free to contact us at help@eurekaclinical.org.

