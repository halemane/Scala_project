package org.training.scala.exceptionhandling.option_some_none

/**
  * Created by Arjun on 11/1/2016.
  */
object OptionSomeNoneExample extends App {

  def toInt(in: String): Option[Int] = {
    try {
      Some(Integer.parseInt(in.trim))
    } catch {
      case e: NumberFormatException => None
    }
  }

  val someString = "100a"
  toInt(someString) match {
    case Some(i) => println(i)
    case None => println("Conversion didn't work.")
  }

}
