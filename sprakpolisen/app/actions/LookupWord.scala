package actions

import play.api._
import play.api.mvc._ 
import play.api.libs.json._


/*
 * This object looks up if a word is a Swedish word
 */

class LookupWord extends Controller{
  
  def lookup(word: String) = Action { request =>
    val body: AnyContent = request.body
    val jsonBody: Option[JsValue] = body.asJson
    
    //Expects a json request
    jsonBody.map { json =>
      Ok("Looked up " + (json \ word).as[String])
    }.getOrElse {
      BadRequest("Expecting application/json request body")
    }
    

  }
}