package com.krykowski

import scala.io.Source
import scala.util.Try


object Parser {

  def parse(fileName: String): Try[List[List[Int]]] =
    Try {
      val source = Source.fromFile(fileName)
      var lines = List[List[Int]]()
      for (line <- source.getLines()) {
        val values = line.split(" ").toList.map(_.toInt)
        lines = values :: lines
      }
      source.close()
      lines.reverse
    }

  def makeSolution(solution: Solution): String = {
    s"Minimal path is: ${solution.path.map(_.toString).mkString(" + ")} = ${solution.cost}"
  }
}

