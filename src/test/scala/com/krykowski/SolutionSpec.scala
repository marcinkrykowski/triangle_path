package com.krykowski

import com.krykowski.Solution.{solveOneRow, solveTriangle}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class SolutionSpec extends AnyFlatSpec with Matchers {

  "Solution" should "add head cost to existing head" in {
    val solution = Solution(5, List(4, 1))
    val result = solution.addHead(3)

    result.cost mustEqual 8
    result.path mustEqual List(3, 4, 1)
  }

  it should "solve one row correctly" in {
    val result = solveOneRow(List(3), List(Solution(3, List(3)), Solution(1, List(1))))
    result mustEqual List(Solution(4, List(3, 1)))
  }

  it should "throw an exception when row size is smaller than below solution size" in {
    val caught = intercept[IllegalArgumentException] {
      solveOneRow(List(3, 4, 2), List(Solution(3, List(1, 2))))
    }
    caught.getMessage mustBe "requirement failed"
  }

  it should "solve the triangle correctly" in {
    val result = solveTriangle(List(List(7), List(2, 3), List(4, 5, 6)))
    result mustEqual Solution(13,List(7, 2, 4))
  }

  it should "run properly when existing file name is being passed" in {
    val result = Solution.run("myFile.txt").right.get
    result mustEqual Solution(18, List(7, 6, 3, 2))
  }

  it should "return a left value of Either when not existing file is passed" in {
    val caught = Solution.run("notExistingFile.txt")
    caught.left.get.messsage mustBe "We couldn't read your file properly"
  }

}
