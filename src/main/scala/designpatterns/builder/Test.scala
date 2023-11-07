package designpatterns.builder

/**
 * @author: BYDylan
 * @date: 2019/11/28
 * @description:
 */
object Test extends App {
  val robot1 = Robot(
    code = "89757",
    name = "Bat-Man",
    battery = 99
  )
  System.out.println(s"Robot1 : $robot1")
  try {
    val robot2 = Robot(name = "Bat-Man")
  } catch {
    case e: Throwable => e.getMessage()
  }
}
