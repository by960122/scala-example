package designpatterns.proxy.dyn

/**
 * @author: BYDylan
 * @date: 2019/11/28
 * @description: 这个就是我们的Subject(是一个trait/Java中interface)
 */
trait PersonBean {
  def getName(): String

  def getGender(): String

  def getInterests(): String

  def getScore(): Int

  def setName(name: String)

  def setGender(gender: String)

  def setInterests(interests: String)

  def setScore(score: Int)
}
