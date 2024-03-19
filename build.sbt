ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "sample-zio-htmx",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio-http" % "3.0.0-RC3",
      "org.scala-lang.modules" %% "scala-xml" % "2.2.0"
    )
  )
