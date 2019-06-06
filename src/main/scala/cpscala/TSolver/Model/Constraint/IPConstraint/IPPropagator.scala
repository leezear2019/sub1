package cpscala.TSolver.Model.Constraint.IPConstraint

import java.util.concurrent.Callable

import cpscala.TSolver.Model.Variable.PVar

abstract class IPPropagator extends Callable[Boolean] {
  val id: Int
  val arity: Int
  val scope: Array[PVar]
  var level = 0
  var assignedCount = 0

  def setup(): Unit = ???

  def propagate(): Boolean

  def newLevel(): Unit

  def backLevel(): Unit
}
