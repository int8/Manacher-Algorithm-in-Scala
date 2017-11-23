package main.scala.solvers

import main.scala.utils.Utils

/** Class for palindromic factorization solver using naive quadratic approach
  *
  *  @constructor create a new solver for palindromic substring counting problem
  *  @param sentence input string
  *  @param maxPalindromes maximum number of palindromic substring to look for
  */
class Quadratic(sentence:String, maxPalindromes:Long) extends ApproachUsingImmutableCentersArray(sentence, maxPalindromes) {
  /** solves palindromic substring counting problem with quadratic complexity */
  override def solve = {
    val palindromesArray = (2 to (centers.length - 2)) map ( i => { palindromeRadiusAtCenter(i, 1) })
    Utils.sumUntilLimit(palindromesArray.map(x => x - x / 2 - 1), maxPalindromes)       
  }
  /** string representation of this */
  override def toString = "Quadratic naive"
}
