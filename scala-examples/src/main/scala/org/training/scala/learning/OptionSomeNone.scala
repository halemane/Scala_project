package org.training.scala.learning

/* there are 3 ways of extracting the value from some
1. using get method
2. using getOrElse
3. match expression
 */



object OptionSomeNone {
  def convertToUpperCase(x: String): Option[String] = {
    if (x != null) Some(x.toUpperCase)
    /* val s=Some(x.toUpperCase)
    s*/
    else None
  }
  def main(args: Array[String]): Unit = {
    val s=args(0)
    println(convertToUpperCase(s).get)
    //1st way
    val s1 = args(1)
    println(convertToUpperCase(s1).getOrElse("not possible")) //2nd way

    val s2=args(2)
    val out=convertToUpperCase(s2)
    out match {                                            //3rd way
      case Some(x)=> println("the output is "+x)
      case None=>println("The output is not available")
    }

  }
}
