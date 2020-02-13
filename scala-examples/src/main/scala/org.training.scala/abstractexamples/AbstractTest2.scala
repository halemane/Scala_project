package org.training.scala.abstractexamples

/**
  * Created by sumantht on 5/24/2017.
  */

abstract class Currency {
  val amount:Long
  def designation:String
  override def toString: String = amount + " " + designation
}

abstract class Dollar extends Currency {
  def designation = "USD"
}

abstract class Euro extends Currency {
  override def designation: String = "Euro"
}

object AbstractTest2 extends App{
  val d = new Dollar { val amount = 92l}
  val e = new Euro { val amount = 67l}
  val d1 = new Dollar {
    override val amount: Long = 1000000
    override def designation: String = "test"
  }
  println(d)
  println(e)
  println(d1)
}
