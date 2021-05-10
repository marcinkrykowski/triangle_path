package com.krykowski

import com.krykowski.Solution.solveTriangle

object Main extends App {
  val triangle = List(List(7), List(6, 3), List(3, 8, 8), List(11, 2, 10, 9))
  println(solveTriangle(triangle))
}
