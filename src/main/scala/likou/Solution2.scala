package likou

/**
 * @author: BYDylan
 * @date: 2023/11/9
 * @description: 两数相加
 *               给你两个非空 的链表,表示两个非负的整数. 它们每位数字都是按照逆序的方式存储的,并且每个节点只能存储一位数字.
 *               请你将两个数相加,并以相同形式返回一个表示和的链表.
 *               你可以假设除了数字 0 之外,这两个数都不会以 0开头
 *               输入：l1 = [2,4,3], l2 = [5,6,4]
 *               输出：[7,0,8]
 *               解释：342 + 465 = 807.
 */
object Solution2 {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = (l1, l2) match {
    case (l1, null) => l1
    case (null, l2) => l2
    case (_, _) =>
      val d: Int = (l1.x + l2.x) / 10
      val r: Int = (l1.x + l2.x) % 10
      var result = new ListNode(r)
      val next = if (d > 0) {
        addTwoNumbers(new ListNode(1), addTwoNumbers(l1.next, l2.next))
      } else {
        addTwoNumbers(l1.next, l2.next)
      }
      result.next = next
      result
  }
}
