package designpatterns.facade

/**
 * @author: BYDylan
 * @date: 2019/11/28
 * @description: 测试客户端
 */
object Client extends App {
  val encryptFacade = new EncryptFacade
  encryptFacade.fileEncrypt("hello", "des")
}
