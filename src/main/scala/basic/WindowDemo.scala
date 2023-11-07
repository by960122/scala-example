package basic

/**
 * @author: BYDylan
 * @date: 2020/7/22
 * @description: 窗口
 */
object WindowDemo {
  def main(args: Array[String]) {
    val list = List(1, 2, 3, 4, 5, 6)
    val iterator: Iterator[List[Int]] = list.sliding(3, 3)
    for (result <- iterator) {
      println(result.mkString(","))
    }
  }
}
