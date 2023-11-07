package basic

/**
 * @author: BYDylan
 * @date: 2020/7/22
 * @description: 隐式函数应当在作用域才能生效
 */
object ImplicitDemo01 {
  def main(args: Array[String]): Unit = {
    // 编写一个隐式函数转成 Double->Int 转换,我们必须保证隐式函数的匹配只能是唯一的.
    implicit def doubleToInt(d: Double): Int = {
      d.toInt
    }

    implicit def floatToInt(f: Float): Int = {
      f.toInt
    }

    val num: Int = 3.5
    val num2: Int = 4.5f
    println(s"num: ${num}")
    println(s"num2: ${num2}")

    // 编写一个隐式函数,丰富mySQL功能
    implicit def addDelete(msql: MySQL): DB = {
      new DB
    }

    val mySQL = new MySQL
    mySQL.insert()
    // 编译器工作 分析 addDelete$1(mySQL).delete()
    mySQL.delete()
    mySQL.update()
  }
}

class MySQL {
  def insert(): Unit = {
    println("insert")
  }
}

class DB {
  def delete(): Unit = {
    println("delete")
  }

  def update(): Unit = {
    println("update")
  }
}

