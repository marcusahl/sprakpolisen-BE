package model.dao

import javax.inject._

import anorm._
import play.api.db._
import model.wordEntry
import play.api.Play.current

//case class wordEntryDAO @Inject()(db: Database){
object wordEntryDAO {  
  def create(newWord: wordEntry) = {
    DB.withConnection() { implicit connection =>
      SQL(
          """
          | INSERT IGNORE INTO `words` (`userId`, `word`)
          | VALUES
          |  ({userId}, {word});
          """.stripMargin).on(
              "userId" -> newWord.userId,
              "word" -> newWord.word
              ).executeInsert()
     }
   }
}
