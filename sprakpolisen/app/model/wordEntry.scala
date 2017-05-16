package model

import javax.inject._

import play.api.libs.json._
import play.api.libs.functional.syntax._
import model.dao.wordEntryDAO


object wordEntry {
  implicit val wordEntryWrites: Writes[wordEntry] = (
    (JsPath \ "languageId").write[Int] and
    (JsPath \ "word").write[String]
  )(unlift(wordEntry.unapply))
  
  
  def addWord(languageId: Int, word: String): wordEntry = {
    val newEntry = wordEntry(languageId, word)
    
    wordEntryDAO.create(newEntry)  
    newEntry
      
  }
  
  def deleteWord(languageId: Int, word: String) = {
    wordEntryDAO.delete(wordEntry(languageId, word))  
    
  }
  
  def findWord(languageId: Int, word: String): Option[wordEntry] = {
    val myWord = wordEntry(languageId, word)
    
    if (wordEntryDAO.find(word))
      Some(myWord)
    else
      None
  
  }
  
}

case class wordEntry (languageId: Int, word: String)