package org.training.scala.learning

object EitherLeftOrRight extends App {

  def divideXbyY(x:Int,y:Int):Either[String,Int]= {
    if(y!=0) Right(x/y) else Left("division by zero")
  }

  def divideXbyY1(x:Int,y:Int):Either[ArithmeticException,Int]= {
    try{
      Right(x/y)
    } catch {
      case e:ArithmeticException => Left(e)
    }
  }

  val op=divideXbyY(9,2)
  /* two ways of extracting the data from Either Left Right
  1st way is match expression
  2nd way is built in methods
   */
  op match {
    case Right(x) => println(x)
    case Left(y) => println(y)
  }

  val op1=divideXbyY(34,0)
  if (op1.isRight) println(op1.right.get) else println(op1.left.get)

  val op3=divideXbyY1(20,0)
  op3 match {
    case Left(a)=>println(a)
    case Right(b) => println(b)
  }

  def accEle(x:Array[Int]):Either[Exception,Int]={
    try {
       Right(x(10)+10)
    } catch {
      case e:IndexOutOfBoundsException => Left(e)
    }

  }
  
}
