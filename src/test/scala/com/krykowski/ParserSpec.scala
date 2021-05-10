package com.krykowski

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

import java.io.FileNotFoundException
import scala.collection.immutable.Nil


class ParserSpec extends AnyFlatSpec with Matchers {

  "Parse" should "parse correct input" in {
    val result = Parser.parse("myFile.txt").get
    result must equal(List(List(7), List(6, 3), List(3, 8, 5), List(11, 2, 10, 9)))
  }

  it should "return empty list for empty file" in {
    val result = Parser.parse("empty.txt").get
    result must be(Nil)
  }

  it should "return error for not existing file" in {
    assertThrows[FileNotFoundException](Parser.parse("notExistingFile.txt").get)
  }

}
