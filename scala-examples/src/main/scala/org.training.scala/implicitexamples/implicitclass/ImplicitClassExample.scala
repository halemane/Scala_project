package org.training.scala.implicitexamples.implicitclass

/**
  * Created by Arjun on 2/11/2016.
  */
//class test extends ImplicitClass

object ImplicitClassExample extends App {
  val str = "HAL"
  //val test = new test
  import ImplicitClass._
  println(str.increment)
  println(str.hideAll)
  println(str.test(0,1))

  val i = 10
  println(i.add)
}

object ImplicitClass {
  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)
    def hideAll = s.replaceAll(".", "*")
    def test(start:Int, end:Int) = s
  }

  implicit class IntImprovements(val i:Int) {
    def add = i + 10
  }
}
