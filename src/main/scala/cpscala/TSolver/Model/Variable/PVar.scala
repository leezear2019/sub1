package cpscala.TSolver.Model.Variable

abstract class PVar extends Var {

  def simpleMask(): Long = ???

  def submitMask(mask: Long): Boolean = ???

  def submitMaskAndGet(mask: Long): Long = ???

  def getAndSubmitMask(mask: Long): Long = ???

  def safeRemove(a: Int): Unit = ???

  def mask(mask: Array[Long]): Unit = ???

  def submitMask(mask: Array[Long]): Boolean = ???

  def submitMaskAndGet(mask: Array[Long]): Long = ???

  def getAndSubmitMask(mask: Array[Long]): Long = ???

  def isChanged(mask: Array[Long]): Boolean = ???
}
