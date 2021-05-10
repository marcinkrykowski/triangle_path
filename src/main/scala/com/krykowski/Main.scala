package com.krykowski

import com.krykowski.Solution.solveTriangle

object Main extends App {
  val triangle = Parser.parse("myFile.txt")
  println(solveTriangle(triangle))
}
