name := "util-spray"

libraryDependencies ++= {
  val dependencies = Seq(
    "com.typesafe" % "config" % "1.2.0",
    "com.typesafe.akka" %% "akka-actor" % "2.3.6",
    "com.typesafe.akka" %% "akka-slf4j" % "2.3.6",
    "io.spray" %% "spray-can" % "1.3.1",
    "io.spray" %% "spray-routing" % "1.3.1"
  )
  val testDependencies = Seq(
    "com.typesafe.akka" %% "akka-testkit" % "2.3.6",
    "io.spray" %% "spray-testkit" % "1.3.1",
    "org.specs2" %% "specs2" % "2.4.1"
  ).map(_ % "test")
  dependencies ++ testDependencies
}
