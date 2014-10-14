package de.choffmeister.util.spray

import java.io.File

import akka.actor._
import spray.routing._

class StaticContentHttpService(webDir: Option[File]) extends Actor with HttpService {
  implicit val actorRefFactory = context
  implicit val executor = context.dispatcher
  implicit val timeout = akka.util.Timeout(1000)

  def receive = runRoute(route)
  def route = webDir match {
    case Some(webDir) =>
      val index = getFromFile(s"${webDir}/index.html")
      val cache = getFromFile(s"${webDir}/cache.manifest")
      val app = getFromDirectory(webDir.toString)
      pathSingleSlash(index) ~
      path("index.html")(index) ~
      path("cache.manifest")(cache) ~
      pathPrefixTest(("app" ~ Slash))(app) ~
      pathPrefixTest(!("app" ~ Slash))(index)
    case _ =>
      reject()
  }
}
