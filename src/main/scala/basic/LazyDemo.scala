package basic

/**
 * @author: BYDylan
 * @date: 2020/7/22
 * @description: lazy修饰的变量在调用的时候才会执行
 */
object LazyDemo {
  def main(args: Array[String]): Unit = {
    lazy val res = sum(10, 20)
    println("先执行分割线")
    println("res=" + res)
  }

  def sum(n1: Int, n2: Int): Int = {
    println("sum() 执行了..")
    return n1 + n2
  }

}
