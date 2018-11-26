# gamesense-jenkins

![Build status](https://travis-ci.org/philipparndt/gamesense-jenkins.svg?branch=master)

[![Quality Gate](https://sonarcloud.io/api/project_badges/quality_gate?project=de.rnd7.buildlight.steelseries%3Ade.rnd7.buildlight.steelseries.parent&branch=master)](https://sonarcloud.io/dashboard?id=de.rnd7.buildlight.steelseries%3Ade.rnd7.buildlight.steelseries.parent)

This library is part of `BuildLight`, a tool that monitors the status of Jenkins jobs. They status is displayed as a tray icon and the color (red, yellow, green) on steel series devices. It can be used as a starting point on how to use the [SteelSeries GameSense™ SDK](https://github.com/SteelSeries/gamesense-sdk) 

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
  <version>0.5.0</version>
</dependency>
```

# Example usage

```java
JenkinsGame game = new JenkinsGame();
if (game.isAvailable()) {
  game.create()
  .setStatus(JenkinsStatus.SUCCESSFULLY);
}
```

Note that you will need to call
```java
game.heartbeat();
```

every 15 secounds in order to keep the color alive. Otherwise the steelseries driver will reset the color.

# Custom colors

```java
JenkinsGame game = new JenkinsGame()
		 .setColor(JenkinsStatus.SUCCESSFULLY, new Color(0xFF, 0x42, 0x0D))
		 .create()
		 .setStatus(JenkinsStatus.SUCCESSFULLY);
```

# Keyboard color

```java
 JenkinsGame game = new JenkinsGame()
 .setDeviceType(DeviceType.KEYBOARD)
 .create()
 .setStatus(JenkinsStatus.SUCCESSFULLY);
```
