package basic

import scala.collection.immutable

/** *
 *
 * @author: BYDylan
 * @date: 2023/11/6
 * @description: yield i 将每次循环得到i 放入到集合Vector中,并返回给res
 */
object YieldFor {
  def main(args: Array[String]): Unit = {
    val res: immutable.IndexedSeq[Any] = for (i <- 1 to 10) yield {
      if (i % 2 == 0) {
        i
      } else {
        s"${i}不是偶数"
      }
    }
    println(res)
    println(res.##)
  }
}
