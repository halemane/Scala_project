package org.training.scala.companionobjects

/**
 * Created by Arjun.
  * Class accessing companion object's private information
 */
class SecretAgent(val name: String) {

  def shoot(n: Int) = {
    SecretAgent.decrementBullet(n)
  }

}

object  SecretAgent {

  private var b = 3000

  private  def decrementBullet(count: Int) ={
    if (b - count <= 0) b = 0
    else b = b - count
  }

  def bullets = b

}

object CompanionExample1 {

  def main(args: Array[String]) {

    val bond = new SecretAgent("James Bond")
    val bourne = new SecretAgent("Jason Bourne")
    val boss = new SecretAgent("Rajanikanth")
    bond.shoot(100)
    bourne.shoot(500)
    boss.shoot(1)

    println(SecretAgent.bullets)
  }
}
