package com.krykowski

import scala.util.{Failure, Success}

case class Solution(cost: Int, path: List[Int]) {
  def addHead(headCost: Int): Solution = Solution(headCost + cost, headCost :: path)
}

object Solution {
  def solveOneRow(row: Row, belowSolutions: List[Solution]): List[Solution] = {
    require(row.size == belowSolutions.size - 1)
    val leftRightSolutions = belowSolutions.zip(belowSolutions.tail)
    val minBelowSolutions = leftRightSolutions.map { case (left, right) => if (left.cost < right.cost) left else right }
    row.zip(minBelowSolutions).map { case (cost, belowSolution) => belowSolution.addHead(cost) }
  }

  def solveTriangle(triangle: Triangle): Solution = {
    val reversedTriangle = triangle.reverse
    val nBottom = reversedTriangle.head.size
    val emptySolutions: List[Solution] = List.fill(nBottom + 1) {
      Solution(0, List())
    }
    val finalSolution = reversedTriangle.foldLeft(emptySolutions)((belowSolutions, row) => solveOneRow(row, belowSolutions))
    finalSolution.head
  }

  def run(fileName: String): Either[ParsingException, Solution] = {
    val triangle = Parser.parse(fileName)

    triangle match {
      case Success(value) => Right(solveTriangle(value))
      case Failure(exception) => Left(ParsingException(exception))
    }
  }

}
