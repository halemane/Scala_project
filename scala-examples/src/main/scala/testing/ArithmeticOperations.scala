package testing

/**
  * Created by sumanth on 12/9/2017.
  */
class ArithmeticOperations(a:Int, b:Int) {
  def add = a + b
  def subtract = a - b
  def multiplication = a * b
  def modulus = a % b
}

object ArithmeticOperationsRun extends App {
  val obj = new ArithmeticOperations(10,15)
  println(obj.add)
  println(obj.subtract)
  println(obj.multiplication)
  println(obj.modulus)
}
