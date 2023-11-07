package designpatterns.proxy.rmi

import java.rmi.Naming

class MyRemoteClient {
  def go() = {
    val service = Naming.lookup("rmi://localhost:9999/RemoteHello").asInstanceOf[MyRemote]
    val str = service.sayHello()
    println("str = " + str)
  }
}

object MyRemoteClient {
  def main(args: Array[String]): Unit = {
    while (true) {
      try {
        new MyRemoteClient().go()
      } catch {
        case exception: Exception => println()
      }
    }
  }
}

