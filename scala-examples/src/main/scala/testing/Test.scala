package testing

/**
  * Created by sumantht on 5/4/2017.
  */
class mycls11 ( var x : Int, var y : Int, var z : Int ) {
  
  println("primary constructor invoked")
  // for all/three arguments

  def this(x : Int=100, y : Int = 200 ) = {
    this(x, y,300)
    println("two arguments supplied")
    println("this(x,y,300) invoked" + " auxiliary 1")
  } // for two arguments

  def this(x : Int ) = {
    this(x,2000,3000)
    println("one argument supplied")
    println("this(x,2000,3000) invoked" + " auxiliary 2")
  } // for one argument

  def this() = {
    this(500)
    println("no arguments supplied")
    println("this(500) invoked" + " auxiliary 3")
  } // for none argument

}


object auxiliary extends App {

  val obj = new mycls11(-10, -20, -30)
  println(obj.x)
  println(obj.y)
  println(obj.z)

}
