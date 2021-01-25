name := "adentis-dott"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies ++= Seq(
  "info.picocli" % "picocli" % "4.6.1",
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.0",
  "org.scalatest" %% "scalatest-funsuite" % "3.2.3" % "test"
)
