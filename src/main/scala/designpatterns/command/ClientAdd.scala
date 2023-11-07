package designpatterns.command

/**
 * @author: BYDylan
 * @date: 2019/11/28
 * @description:
 */
object ClientAdd extends App {
  val command: AbstractCommand = new AddCommand
  val form = new CalculatorForm(command)
  form.compute(10)
  form.compute(5)
  form.undo()
  form.undo()
  form.redo()
  form.redo()
  form.redo()
  form.undo()
  form.undo()
  form.undo()
  form.redo()
  form.compute(100)
}