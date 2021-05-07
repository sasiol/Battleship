# Project description

Simple template for projects that make use of JavaFX and FXML (Scene Builder).
Requires Java 11 or later. Compatible with Eclipse and IntelliJ IDEA.
Minor issues with Netbeans. Automatically integrates with Gitlab CI.

## Installation

### Maven

```bash
$ git clone https://gitlab.utu.fi/tech/education/gui/template-javafx

$ cd template-javafx

$ mvn compile
$ mvn javafx:run

# distribution (see `target/image/bin/`)
$ mvn javafx:jlink
```

### Gradle

```bash
$ git clone https://gitlab.utu.fi/tech/education/gui/template-javafx

$ cd template-javafx

$ ./gradlew build
$ ./gradlew run
```

### SBT

Not really supported or recommended. Does not support all the modern
Java features. To make it work, first, remove `src/main/java/module-info.java`.
SBT does not support JPMS yet.

```bash
$ git clone https://gitlab.utu.fi/tech/education/gui/template-javafx

$ cd template-javafx

$ sbt compile
$ sbt run
```

## Further instructions

  * Java platform: https://gitlab.utu.fi/soft/ftdev/wikis/tutorials/jvm-platform
  * Maven: https://gitlab.utu.fi/soft/ftdev/wikis/tutorials/maven-misc
  * SBT: https://gitlab.utu.fi/soft/ftdev/wikis/tutorials/sbt-misc

External sources:

  * JavaFX: https://openjfx.io/javadoc/16/
  * Scene Builder: https://docs.gluonhq.com/scenebuilder/
