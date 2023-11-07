package hight_level.covariantcontravariant

object Demo {
  def main(args: Array[String]): Unit = {
    val t1: Temp3[Sub] = new Temp3[Sub]("hello");
    //       val t2: Temp3[Sub] = new Temp3[Super]("hello");// error
    //       val t3: Temp3[Super] = new Temp3[Sub]("hello");// error
    val t4: Temp3[Sub] = new Temp3[Sub]("hello"); // ok
    val t5: Temp4[Super] = new Temp4[Sub]("hello"); // ok
    // val t6: Temp4[Sub] = new Temp4[Super]("hello"); // ok
    val t7: Temp5[Sub] = new Temp5[Sub]("hello"); // ok
    val t8: Temp5[Sub] = new Temp5[Super]("hello"); // ok
    // val t9: Temp5[Super] = new Temp5[Sub]("hello"); // ok


  }
}


// 协变
class Temp4[+A](title: String) {
  override def toString: String = {
    title
  }
}

// 逆变
class Temp5[-A](title: String) {
  override def toString: String = {
    title
  }
}

// 不变
class Temp3[A](title: String) {
  override def toString: String = {
    title
  }
}

class Super

class Sub extends Super

