package com.krykowski

object Main extends App {
  Solution.run("myFile.txt") match {
    case Right(solution) => println(Parser.makeSolution(solution))
    case Left(exception) => println(exception.messsage)
  }
}
