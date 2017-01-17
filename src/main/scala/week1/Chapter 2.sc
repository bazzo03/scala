object exercise {

  isSorted(Array(3,2,2,1,0), ordered)
  isSorted(Array(1,2,2,3,4), ordered)

  def ordered(x:Int, y:Int) : Boolean = x >= y

  /* */
//  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
//    var answer = true
//    for (i <- 0 to (as.length - 2) ) {
//      if (!ordered(as(i), as(i+1))) {
//        answer = false
//      }
//    }
//    answer
//  }



  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {

    def cicle(i: Int): Boolean = {
      if (i < as.length - 1) {
        if (ordered(as(i), as(i + 1)))
          cicle(i + 1)
        else
          false
      } else {
        true
      }
    }
    cicle(0)
  }

  /* */
  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
  (a:A) => ((b:B) => f(a, b))

  curry(ordered)(2)(1)

  /* */
  def compose[A,B,C](f: B => C, g: A => B): A => C =
  (a:A) => f(g(a))



}