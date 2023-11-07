package basic

/**
 * @author: BYDylan
 * @date: 2020/7/22
 * @description: 注意括号方向
 */
object FoldDemo {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 9)
    println(s"list4: $list")

    // (1 - 1) - 9
    var i6 = list.foldLeft(1)(minus)
    println("i6=" + i6)

    // (100 - 1) - 9
    i6 = list.foldLeft(100)(minus)
    println(i6)

    // (1 - (9 - 10))
    i6 = list.foldRight(10)(minus)
    println(i6)
  }

  def minus(num1: Int, num2: Int): Int = {
    num1 - num2
  }
}
