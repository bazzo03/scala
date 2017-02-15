import week1.Exercise_6_11.{Coin, Input, Machine, Turn}

def operate() : Machine = {
  val m : Machine = Machine(true, 10, 5)
//  simulateMachine(m, List(Coin, Turn, Coin, Turn, Coin, Turn, Coin, Turn, Coin, Turn))
//  simulateMachine(m, List(Coin, Turn))
  simulateMachine(m, List(Coin, Turn, Coin, Coin))
}


def simulateMachine(oldMachine : Machine, inputs: List[Input]): Machine = {
  inputs match {
    case Nil => oldMachine
    case x :: xs => {
      val newMachine: Machine = oldMachine.operateMachine(x)
      simulateMachine(newMachine, xs)
    }
  }
}

operate()