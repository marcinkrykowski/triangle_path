package com.krykowski

import scala.io.Source


object Parser {
  def parse(fileName: String): List[List[Int]] = {
    val source = Source.fromFile(fileName)
    var lines = List[List[Int]]()
    for (line <- source.getLines()) {
      val values = line.split(" ").toList.map(_.toInt)
      lines = values :: lines
    }
    source.close()
    lines.reverse
  }
}
