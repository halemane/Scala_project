package org.training.scala.exceptionhandling.either_left_right

/**
  * Created by Arjun on 11/1/2016.
  */
object EitherLeftRightExample extends App {

  /**
    * A simple method to demonstrate how to declare that a method returns an Either,
    * and code that returns a Left or Right.
    */
  def divideXByY(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) Left(new ArithmeticException("divide by zero").getMessage)
    else Right(x / y)
  }

  // a few different ways to use Either, Left, and Right
  println(divideXByY(1, 0))
  println(divideXByY(1, 1))

  val obj = divideXByY(10,5)
  if(obj.isLeft) println("left object: "+ obj.left.get )
  else println("right object and division value is: "+obj.right.get)
  divideXByY(1, 0) match {
    case Left(s) => println("Answer: " + s)
    case Right(i) => println("Answer: " + i)
  }

}
