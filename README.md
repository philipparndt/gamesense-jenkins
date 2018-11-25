# gamesense-jenkins

![Build status](https://travis-ci.org/philipparndt/gamesense-jenkins.svg?branch=master)

This is a small demo application that shows how to update the mouse LED of a steelseries mouse to diffent light. 
It is used as a consumer for a Jenkins Tray icon application.

# Repository

Add the following repository to your `pom.xml` file:

```xml
<repositories>
  <repository>
    <id>philipparndt-production</id>
    <url>https://packagecloud.io/philipparndt/production/maven2</url>
    <releases>
      <enabled>true</enabled>
    </releases>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>
```

# Dependency

Add the following dependency to your `pom.xml`file:
```xml
<dependency>
  <groupId>de.rnd7.buildlight.steelseries</groupId>
  <artifactId>de.rnd7.buildlight.steelseries</artifactId>
  <version>0.3.1</version>
</dependency>
```

# Example usage

```java
JenkinsGame game = new JenkinsGame();
game.create();
game.red();
```
