package designpatterns.abstractfactory

/**
 * @author: BYDylan
 * @date: 2019/11/28
 * @description: 抽象工厂
 */
class AbstractFactory1 {
}


trait Button {
  def display(): Unit
}

trait TextField {
  def display(): Unit
}

trait SkinFactory {
  def createButton(): Button

  def createTextField(): TextField
}

object SpringSkinFactory extends SkinFactory {

  override def createButton(): Button = new SpringButton

  override def createTextField(): TextField = new SpringTextField

  class SpringButton extends Button {
    override def display(): Unit = println("spring button")
  }

  class SpringTextField extends TextField {
    override def display(): Unit = println("spring textField")
  }
}

object SummerSkinFactory extends SkinFactory {

  override def createButton(): Button = new SummerButton

  override def createTextField(): TextField = new SummerTextField

  class SummerButton extends Button {
    override def display(): Unit = println("summer button")
  }

  class SummerTextField extends TextField {
    override def display(): Unit = println("summer textField")
  }
}
