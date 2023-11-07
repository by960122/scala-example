package likou

/**
 * @author: BYDylan
 * @date: 2023/11/10
 * @description: 无重复字符的最长子串
 *               给定一个字符串 s ,请你找出其中不含有重复字符的最长子串的长度。
 *               示例1:
 *               输入: s = "abcabcbb"
 *               输出: 3
 *               解释: 因为无重复字符的最长子串是 "abc",所以其长度为 3
 *               解题思路: 滑动窗口
 *               其实就是一个队列,比如例题中的 abcabcbb,进入这个队列(窗口)为 abc 满足题目要求,当再进入 a,队列变成了 abca,这时候不满足要求. 所以,我们要移动这个队列！
 */
object Solution3 {
  def lengthOfLongestSubstring(content: String): Int = {
    Iterator.range(content.length - 1, -1, -1).foldLeft((0, 0)) {
      case ((result, resultIndex), index) =>
        var rightIndex = index + 1
        var leftIndex = 1
        while (rightIndex < resultIndex + index && content(index) != content(rightIndex)) {
          rightIndex += 1
          leftIndex += 1
        }
        (result.max(leftIndex), leftIndex)
    }._1
  }

  /**
   * 维护了一个128位的数组,正好覆盖ascii,这个数组的含义是：代表当前已知字符的最新位置信息,这个系统自动把重复的字符位置覆盖掉了. 这个时候,只要让 left 在这个数组里做文章就可以了
   *
   * @param content
   * @return
   */
  def lengthOfLongestSubstring2(content: String): Int = {
    var last = new Array[Int](128)
    var leftIndex = -1
    var rightIndex = 0
    for (index <- 0 until last.length) {
      last(index) = -1
    }
    for (index <- 0 until content.length) {
      leftIndex = Math.max(leftIndex, last(content(index)))
      last(content(index)) = index
      rightIndex = Math.max(rightIndex, index - leftIndex)
    }
    return rightIndex
  }
}
