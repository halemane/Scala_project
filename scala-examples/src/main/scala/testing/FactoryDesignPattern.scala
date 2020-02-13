package testing

/**
  * Created by sumantht on 5/30/2017.
  */
trait Animal {
  def speak
}

object Animal {

  private class Dog extends Animal {
    def speak = println("Dog speaks - woof")
  }

  private class Cat extends Animal {
    def speak = println("Cat speaks - meow")
  }

  def apply(name:String) : Animal = {
    if(name == "dog") new Dog
    else new Cat
  }

  def getAnimalInstance(name:String) : Animal = {
    if(name == "dog") new Dog
    else new Cat
  }
}

object FactoryDesignPattern extends App {

  val dogObj1 = Animal("dog")
  val dogObj2 = Animal.apply("dog")

  println()

  val catObj1 = Animal("cat")
  val catObj2 = Animal.apply("cat")

  println()

  val dogObj3 = Animal.getAnimalInstance("dog")
  val catObj3 = Animal.getAnimalInstance("cat")

}
