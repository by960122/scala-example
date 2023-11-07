package basic

import scala.collection.immutable

object ScanDemo {
  def main(args: Array[String]): Unit = {
    /*
    5
    5 - 1 = 4
    4 - 2 = 2
    2 - 3 = -1
    -1- 4 = -5
    -5- 5 = -10
     */
    val i8: immutable.IndexedSeq[Int] = (1 to 5).scanLeft(5)(minus)
    println("i8=" + i8)
    /*/
    5
    5 + 5 = 10
    10 +4 = 14
    14 +3 = 17
    17 +2 = 19
    19 +1 = 20
     */
    val i9: immutable.IndexedSeq[Int] = (1 to 5).scanRight(5)(add)
    println("i9=" + i9)
  }

  def minus(num1: Int, num2: Int): Int = {
    num1 - num2
  }

  def add(num1: Int, num2: Int): Int = {
    num1 + num2
  }
}
