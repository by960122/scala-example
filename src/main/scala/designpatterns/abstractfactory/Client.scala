package designpatterns.abstractfactory

/**
 * @author: BYDylan
 * @date: 2019/11/28
 * @description: 抽象工厂调用
 */
object Client extends App {
  val factory: SkinFactory = SpringSkinFactory
  factory.createButton().display()
  factory.createTextField().display()
}
