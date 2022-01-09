# Project description

Simple template for projects that make use of JavaFX and FXML (Scene Builder).
Requires Java 11 or later. Compatible with Eclipse and IntelliJ IDEA.
Minor issues with Netbeans. Automatically integrates with the Gitlab CI.

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

  * Java platform: https://tech.utugit.fi/soft/tools/lectures/dtek0065/devtools/
  * Maven: https://tech.utugit.fi/soft/tools/lectures/dtek0065/build/basic/
  * Gradle: https://tech.utugit.fi/soft/tools/lectures/dtek0065/build/gradle/
  * SBT: https://tech.utugit.fi/soft/tools/lectures/dtek0065/build/sbt/

External sources:

  * JavaFX: https://openjfx.io/javadoc/17/
  * Scene Builder: https://docs.gluonhq.com/scenebuilder/
