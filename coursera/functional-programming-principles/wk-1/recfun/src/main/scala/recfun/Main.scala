package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {

      def loop(c:Int, r:Int) : Int = {
        if(c == 0 ||  r == c) 1
        else loop(c - 1, r - 1) + loop(c, r - 1)
      }

      loop(c,r)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def isBalanced(a: List[Char], i:Int = 0, count:Int = 0) : Boolean = {
        if(i == a.length) return count == 0
        if(count < 0) return false
        if(a(i) == '(') return isBalanced(a, i + 1, count + 1)
        else if(a(i) == ')') return isBalanced(a, i + 1, count - 1)

        isBalanced(a, i + 1, count)

      }
      isBalanced(chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def countChangeLoop(money: Int, coins: List[Int]) =
        if (money == 0) 1
        else if (money > 0 && coins.nonEmpty)
          countChange(money - coins.head, coins) + countChange(money, coins.tail)
        else 0

      countChangeLoop(money, coins)
    }
  }

