package org.training.scala.implicitexamples

/**
 * Created by hduser on 28/4/16.
 */

case class Address(city: String, state: String, zip: String)


class Person (var name: String, var address: Address, var age: Int) {
  override def toString = if (address == null) name else s"$name @ $address"
}

class Employee (name: String, address: Address, age: Int, company: String)
  extends Person (name, address, age)


object ExtendImplicit {

  implicit class EmployeeStatus(person: Person) {

    def isRetired = person.age > 55
  }
}

object ExtendImplicitTesting {

  def main(args: Array[String]) {

    val emp1 = new Employee("Seeta", new Address("Bangalore", "Kar", "560007"), 56, "Google")
    import ExtendImplicit._
    println(emp1.isRetired)
  }

}