package org.training.scala.read

/**
 * Created by hduser on 27/6/16.
 */
object Read {

  def main(args: Array[String]) {
    val lines = scala.io.Source.fromFile(args(0)).getLines()
    val schemaItr = for (line <- lines) yield line
    val schemaList = schemaItr.toList
    println(schemaList.length)

    val numbers = List(1, 2, 3, 4)
    val t = numbers.reduce(_ + _)
  }
}
