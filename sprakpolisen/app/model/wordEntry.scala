package model

import javax.inject._

import play.api.libs.json._
import play.api.libs.functional.syntax._
import model.dao.wordEntryDAO


object wordEntry {
  implicit val wordEntryWrites: Writes[wordEntry] = (
    (JsPath \ "userId").write[Int] and
    (JsPath \ "word").write[String]
  )(unlift(wordEntry.unapply))
  
  
  def addWord(userId: Int, word: String): wordEntry = {
    val newEntry = wordEntry(userId, word)
    
    wordEntryDAO.create(newEntry)  
    newEntry
    
    
  }
}

case class wordEntry (userId: Int, word: String)