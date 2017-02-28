package week1

import cats.Functor
import cats.implicits._
import cats.kernel.{Monoid, Semigroup}

/**
  * Created by Daniel on 1/17/2017.
  */
object Main extends App {
  override def main(args: Array[String]): Unit = {

    /*
    println(Semigroup[Int].combine(1, 2))
    println(Semigroup[List[Int]].combine(List(1, 2, 3), List(4, 5, 6)))
    println(Semigroup[Option[Int]].combine(Option(1), Option(2)))
    println(Semigroup[Option[Int]].combine(Option(1), None))
    println(Semigroup[Int ⇒ Int].combine({ (x: Int) ⇒ x + 1 }, { (x: Int) ⇒ x * 10 }).apply(6))


    print (Monoid[Map[String, Int]].combineAll(List(Map("a" → 1, "b" → 2), Map("a" → 3))))
    print (Monoid[Map[String, Int]].combineAll(List()))*/

    val source = List("Cats", "is", "awesome")
    val product = Functor[List].fproduct(source)(_.length).toMap

    print (product.get("Cats").getOrElse(0))

  }


}