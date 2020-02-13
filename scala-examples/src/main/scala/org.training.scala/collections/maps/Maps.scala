package org.training.scala.collections.maps

/**
  * Created by Arjun on 11/1/2016.
  */
object Maps extends App {

  val m = Map.apply((1, "One"), (2, "Two"), (3, "Three"))
  val m2 = Map((1, "One"), (2, "Two"), (3, "Three"))

  val t:(Int, String) = 3 -> "Three"
  println(t)

  val m3 = Map(1 -> "One", 2 -> "Two", 3 -> "Three")

  println(m3.get(1))
  println(m3.apply(1))
  println(m3(1))
  println(m3.get(4))
  //println(m3(4)) //Error

  println(m3.toList)
  println(m3.keys)
  println(m3.keySet)
  println(m3.values.toList)

  val s = new String("Co")
  val s2 = "Co"
  println(s == s2)
  println(s eq s2)
}
