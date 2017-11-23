package main.scala.solvers
/** Abstract class for palindromic factorization solvers
  *
  *  @constructor create a new solver for palindromic substring counting problem
  *  @param sentence input string
  *  @param maxPalindromes maximum number of palindromic substring to look for
  */
abstract class Approach(sentence:String, maxPalindromes:Long) {

  /** solves palindromic substring counting problem */
  def solve: Int
}