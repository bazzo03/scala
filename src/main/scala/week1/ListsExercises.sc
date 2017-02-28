//(1) Eliminate consecutive duplicates of list elements. If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
//  Input:     List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
//OutPut : List('a, 'b, 'c, 'a, 'd, 'e)
deleteDuplicates(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))

def deleteDuplicates(list: List[Char]) : List[Char] = {
     list match {
       case x :: y :: xs if (x == y) => deleteDuplicates(y :: xs)
       case x :: xs => List(x) ::: deleteDuplicates(xs)
       case _ => list
     }
}

//(2) Find out whether a list is a palindrome
palindrome(List('a', 'a', 'b', 'a', 'a'))

def palindrome (list: List[Char]) : Boolean = {
  list == list.reverse
}

//(3) Duplicate the elements of a list a given number of times
//  Input : duplicate(3, List('a, 'b, 'c, 'c, 'd))
//OutPut: List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

duplicate(3, List('a', 'b', 'c', 'c', 'd'))

def duplicate(n : Int, list: List[Char]) : List[Char] = {
  list.flatMap(element => List.fill(n)(element))
}


//(4) Create a function that reverses a list without using the native Scala reverse method
reverse (List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'))
reverse2 (List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'))
def reverse (list: List[Char]) : List[Char] = {
  list match {
    case Nil => list
    case _ => reverse(list.tail) ::: List(list.head)
  }
}

def reverse2 (list : List [Char]) : List[Char] = {
  list.foldLeft(List[Char]()) ((head, tail) => tail :: head)
}


//(5) Create a function that returns the sum of the odd elements from a list
sumOddElements(List(1,2,3,4,5,6,7,8,9))

def sumOddElements(list: List[Int]) : Int = {
  list.filter( x => x % 2 != 0).sum
}


//(6) Pack consecutive duplicates of list elements into sublists.
//  Input : List(1 1 1 2 2 3 1 5 5 3 3)
//OutPut : [[1 1 1] [2 2] [3] [1] [5 5] [3 3]]
packConsecutives(List(1, 1, 1, 2, 2, 3, 1, 5, 5, 3, 3))

def packConsecutives(list: List[Int]) : List[List[Int]] = {
  @annotation.tailrec
  def pack(newList: List[List[Int]], oldList: List[Int]):List[List[Int]] = oldList match {
    case Nil => newList
    case x :: xs => {
      val (applies : List[Int], theRest : List[Int]) = oldList.span((y:Int) => y == x )
      pack(newList ::: applies :: Nil, /*oldList.tail*/theRest)
    }
  }
  pack(List(List()), list)
}
