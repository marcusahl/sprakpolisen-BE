package model.dao

import javax.inject._

import anorm._
import anorm.SqlParser._
import play.api.db._
import model.wordEntry
import play.api.Play.current

object wordEntryDAO {  
  
  def create(newWord: wordEntry) = {
    DB.withConnection() { implicit connection =>
      SQL(
          """
          | INSERT IGNORE INTO `words` (`languageId`, `word`)
          | VALUES
          |  ({languageId}, {word});
          """.stripMargin).on(
              "languageId" -> newWord.languageId,
              "word" -> newWord.word
              ).executeInsert()
     }
   }
  
  def delete(newWord: wordEntry) = {
    DB.withConnection() { implicit connection =>
      SQL(
          """
          | DELETE FROM `words` 
          | WHERE
          | `word`={word};
          """.stripMargin).on(
            "word" -> newWord.word  
            ).executeUpdate()
      
    }
  }
  
  def find(word: String): Boolean = {
    DB.withConnection() { implicit connection =>
      val results: Int= SQL(
          """
          | SELECT COUNT(*) as "numMatches" FROM `words`
          | WHERE word={word}
          """.stripMargin).on(
             "word" -> word
             ).as(SqlParser.int("numMatches").single)
             
      results != 0
      
    }
  }
  
}
