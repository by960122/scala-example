package basic

/** *
 *
 * @author: BYDylan
 * @date: 2020/7/22
 * @description: 使用apply方法来创建对象
 */
object ApplyDemo {
  def main(args: Array[String]): Unit = {
    val pig2 = Pig("小黑猪")
    val pig3 = Pig()
    println(s"pig2.name=${pig2.name}")
    println(s"pig3.name=${pig3.name}")
  }
}

class Pig(pName: String) {
  var name: String = pName
}

object Pig {
  def apply(pName: String): Pig = new Pig(pName)

  def apply(): Pig = new Pig("匿名猪猪")
}
