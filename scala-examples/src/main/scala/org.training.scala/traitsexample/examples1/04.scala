package org.training.scala.traitsexample.examples1

trait ConsoleLogger extends Logger {

	override def log(msg: String) = {  // Conflicting log method hence overridden
		println("ConsoleLogger")
		Console.println(msg)
	}


}


trait FileLogger extends Logger {

	override  def log(msg: String) = {                         // Conflicting log method hence overridden
		println("Logging " + msg + " to File")
	}
}


class Sample extends Logger {

	def log(msg: String) = { println(msg)}

	def doSomeWork() = {
		log("Some Log Message")
	}
}


object LoggerTesting {

	def main(args: Array[String]) {

		  val x1:Sample = new Sample
		  x1.doSomeWork()

			println()
		  val x = new Sample with ConsoleLogger
		  x.doSomeWork

	 	  println()
		  val y = new Sample  with FileLogger with ConsoleLogger
		  y.doSomeWork

		  println()
		  val z = new Sample with ConsoleLogger with FileLogger
		  z.doSomeWork
	}

}


