package org.training.scala.closures

class Foo(x:Int) {
  def bar(y:Int => Int) = y(x)
}

/**
  * Created by Arjun on 11/1/2016.
  */
object Closures extends App {
  val m = 200
  //val f:Int => Int = (x:Int) => x + m
  val f = (x:Int) => x + m
  val foo = new Foo(100)
  println(foo.bar(f))
}
