package actions

import play.api._
import play.api.mvc._ 
import play.api.libs.json._
import model.wordEntry
import model.wordEntry._

class DeleteWord extends Controller {
  def delete(word: String) = Action {
    val wordToDelete = wordEntry.deleteWord(1, word)
    Ok(Json.obj("result" -> wordToDelete))
    
  }
}