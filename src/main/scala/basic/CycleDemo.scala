package basic

import scala.util.control.Breaks._

object CycleDemo {
  def main(args: Array[String]): Unit = {
    // 100以内的数求和,求出当和 第一次大于20的当前数
    var sum = 0
    breakable {
      for (i <- 1 to 100) {
        sum += i
        if (sum > 20) {
          println(s"for循环实现第一次大于20的就中断,循环次数: ${i}")
          break()
        }
      }
    }

    // 除了上面的break机制来中断,我们也可以使用循环守卫实现中断
    var loop = true
    var sum2 = 0
    for (i <- 1 to 100 if loop == true) {
      sum2 += i
      if (sum2 > 20) {
        println(s"循环守卫实现第一次大于20的就中断,循环次数: ${i}")
        loop = false
      }
    }

    for (i <- 1 until 3) {
      println(s"until: ${i}")
    }

    for (i <- 1 to 3) {
      println(s"to: [${i}]");
    }

    for (i <- Range(1, 10, 2)) {
      println(s"Range: ${i}")
    }
  }
}
