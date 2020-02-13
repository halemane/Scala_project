package org.training.scala.companionobjects.factorypattern

/**
  * Created by sumanth on 7/29/2017.
  * Create a factory that produces animals like Cat, Dog etc
  */

trait Animal {
  def speak
}

object Animal {

  private class Dog extends Animal {
    override def speak { println("woof") }
  }

  private class Cat extends Animal {
    override def speak { println("meow") }
  }

  // my preferred factory method
  def apply(s: String):Animal = {
    if (s == "dog") return new Dog
    else return new Cat
  }

  // an alternative factory method (use one or the other)
  def getAnimal(s: String):Animal = {
    if (s == "dog") return new Dog
    else return new Cat
  }

}

object FactoryPatternExample extends App {

  val dog = Animal("dog")
  dog.speak

  val cat = Animal("cat")
  cat.speak

  println()

  Animal.getAnimal("dog").speak
  Animal.getAnimal("cat").speak

}
