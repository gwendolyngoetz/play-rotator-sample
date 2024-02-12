lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := "rotator-sample",
    version := "1.0.0-SNAPSHOT",
    scalaVersion := "2.13.12",
    libraryDependencies ++= Seq(
      guice,
      javaJdbc,
      "com.jayway.jsonpath" % "json-path" % "2.8.0",
      "com.fasterxml.jackson.datatype" % "jackson-datatype-guava" % "2.16.1",
      "com.fasterxml.jackson.datatype" % "jackson-datatype-jdk8" % "2.16.1",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.16.1",
      "com.google.inject.extensions" % "guice-assistedinject" % "5.1.0",
      // Database and database testing libraries
      "org.postgresql" % "postgresql" % "42.6.0",
      "com.h2database" % "h2" % "2.2.224" % Test,
      // To provide an implementation of JAXB-API, which is required by Ebean.
      "javax.xml.bind" % "jaxb-api" % "2.3.1",
      "javax.activation" % "activation" % "1.1.1",
      "org.glassfish.jaxb" % "jaxb-runtime" % "2.3.9",
      // Autovalue
      "com.google.auto.value" % "auto-value-annotations" % "1.10.4",
      "com.google.auto.value" % "auto-value" % "1.10.4",
      // https://javadoc.io/doc/com.google.guava/guava-testlib/latest/index.html
      "com.google.guava" % "guava-testlib" % "33.0.0-jre" % Test,
    ),
    javacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-parameters",
      "-Xlint:unchecked",
      "-Xlint:deprecation",
      "-XDcompilePolicy=simple",
      // Turn off the AutoValueSubclassLeaked error since the generated
      // code contains it - we can't control that.
      "-implicit:class",
      "-Werror",
      // The compile option below is a hack that preserves generated files. Normally,
      // AutoValue generates .java files, compiles them into .class files, and then deletes
      // the .java files. This option keeps the .java files in the specified directory,
      // which allows an IDE to recognize the symbols.
      "-s",
      generateSourcePath(scalaVersion = scalaVersion.value)
    )
  )

// scalaVersion is formatted as x.y.z, but we only want x.y in our path. This function
// removes the .z component and returns the path to the generated source file directory.
def generateSourcePath(scalaVersion: String): String = {
  val version = scalaVersion.split("\\.").take(2).mkString(".")
  s"target/scala-$version/src_managed/main"
}
