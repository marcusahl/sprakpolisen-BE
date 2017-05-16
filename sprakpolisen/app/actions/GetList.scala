package actions

import play.api._
import play.api.mvc._ 
import play.api.libs.json._
import model.wordList

class GetList extends Controller{
  def get() = Action {
    
    val newList = wordList.retrieve(1)
    Ok(Json.obj("result" -> newList))
  }
}