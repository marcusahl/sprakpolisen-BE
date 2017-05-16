package model.dao

import anorm._
import anorm.SqlParser._
import play.api.db._
import model.wordEntry
import model.wordList
import play.api.Play.current

object wordListDAO {
  
  val parser: RowParser[wordEntry] = Macro.namedParser[wordEntry]
  /*
	SqlParser.get[Int]("languageId") ~ SqlParser.get[String]("word").map[model.wordEntry](((x$1) => 
	x$1 match {   
		case ~((languageId), (word)) => 
		new model.wordEntry(languageId, word) 
	}))	
   
   */
  
  
  def get(languageId: Int): List[wordEntry] = {
    DB.withConnection() { implicit connection =>
      val result = SQL(
          """
          | SELECT `languageId`, `word` 
          | FROM `words`
          | WHERE languageId = {languageId}; 
          """.stripMargin).on(
              "languageId" -> languageId
              ).as(parser.*)
          
      result
            
    }
  } 
}