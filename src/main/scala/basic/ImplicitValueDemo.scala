package basic

/** *
 *
 * @author: BYDylan
 * @date: 2023/11/6
 * @description: 隐式转换
 *               1. 当在程序中,同时有 隐式值,默认值,传值
 *                  2. 编译器的优先级为 传值 > 隐式值 > 默认值
 *                  3. 在隐式值匹配时,不能有二义性
 *                  4. 如果三个 （隐式值,默认值,传值） 一个都没有,就会报错
 */
object ImplicitValueDemo {
  def main(args: Array[String]): Unit = {
    // implicit val name1: String = "World"

    // hello1("传值")

    // hello2

    // 当一个隐式参数匹配不到隐式值,仍然会使用默认值
    // implicit val name: Int = 10
    // hello3

    // hello4
  }

  def hello1(implicit content: String = "jack"): Unit = {
    println("Hello1: " + content)
  }

  // 当同时有implicit 值和默认值,implicit 优先级高
  def hello2(implicit content: String = "jack"): Unit = {
    println("Hello2: " + content)
  }

  def hello3(implicit content: String = "jack"): Unit = {
    println("Hello3: " + content)
  }

  // 当没有隐式值,没有默认值,又没有传值,就会报错
  def hello4(implicit content: String): Unit = {
    println("Hello4: " + content)
  }
}

