package org.training.scala.learning

object OptionSomeNoneArithException extends App{
def divisible(num:Int,den:Int):Option[Boolean]={
  if(den!=0) Some(if((num%den)==0) true else false)
  else None
}
  val op=divisible(10,0)
  op match {
    case Some(x)=> println(x)
    case _ =>println("division by zeo!!!")
  }

  //println(op.getOrElse("division by zeo!!!"))
}
