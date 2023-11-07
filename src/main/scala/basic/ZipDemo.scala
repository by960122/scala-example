package basic

object ZipDemo {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1, 2, 3)
    val list2: List[Int] = List(4, 5, 6)
    val list3: List[(Int, Int)] = list1.zip(list2)
    println("list3=" + list3)

  }
}
