package main.scala.solvers

/** Abstract class for palindromic factorization solvers - approach using EERTREE structure
  *
  *  @constructor create a new solver for palindromic substring counting problem
  *  @param sentence input string
  *  @param maxPalindromes maximum number of palindromic substring to look for
  */
abstract class ApproachUsingEERTREE(sentence:String, maxPalindromes:Long) extends Approach(sentence, maxPalindromes) {
  /** solves palindromic substring counting problem */
  def solve:Int
  /** approach specific members */
  def approachCharacteristics = List("some", "members", "specific", "to", "this", "approach")
  /** approach specific members */
  def suffixTree(sentence:String) = null
}