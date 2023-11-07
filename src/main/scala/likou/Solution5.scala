package likou

/**
 * @author: BYDylan
 * @date: 2023/11/13
 * @description: 最长回文子串 给你一个字符串 s,找到 s 中最长的回文子串。 示例 1： 输入：s = "babad" 输出："bab" 解释："aba" 同样是符合题意的答案
 */
class Solution5 {
  def longestPalindrome(s: String): String = {
    if (s == null || s.length < 2) {
      return s
    }
    var tmp = "#"
    for (i <- s.indices) {
      tmp += s.charAt(i)
      tmp += "#"
    }
    var n = tmp.length
    var start = 0
    var max = 0
    // 从左到右遍历处理过的字符串, 求每个字符的回文半径
    for (i <- tmp.indices) {
      // 计算当前以i 为中心的回文半径
      var cur = expand(tmp, i, i)
      // 如果当前计算的半径大于max, 就更新start(原始字符的起始位置)
      if (cur > max) {
        max = cur
        start = (i - cur) / 2
      }
    }
    // 根据start和max, 从原始字符串中截取一段返回
    return s.substring(start, start + max)
  }

  // 以left和right为起点, 计算回文半径, 由于while循环退出后left和right各多走了一步
  // 所以在返回的总长度时要减去2
  def expand(s: String, _left: Int, _right: Int): Int = {
    var left = _left
    var right = _right
    while (left >= 0 && right < s.length && s.charAt(left) == s.charAt(right)) {
      left -= 1
      right += 1
    }
    return (right - left - 2) / 2
  }
}
