package org.training.scala.genericclasses

/**
  * Created by sumantht on 5/24/2017.
  */

class EvaluateGenericArray[A](inputArray: Array[A]) {
  def printGenericArray = {
    for(ele <- inputArray) println(ele)
  }
}

class Test(t1: (String,Int,Double)) {
  println(t1._1)
  println(t1._2)
  println(t1._3)
}

object GenericArray {

  def main(args: Array[String]): Unit = {
    val intArrObj = new EvaluateGenericArray[Int](Array(1,2,3,4))
    intArrObj.printGenericArray

    val doubleArrObj = new EvaluateGenericArray(Array(12.5,24.5,89.78))
    doubleArrObj.printGenericArray

    val stringArrObj = new EvaluateGenericArray(Array("scala", "spark", "bigdata"))
    stringArrObj.printGenericArray

    val t1 = new Test(("scala", 10, 10.5))
  }

}
