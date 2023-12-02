package designpatterns.chain_of_responsibility

/**
 * @author: BYDylan
 * @date: 2019/11/28
 * @description: 职责链模式
 */


/**
 * 审批对象
 *
 * @param amount  金额
 * @param number  编号
 * @param purpose 采购目的
 */
case class PurchaseRequest(amount: Double, number: Int, purpose: String)


/**
 * 抽象处理者，审批者类
 *
 * @param name 审批人姓名
 */
abstract class Approve(name: String) {

  /**
   * 定义后继对象
   */
  protected var successor: Approve = _

  /**
   * 设置后继对象
   *
   * @param approve 审批者类
   */
  def setSuccessor(approve: Approve) = successor = approve

  /**
   * 抽象处理审批请求方法
   *
   * @param request 审批对象
   */
  def processRequest(request: PurchaseRequest): Unit
}

/**
 * 主任类
 *
 * @param name 审批人姓名
 */
class Director(name: String) extends Approve(name) {
  override def processRequest(request: PurchaseRequest) = request.amount match {
    case x: Double if x < 50000 =>
      println(s"主任$name 审批采购单: " + request.number + ",金额: " + request.amount + "元，采购目的: " + request.purpose)
    case _ => this.successor.processRequest(request)
  }
}

/**
 * 副董事长类
 *
 * @param name 审批人姓名
 */
class VicePresident(name: String) extends Approve(name) {
  override def processRequest(request: PurchaseRequest) = request.amount match {
    case x: Double if x < 100000 =>
      println(s"副董事长$name 审批采购单: " + request.number + ",金额: " + request.amount + "元，采购目的: " + request.purpose)
    case _ => this.successor.processRequest(request)
  }
}

/**
 * 董事长类
 *
 * @param name 审批人姓名
 */
class President(name: String) extends Approve(name) {
  override def processRequest(request: PurchaseRequest) = request.amount match {
    case x: Double if x < 500000 =>
      println(s"董事长$name 审批采购单: " + request.number + ",金额: " + request.amount + "元，采购目的: " + request.purpose)
    case _ => this.successor.processRequest(request)
  }
}

/**
 * 董事会类
 *
 * @param name 审批人姓名
 */
class Congress(name: String) extends Approve(name) {
  override def processRequest(request: PurchaseRequest) =
    println("召开董事会审批采购单: " + request.number + ",金额: " + request.amount + "元，采购目的: " + request.purpose)
}

/**
 * 测试客户端
 * Created by ctao on 2015/8/30.
 */
object Client extends App {
  val ZH: Approve = new Director("周华")
  val YJY: Approve = new VicePresident("游建友")
  val WZX: Approve = new President("吴志雄")
  val meeting: Approve = new Congress("董事会")
  ZH.setSuccessor(YJY)
  YJY.setSuccessor(WZX)
  WZX.setSuccessor(meeting)
  ZH.processRequest(PurchaseRequest(45000, 1001, "大数据卡口项目"))
  ZH.processRequest(PurchaseRequest(60000, 1002, "服务器购置"))
  ZH.processRequest(PurchaseRequest(145000, 1003, "星环开科技专利购买"))
  ZH.processRequest(PurchaseRequest(1145000, 1004, "公司并购"))

}