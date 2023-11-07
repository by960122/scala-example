package designpatterns.proxy.dyn

import java.lang.reflect.{InvocationHandler, Method}

/**
 * @author: BYDylan
 * @date: 2019/11/28
 * @description: 自己调用的代理
 */
class OwnerInvocationHandler extends InvocationHandler {
  //被调用的对象PersonBeanImpl
  var person: PersonBean = _

  def this(person: PersonBean) {
    this
    this.person = person
  }

  //  这里的proxy就是和OwnerInvocationHandler合作的代理
  override def invoke(proxy: scala.Any, method: Method, args: Array[AnyRef]): AnyRef = {

    //如果是get方法就直接调用
    if (method.getName().startsWith("get")) {
      return method.invoke(person)
      //自己不能调用setHotOrNotRating,给自己评分
    } else if (method.getName().equals("setScore")) {
      //返回一个异常，同时invoke throws掉了
      return new IllegalAccessException()
      //如果是set方法就直接调用
    } else if (method.getName().startsWith("set")) {
      return method.invoke(person, args(0).toString)
    }
    return null
  }


}
