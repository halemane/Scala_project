package org.training.scala.implicitexamples
//import implicits_1._
/**
  * Created by sumantht on 6/1/2017.
  */

object implicits_1 {
  implicit def doubleToInt(d : Float):Int = {
    println("entered implicit conversion method")
    d.toInt
  }
}

object ImplicitDefs {

  def main(args: Array[String]): Unit = {

  import implicits_1._
    val a : Int = 3.5f

    println(a)
  }

}
