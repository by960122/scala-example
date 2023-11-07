package designpatterns.facade

/**
 * @author: BYDylan
 * @date: 2019/11/28
 * @description: 加密外观类
 */
class EncryptFacade {
  private val fileReader = new FileReader
  private val cipherMachine = new CipherMachine
  private val fileWriter = new FileWriter

  def fileEncrypt(fileNameSrc: String, fileNameDes: String): Unit = {
    fileWriter.write(cipherMachine.encrypt(fileReader.read(fileNameSrc)), fileNameDes)
  }
}
