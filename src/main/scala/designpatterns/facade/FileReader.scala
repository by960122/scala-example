package designpatterns.facade

import java.io.{FileNotFoundException, IOException}
import scala.io.Source

/**
 * @author: BYDylan
 * @date: 2019/11/28
 * @description: 读文件,子系统类
 */
class FileReader {

  def read(fileNameSrc: String): String = {
    println("读取文件，获取明文：")
    /**
     * 读入文件
     */
    var target = ""
    try {
      for (s <- Source.fromFile(fileNameSrc)) {
        target += s.toString
      }
    } catch {
      case io: IOException => io.printStackTrace()
      case noFile: FileNotFoundException => noFile.printStackTrace()
    }
    return target
  }
}
