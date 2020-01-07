package controllers

import javax.inject._
import play.api.mvc._
import tool.Tool

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, tool: Tool) extends AbstractController(cc) {

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index = Action { implicit request =>
    val domain = tool.getRequestDomain
    if (domain.contains("ip4m")) {
      Redirect("https://github.com/IP4M/manual/wiki")
    } else {
      Ok(views.html.index("Your new application is ready."))

    }


  }

}
