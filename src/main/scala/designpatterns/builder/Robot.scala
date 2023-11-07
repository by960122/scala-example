package designpatterns.builder

/**
 * @author: BYDylan
 * @date: 2019/11/28
 * @description:
 */
case class Robot(
                  name: String = "",
                  code: String = "",
                  battery: Int = 0
                ) {
  require(code != "", "不可缺少 code 参数")
  require(name != "", "不可缺少 name 参数")
}
