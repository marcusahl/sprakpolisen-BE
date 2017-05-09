package model

import play.api.libs.json._
import play.api.libs.functional.syntax._

object LookupWordModel {

  implicit val LookupWordWrites: Writes[LookupWordModel] = (
    (JsPath \ "userId").write[Int] and
    (JsPath \ "word").write[String]
  )(unlift(LookupWordModel.unapply))
}

case class LookupWordModel(userId: Int, word: String)