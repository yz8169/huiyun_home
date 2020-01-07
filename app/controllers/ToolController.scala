package controllers

import javax.inject.Inject
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{AbstractController, ControllerComponents, RequestHeader}
import tool.Tool

/**
  * Created by yz on 2018/11/23
  */
class ToolController @Inject()(cc: ControllerComponents,tool:Tool) extends AbstractController(cc) {
  case class PortData(port: String)


  val portForm = Form(
    mapping(
      "port" -> text
    )(PortData.apply)(PortData.unapply)
  )

  def toOther = Action { implicit request =>
    val data = portForm.bindFromRequest().get
    println(data)
    val domain = tool.getRequestDomain
    Redirect(s"http://${domain}:${data.port}")
  }

}
