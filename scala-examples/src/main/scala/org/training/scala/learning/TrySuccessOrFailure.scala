package org.training.scala.learning

import scala.io.Source
import scala.util.{Failure, Success, Try}

object TrySuccessOrFailure extends  App{

  def readFileData(path:String): Try[List[String]] = {
    Try {
      val contentList = Source.fromFile(path).getLines().toList
      contentList
    }
  }
    readFileData("C:\\Users\\p.hanumantharayapp\\Desktop\\Training\\purchase_data1.csv") match {
      case Success(l) => l.foreach(println)
      case Failure(exception: Exception) => println(exception.getMessage)//println calls toString method on exception object i.e exception.toString
    }
}
