package week1.Exercise_6_11


trait RNG {
  def nextInt: (Int, RNG)
}

case class SimpleRNG(seed: Long) extends RNG {
  def nextInt: (Int, RNG) = {
    val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
    val nextRNG = SimpleRNG(newSeed)
    val n = (newSeed >>> 16).toInt
    (n, nextRNG)
  }

  type Rand[+A] = RNG => (A, RNG)

}

/**
  * RULES:
  * - Inserting a coin into a locked machine will cause it to unlock if there’s anycandy left.
  * - Turning the knob on an unlocked machine will cause it to dispense candy andbecome locked.
  * - Turning the knob on a locked machine or inserting a coin into an unlocked machine does nothing.
  * - A machine that’s out of candy ignores all inputs.
  */

trait Input

case object Coin extends Input

case object Turn extends Input

case class State[S,+A](run: S => (A,S))

case class  Machine (locked : Boolean, candies : Int, coins : Int) {
  type State[S,+A] = S => (A,S)
  type Rand[A] = State[RNG, A]

  def operateMachine (input: Input) : Machine = {
    input match {
      case Coin => if (candies > 0 && locked)  Machine(false, this.candies, this.coins + 1) else this
      case Turn => if (candies > 0 && !locked) Machine(true, this.candies - 1, this.coins) else this
      case _ => this
    }
  }








}
