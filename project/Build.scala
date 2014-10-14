import sbt._
import sbt.Keys._

object Build extends sbt.Build {
  lazy val commonSettings = Defaults.defaultSettings ++ Seq(
    organization := "de.choffmeister",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.11.2",
    scalacOptions <<= baseDirectory.map(bd =>
      Seq("-encoding", "utf8") ++
      Seq("-sourcepath", bd.getAbsolutePath)),
    publishMavenStyle := true,
    publishTo := Some(Resolver.sftp("repo.choffmeister.de", "choffmeister.de", "maven2") as("repo"))
  )

  lazy val commonProjectSettings = commonSettings

  lazy val core = (project in file("util-core"))
    .settings(commonProjectSettings: _*)

  lazy val spray = (project in file("util-spray"))
    .settings(commonProjectSettings: _*)
    .dependsOn(core)

  lazy val root = (project in file("."))
    .settings(commonSettings: _*)
    .settings(name := "util")
    .aggregate(core, spray)
}
