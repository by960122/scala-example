package likou

/**
 * @author: BYDylan
 * @date: 2023/11/14
 * @description: 整数反转 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。 假设环境不允许存储 64
 *               位整数（有符号或无符号）。 示例 1： 输入：x = 123 输出：321 示例 2： 输入：x = -123 输出：-321
 *               解法: https://leetcode.cn/problems/reverse-integer/solutions/427964/zheng-shu-fan-zhuan-by-tiankonghewo-2/
 */
object Solution7 {
  def reverse(content: Int): Int = {
    val it: Iterator[Int] = digits(content).toIterator
    var sum = 0
    var flag = true
    while (flag && it.hasNext) {
      val value: Int = it.next()
      value match {
        case y if sum > Int.MaxValue / 10 => flag = false
        case y if sum < Int.MinValue / 10 => flag = false
        case y if sum == Int.MaxValue / 10 && y > 7 => flag = true
        case y if sum == Int.MinValue / 10 && y < -8 => flag = true
        case y => sum = sum * 10 + y
      }
    }
    if (flag) {
      sum
    } else {
      0
    }
  }

  def digits(input: Int): List[Int] = {
    var nil: List[Int] = Nil
    var y: Int = input
    while (y != 0) {
      nil :+= y % 10
      y /= 10
    }
    nil
  }
}
