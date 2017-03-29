package actions

import javax.inject._

import play.api._
import play.api.mvc._ 
import play.api.libs.json._
import model.wordEntry
import model.wordEntry._

/*
 * This object adds a word to the list of known words
 */

class AddWord extends Controller {
  def add(word: String) = Action {
    
    // This part is for writing to a database
    // val newWord = wordEntry.addWord(1, word)
    // Ok(Json.obj("result" -> newWord))
    
    // Adding a wordentry in memory
    Ok(Json.obj("result" -> wordEntry(1, word)))
    
  }
}