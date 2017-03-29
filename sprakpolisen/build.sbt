name := """sprakpolisen"""
organization := "com.hulwol"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
filters,
//"org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
jdbc,
"mysql" % "mysql-connector-java" % "5.1.18",
"com.typesafe.play" %% "anorm" % "2.5.1",
ws,
cache
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.hulwol.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.hulwol.binders._"

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)