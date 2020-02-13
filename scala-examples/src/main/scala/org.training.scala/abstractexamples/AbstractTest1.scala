package org.training.scala.abstractexamples

/**
  * Created by sumantht on 5/24/2017.
  */

abstract class Animal {
  //val animal_name:String
  val animal_name:String
  def speak:String
  def printAnimalName = println("I am "+ animal_name)
}

class Dog extends Animal{
  val animal_name = "Dog"
  def speak = { "woof....." }
}

class Cat extends Animal {
  val animal_name = "Cat"
  def speak = { "meoww... meoww"}
}

object AbstractTest {

  def main(args: Array[String]): Unit = {

    val d = new Dog
    println(d.speak)
    d.printAnimalName

    val c = new Cat
    println(c.speak)
    c.printAnimalName
  }
}
