package org.training.scala.companionobjects

/**
 * Created by Arjun.
  * Companion object accessing its representative class's private information
 */

class Person(val name: String, private  val superHeroName: String) /*{
  Person.tellMeSomething("test")
}*/

object Person {

  def tellMeTheSecret(x: Person) = x.superHeroName
  //private def tellMeSomething(msg:String) = println(msg)


}
object CompanionExample2 {
  def main(args: Array[String]) {
    println(args(0),args(1))
    val l = List(1,2,3,4)

    val peter = new Person("Peter Parker", "SpiderMan")

    println(Person.tellMeTheSecret(peter))
  }

}
