package org.training.scala.implicitexamples

import scala.math.Ordering


/**
 * Created by hduser on 29/4/16.
 */


object mergesort {

  def msortV1(xs: List[Int]): List[Int] = {
    val n = xs.length/2
    if (n == 0) xs
    else {

      def merge(xs: List[Int], ys: List[Int ]):List[Int] = xs match  {
        case List() => ys
        case x :: xs1 => ys match  {
          case List() => xs
          case y :: ys1 => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
        }
      }
      val (fst,snd) = xs splitAt(n)
      merge(msortV1(fst), msortV1(snd))
    }
  }


  def msortV2(xs: List[Int]): List[Int] = {
    val n = xs.length/2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int ]):List[Int] = (xs, ys) match  {
        case (xs, List()) => xs
        case (List(), ys) => ys
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs.splitAt(n)
      merge(msortV2(fst), msortV2(snd))
    }
  }


  def msortV3[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length/2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]):List[T] = (xs, ys) match  {
        case (xs, List()) => xs
        case (List(), ys) => ys
        case (x :: xs1, y :: ys1) =>
          if (lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs.splitAt(n)
      merge(msortV3(fst)(lt), msortV3(snd)(lt))
    }
  }

  def msortV4[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    val n = xs.length/2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]):List[T] = (xs, ys) match  {
        case (xs, List()) => xs
        case (List(), ys) => ys
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs.splitAt(n)
      merge(msortV4(fst)(ord), msortV4(snd)(ord))
    }
  }

  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length/2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]):List[T] = (xs, ys) match  {
        case (xs, List()) => xs
        case (List(), ys) => ys
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs.splitAt(n)
      merge(msort(fst), msort(snd))
    }
  }

  def main(args: Array[String]) {
    val list = List(1, -5, 2, -9, 3, 8)
    //val sortedList1 = msortV1(list)
    val sortedList2 = msortV2(list)
    val sortedList3 = msortV3(list)(_ < _)
    val words = List("one", "two", "three", "four", "six")
    val sortedWords3 = msortV3(words)(_.compareTo(_) < 0)
    val sortedList4 = msortV4(list)(Ordering[Int])
    val sortedWords4 = msortV4(words)(Ordering[String])

    sortedList4.foreach(println)
    sortedWords4.foreach(println)
    val sortedList = msort(list)
    val sortedWords = msort(words)
    sortedList.foreach(println)
    sortedWords.foreach(println)
  }
}

