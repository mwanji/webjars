name := "webjars"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.4"

resolvers += "Spy Repository" at "http://files.couchbase.com/maven2"

libraryDependencies ++= Seq(
  ws,
  cache,
  filters,
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "jquery" % "1.11.1",
  "org.webjars" % "bootstrap" % "3.3.1",
  "org.webjars" % "highlightjs" % "8.0-3",
  "com.bionicspirit" %% "shade" % "1.6.0"
)

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

onLoad in Global := (onLoad in Global).value.andThen { state =>
  if (sys.props("java.specification.version") != "1.8") {
    sys.error("Java 8 is required for this project.")
    state.exit(ok = false)
  }
  else {
    state
  }
}

lazy val root = (project in file(".")).enablePlugins(PlayScala)
