package basic

object UpperBoundsDemo02 {
  def main(args: Array[String]): Unit = {
    biophony(Seq(new Bird01, new Bird01))
    biophony(Seq(new Animal01, new Animal01))
    biophony(Seq(new Animal01, new Bird01))
    // 因为Earth不是Animal子类
    // biophony(Seq(new Earth, new Earth))
  }

  def biophony[T <: Animal01](things: Seq[T]) = things map (_.sound)
}

class Earth01 {
  def sound() {
    println("hello !")
  }
}

class Animal01 extends Earth01 {
  override def sound() = {
    println("animal sound")
  }
}

class Bird01 extends Animal01 {
  override def sound() = {
    println("bird sounds")
  }
}
