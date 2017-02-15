import chapter6.{RNG, SimpleRNG}

object Exercise {

  //6.2
  def double(rng: RNG): (Double, RNG) = {
    val (x: Int, y: RNG) = rng.nextInt
    val z: Double = x.toDouble / (Int.MaxValue + 1).toDouble
    if (z >= 1.0){
      val w = ((x.toDouble / z) / Int.MaxValue.toDouble)
      (w , y)
    }
    else
    (z, y)
  }

  val c = SimpleRNG(Long.MaxValue)
  double (c)


  //6.4
  def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
    @annotation.tailrec
    def loop (n : Int, list : List[Int], rng2 : RNG) : (List[Int], RNG) = {
      val (x : Int, y : RNG) = rng2.nextInt
      if (n > 0 ) {
        loop (n-1, x::list, y)
      } else {
        (list, y)
      }
    }
    loop (count, List(), rng)
  }


  val d = SimpleRNG(Long.MaxValue)
  ints (4) (d)

  type Rand[+A] = RNG => (A, RNG)

  def map2[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = {
    rng => {
      val (x, rng2) = ra(rng)
      val (x2, rng3) = rb (rng2)
      (f(x, x2) -> rng3)
    }
  }


}


