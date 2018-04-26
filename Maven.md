# Maven

Apache Maven is a software project management and comprehension tool. 
Based on the concept of a *project object model (POM)*, Maven can manage a project's build, reporting and documentation from a central piece of information.
Maven, a Yiddish word meaning accumulator of knowledge, was originally started as an attempt to simplify the build processes in the Jakarta Turbine project. 


## Maven Build cycle

* _validate_ - validate the project is correct and all necessary information is available
* _compile_ - compile the source code of the project
* _test_ - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
* _package_ - take the compiled code and package it in its distributable format, such as a JAR.
* _verify_ - run any checks on results of integration tests to ensure quality criteria are met
* _install_ - install the package into the local repository, for use as a dependency in other projects locally
* _deploy_ - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

[See more](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)

## Maven Build Profile

Profiles are specified using a subset of the elements available in the POM itself (plus one extra section), and are triggered in any of a variety of ways. 
They modify the POM at build time, and are meant to be used in complementary sets to give equivalent-but-different parameters for a set of target environments (providing, for example, the path of the appserver root in the development, testing, and production environments). 

[See more](https://maven.apache.org/guides/introduction/introduction-to-profiles.html)

## Maven Standard Directory Layout

Having a common directory layout would allow for users familiar with one Maven project to immediately feel at home in another Maven project. 
The advantages are analogous to adopting a site-wide look-and-feel.

[See more](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)

## Maven Plugin

Maven is - at its heart - a plugin execution framework; all work is done by plugins. Looking for a specific goal to execute? This page lists the core plugins and others.

[See more](https://maven.apache.org/plugins/index.html)


## Maven Archetype

In short, Archetype is a Maven project templating toolkit.

[See more](https://maven.apache.org/archetype/index.html)

## Maven Repository

### Local repository
### Remote repository
### Maven Central

## Exercises 

* Mavenize the project
* Maven with multi module
* Add some test and run it with Unit test and IT Test
* Introduction to Egencia Maven Archetypes
