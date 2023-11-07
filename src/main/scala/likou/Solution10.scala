package likou

/**
 * @author: BYDylan
 * @date: 2023/11/22
 * @description: @description: 给你一个字符串 s 和一个字符规律 p, 请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 *               '.' 匹配任意单个字符 '*' 匹配零个或多个前面的那一个元素 所谓匹配, 是要涵盖 整个 字符串 s的, 而不是部分字符串。
 *
 *               示例 1： 输入：s = "aa", p = "a" 输出：false 解释："a" 无法匹配 "aa" 整个字符串。
 *               解法: https://leetcode.cn/problems/regular-expression-matching/solutions/1755709/scala-dong-tai-gui-hua-by-yhm138_-nql4/
 */
class Solution10 {
  def isMatch(content: String, pattern: String): Boolean = {
    var m = content.length;
    var n = pattern.length;

    var f = Array.fill(m + 1)(Array.fill(n + 1)(false));
    f(0)(0) = true;
    for (i <- Range(0, m + 1, 1)) {
      for (j <- Range(1, n + 1, 1)) {
        if (pattern.charAt(j - 1) == '*') {
          f(i)(j) = f(i)(j - 2);
          if (matches(content, pattern, i, j - 1)) {
            f(i)(j) = f(i)(j) || f(i - 1)(j);
          }
        } else {
          if (matches(content, pattern, i, j)) {
            f(i)(j) = f(i - 1)(j - 1);
          }
        }
      }
    }
    return f(m)(n);
  }

  def matches(s: String, p: String, i: Int, j: Int): Boolean = {
    if (i == 0) {
      return false;
    }
    if (p.charAt(j - 1) == '.') {
      return true;
    }
    return s.charAt(i - 1) == p.charAt(j - 1);
  }

}
