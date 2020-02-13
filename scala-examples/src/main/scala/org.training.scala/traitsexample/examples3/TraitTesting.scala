package org.training.scala.traitsexample.examples3

import java.io.PrintWriter
import java.util.Date

/**
 * Created by hduser on 6/9/16.
 */

trait Logged  {

  def log(msg: String) = {}
}


trait FileLogger extends  Logged {
  override def log(msg: String) = {

    println("Writing to a file")
    new PrintWriter("fileLogger.txt") { write(msg); close }
  }
}

trait ConsoleLogger extends Logged {
  override def log(msg: String) = {println(msg)}
}


trait TimestampLogger extends  Logged {

  override def log(msg: String) = {

    println("TimestampLogger")
    super.log(new Date() + " " + msg)
  }
}

trait  ShortLogger extends  Logged {
  var maxLength = 15

  override def log(msg: String) = {
    println("ShortLogger")
    super.log{
      if (msg.length <= maxLength) msg
      else msg.substring(0, maxLength - 3) + "..."
    }
  }
}

class SavingsAccount extends Logged {

  var balance: Double = 0.0

  def withdraw(amount: Double) = {

    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }
}

object TraitTesting {

  def main(args: Array[String]) {

    val acc1 = new SavingsAccount with ConsoleLogger with FileLogger
    acc1.withdraw(500.0)
    val acc2 = new SavingsAccount with FileLogger with ConsoleLogger
    acc2.withdraw(500.0)

    val acc3 = new SavingsAccount with ConsoleLogger with TimestampLogger with ShortLogger {
      maxLength = 20
    }

    acc3.withdraw(500.0)
  }

}
