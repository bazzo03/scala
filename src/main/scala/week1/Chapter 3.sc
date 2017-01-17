
/*
sealed trait List[+A]
case class Cons[+A](head: A, tail: List[A]) extends List[A]
case object Nil extends List[Nothing]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y //primera opcion viable
    case Cons(h, t) => h + sum(t)
    case _ => 101
  }
}
*/

object Exercise {

  reverseList(List(1,2,3,4,5))
  reverseList(List(1,4,5,6))
  reverseList(List())

  reverseList2(List(1,2,3,4,5))
  reverseList2(List(1,4,5,6))
  reverseList2(List())

//  @annotation.tailrec
  def reverseList(list : List[Int]) : List[Any] = {
    list match {
      case Nil => list
      case (x :: xs) => reverseList(xs) ::: List(x)
    }
  }

  def reverseList2(list : List[Int]) : List[Any] = {
  @annotation.tailrec
    def reverseIntern(list: List[Int], newOne: List[Int]): List[Int] = {
      list match {
        case Nil => newOne
        case (x :: xs) => reverseIntern(xs, List(x):::newOne)
      }
    }
  reverseIntern(list, List())
  }
}
