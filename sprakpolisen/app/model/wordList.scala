package model

import play.api.libs.json._
import play.api.libs.functional.syntax._
import model.wordEntry
import model.dao.wordListDAO

object wordList {  
  implicit val wordListWrites: Writes[wordList] = (
    (JsPath \ "listName").write[String] and
    (JsPath \ "words").write[List[wordEntry]]
  )(unlift(wordList.unapply))
  
  def retrieve(languageId: Int): wordList = {
    val myList = wordListDAO.get(languageId)
    wordList("trainingList", myList)
    
  }
}

case class wordList(listName: String, words: List[wordEntry])