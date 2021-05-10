package com

package object krykowski {
  type Row = List[Int]
  type Triangle = List[Row]

  sealed abstract class CustomException(val messsage: String, val cause: Option[Throwable] = None) extends Exception(
    messsage + cause.flatMap(c => Option(c.getMessage)).map(" - " + _).getOrElse(""),
    cause.orNull
  )

  case class ParsingException(errorCause: Throwable) extends CustomException("We couldn't read your file properly", Some(errorCause))

}
