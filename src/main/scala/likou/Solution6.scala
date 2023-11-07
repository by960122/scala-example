package likou

/**
 * @author: BYDylan
 * @date: 2023/11/13
 * @description: @description: N 字形变换 将一个给定字符串 s 根据给定的行数 numRows ,以从上往下、从左到右进行Z 字形排列。
 *               比如输入字符串为 "PAYPALISHIRING"行数为 3 时,排列如下：
 *               P   A   H   N
 *               A P L S I I G
 *               Y   I   R
 *               之后,你的输出需要从左往右逐行读取,产生出一个新的字符串,比如："PAHNAPLSIIGYIR"。
 *               示例 1：
 *               输入：s = "PAYPALISHIRING", numRows = 3
 *               输出："PAHNAPLSIIGYIR"
 */
object Solution6 {
  def convert(content: String, numRows: Int): String = {
    if (numRows == 1) {
      return content
    }
    import scala.collection.mutable.ListBuffer
    val rows: ListBuffer[StringBuilder] = new ListBuffer[StringBuilder]()
    for (index <- 0 until (numRows)) {
      rows.append(new StringBuilder())
    }
    var curRow = 0;
    var flag = -1;
    for (char <- content.toCharArray) {
      rows(curRow).append(char)
      if (curRow == 0 || curRow == numRows - 1) {
        flag = -flag
      }
    }
    val result = new StringBuilder()
    for (row <- rows) {
      result.append(row)
    }
    return result.toString()
  }
}
