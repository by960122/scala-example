package basic

/**
 * @author: BYDylan
 * @date: 2020/7/22
 * @description:
 * 1)和Animal直系的,是Animal父类的按是父类处理,是Animal子类的按照Animal处理()
 * 2)和Animal无关的,一律按照Object处理！
 */

object LowerBoundsDemo {
  def main(args: Array[String]): Unit = {
    // 满足下界的约束
    biophony(Seq(new Earth, new Earth)).map(_.sound())
    // 满足下界的约束
    biophony(Seq(new Animal, new Animal)).map(_.sound())
    // 这里我们不能使用上界的思路去推导,这里是可以运行
    biophony(Seq(new Bird, new Bird)).map(_.sound())
    biophony(Seq(new Moon))
  }

  // 下界,这里不能调用 sound ,因为不知道 Animal 的父类有没有该方法
  def biophony[T >: Animal](things: Seq[T]) = things
}

class Earth {
  def sound() {
    println("hello!")
  }
}

class Animal extends Earth {
  override def sound() = {
    println("animal sound")
  }
}

class Bird extends Animal {
  override def sound() = {
    print("bird sounds")
  }
}

class Moon {
  def sound() = {
    print("bird sounds")
  }
}
