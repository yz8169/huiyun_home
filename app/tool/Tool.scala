package tool

import play.api.mvc.RequestHeader

/**
  * Created by yz on 2019/5/16
  */
class Tool {

  def getRequestDomain(implicit request: RequestHeader) = {
    request.domain
  }

}
