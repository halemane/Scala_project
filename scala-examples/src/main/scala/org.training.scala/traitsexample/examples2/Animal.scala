package org.training.scala.traitsexample.examples2

/**
 * Created by hduser on 21/7/16.
 */
abstract class Animal {
  def speak
}

trait WaggingTail {
  def startTail = {println("Starting Tail")}
  def stopTail = {println("Stopping Tail")}
}

trait FourLeggedAnimal extends  Animal {
  def walk
  def run
}

class Dog extends Animal with WaggingTail with FourLeggedAnimal{

  def walk = {println("I am walking")}
  def run = {println("I am runing")}
  def speak = {println("I am barking")}
}

object DogTesting {

  def main(args: Array[String]) {

    val dog = new Dog
    dog.startTail
    dog.stopTail
  }
}