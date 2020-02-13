package org.training.scala.implicitexamples

/**
 * Created by hduser on 28/4/16.
 */


/**
 * Created by Arjun on 6/4/16.
  *  //Ordered is a triat which has some comparsion functions
 */
class Rational(val n: Int, val d : Int) extends Ordered[Rational]{


  require(d != 0, "denominator should not be zero")

  private val g = gcd(n.abs, d.abs)

  def this(n: Int) = this(n, 1)
  //def this(n: Long) = this(n.toInt, 1)

  override def toString = n/g +"/"+ d/g

  def + (that: Rational) =
    new Rational(n * that.d + that.n * d, d * that.d)

  def + (i: Int): Rational =
    new Rational(n + i * d, d)

  def - (that: Rational): Rational =
    new Rational(
      n * that.d - that.n * d,
      d * that.d
    )

  def - (i: Int): Rational =
    new Rational(n - i * d, d)



  def * (that: Rational): Rational =
    new Rational(n * that.n, d * that.d)

  def * (i: Int): Rational =
    new Rational(n * i, d)

  def / (that: Rational): Rational =
    new Rational(n * that.d, d * that.n)

  def / (i: Int): Rational =
    new Rational(n, d * i)

  /*
    def < (that: Rational) =
      this.n * that.d < that.n * this.d
  */

  def max(that: Rational) =
    if(this < that) that else this

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)


  def compare(that: Rational) =
    (this.n * that.d) - (that.n * this.d)

}


object Rational1 {

  implicit def test(x: Int): Rational = new Rational(x)
  //implicit def abc(y: Long): Rational = new Rational(y)
  //implicit def abc(x: Long): Rational = new Rational(x)
}

object TestingRational {

  def main(args: Array[String]) {

    val l = scala.collection.mutable.ArrayBuffer
    val r1 = new Rational(1, 2)  //r1 = 1/2
    val r2 = new Rational(1, 4)  //r2 = 1/4
    val r3 = r1 + r2   // r1 + r2   3/4  r3.n = 3 and r3.d = 4   r1.+(r2)
    val r4 = r1 - r2
    val r5 = r1 * r2    // ::
    val r6 = r1 / r2
    val r7 = r1 * 2
    val r8 = r1 + 1
    val r9 = r1 - 1
    import Rational1._
    val r = 1 + r1


    val a  = 10
    val z  = 1 +(r1)
    val r10 = a + r1    // Similar to  1.+(r1)  a.+(r1)
    //val r11 = 4.5 + r1
    //val r11 = 10L + r1    // Similar to  1.+(r1)

    println(r1 == r2)
    println(r2 < r1)
    println(r1.max(r2).toString)
    println(" r1: " + r1.toString)
    println(" r2: " + r2.toString)
    println(" r3: " + r3.toString)
    println(" r4: " + r4.toString)
    println(" r5: " + r5.toString)
    println(" r6: " + r6.toString)
    println(" r7: " + r7.toString)
    println(" r8: " + r8.toString)
    println(" r9: " + r9.toString)
    println(" r10: " + r10.toString)
  }
}
