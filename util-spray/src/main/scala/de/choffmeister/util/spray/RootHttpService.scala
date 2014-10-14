package de.choffmeister.util.spray

import akka.actor._
import akka.io.Tcp._
import spray.http.HttpMethods._
import spray.http.StatusCodes._
import spray.http._

class RootHttpService(apiHttpService: ActorRef, staticContentHttpService: ActorRef) extends Actor {
  def receive = {
    case Connected(_, _) =>
      sender ! Register(self)
    case req@HttpRequest(_, uri, _, _, _) if uri.path.startsWith(Uri.Path("/api")) =>
      apiHttpService.tell(req, sender)
    case req@HttpRequest(GET, _, _, _, _) =>
      staticContentHttpService.tell(req, sender)
    case req@HttpRequest(_, _, _, _, _) =>
      sender ! HttpResponse(status = BadRequest)
  }
}
