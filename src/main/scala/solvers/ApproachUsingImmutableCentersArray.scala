package main.scala.solvers

import main.scala.symbols._
import scala.annotation.tailrec

/** Abstract class for palindromic factorization solvers - approach using Immutable Centers Array (Vector in fact)
  *
  *  @constructor create a new solver for palindromic substring counting problem
  *  @param sentence input string
  *  @param maxPalindromes maximum number of palindromic substring to look for
  */
abstract class ApproachUsingImmutableCentersArray(sentence: String, maxPalindromes: Long) extends Approach(sentence, maxPalindromes) {

  /** tail recursive method, expanding around given index in centers until different chars occur */
  @tailrec final def palindromeRadiusAtCenter(i: Int, range: Int):Int =
    if (same(i - range, i + range)) {
      palindromeRadiusAtCenter(i, range + 1)
    }
    else
      range

  /** solves palindromic substring counting problem */
  def solve:Int

  /** size of the input sentence (length)*/
  val inputSize = sentence.size

  /** determines whether two centers (letters or spaces) are the same */
  def same(index1:Int, index2:Int):Boolean = centers(index1) == centers(index2)

  /** true if center it given index is Space */
  def isSpace(index:Int):Boolean = centers(index) == Space

  /** true if center it given index is Letter */
  def isLetter(index:Int): Boolean = centers(index) match {
    case _:Letter => true
    case _ => false
  }

  /** true if center it given index is String Ending */
  def isSentenceEnding(index:Int): Boolean = centers(index) == StringEnding

  /** data structure represening all potential centers of palindromes */
  val centers:Vector[Center] = {
    /** recursive function building centers */
    @tailrec def buildCenters(i: Int, v:Vector[Center]):Vector[Center] = {
      if (i == inputSize) return v
      else {
        buildCenters(i + 1, (v :+ Letter(sentence(i))) :+ Space)
      }
   }
   buildCenters(0, Vector[Center](StringBeginning, Space)) :+ StringEnding
  }

}
