package actions

import javax.inject._

import play.api._
import play.api.mvc._ 
import play.api.libs.json._
import model.wordEntry
import model.wordEntry._

class FindWord extends Controller {
  def find(word: String) = Action {
    val wordExists = wordEntry.findWord(1, word)
    
    wordExists match {
      case None => NotFound(Json.obj("error" -> "NOT_FOUND"))
      case Some(wordEntry) => Ok(Json.obj("result" -> wordEntry))
    }
    
  }
}