package controllers

import play.api.mvc.Controller
import play.api.Play
import play.api.Play.current
import controllers.routes.{StaticWebJarAssets => AssetRoutes}
import WebJarAssets.locate

object StaticWebJarAssets extends Controller {

  def at(file: String) = Assets.at("/META-INF/resources/webjars", file)

  lazy val maybeContentUrl = Play.configuration.getString("contentUrl")

  def getUrl(file: String) = {
    val atUrl = AssetRoutes.at(locate(file)).url
    maybeContentUrl.fold(atUrl)(_ + atUrl)
  }

}

