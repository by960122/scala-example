package basic

object ConstructorDemo {
  def main(args: Array[String]): Unit = {
    val a = new AA("jack")
  }
}

class BB() {
  println("1.父类")
}

class AA() extends BB() {
  println("2.主构造器")

  def this(name: String) {
    this
    println("3.this:辅助构造器")
  }
}
