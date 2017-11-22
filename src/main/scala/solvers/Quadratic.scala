package main.scala.solvers

import main.scala.utils.Utils

class Quadratic(sentence:String, maxPalindromes:Long) extends ApproachUsingImmutableCentersArray(sentence, maxPalindromes) {

  override def solve = {
    val palindromesArray = (2 to (centers.length - 2)) map ( i => { palindromLength(i, 1) })
    Utils.sumUntilLimit(palindromesArray.map(x => x - x / 2 - 1), maxPalindromes)       
  }

  override def toString = "Quadratic naive"
}
