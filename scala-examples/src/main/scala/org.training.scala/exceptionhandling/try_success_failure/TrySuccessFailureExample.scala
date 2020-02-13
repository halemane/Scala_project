package org.training.scala.exceptionhandling.try_success_failure

import scala.io.Source
import scala.util.{Try,Success,Failure}

/**
  * Created by Arjun on 11/1/2016.
  */
object TrySuccessFailureExample extends App {

  def readTextFile(filename: String): Try[List[String]] = {
    Try({println("first try")
      Source.fromFile(filename).getLines.toList})
    //Try(List("scala","spark"))
  }

  //val filename = "/etc/passwd"
  val filename = "Buffering1.txt"
  readTextFile(filename) match {
    case Success(lines) => lines.foreach(println)
    case Failure(f) => println(f.getMessage)
  }
}
