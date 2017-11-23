package main.scala.solvers
import scala.annotation.tailrec

/** Abstract class for palindromic factorization solvers - approach using mutable Char Array
  *
  *  @constructor create a new solver for palindromic substring counting problem
  *  @param sentence input string
  *  @param maxPalindromes maximum number of palindromic substring to look for
  */
abstract class ApproachUsingMutableCharsArray(sentence: String, maxPalindromes: Long) extends Approach(sentence, maxPalindromes) {

  /** solves palindromic substring counting problem */
  def solve:Int

  /** size of the input sentence (length)*/
  val inputSize = sentence.size

  /** size of the centers array */
  val centersSize = 2 * inputSize + 3

  /** tail recursive method, expanding around given index in centers until different chars occur */
  @tailrec final def palindromeRadiusAtCenter(i: Int, range: Int):Int =
    if (same(i - range, i + range)) {
      palindromeRadiusAtCenter(i, range + 1)
    }
    else range

  /** determines whether two chars are the same */
  def same(index1:Int, index2:Int):Boolean = {
    centers(index1) == centers(index2)
  }

  /** true if center it given index is String Ending */
  def isSentenceEnding(index:Int) = centers(index) == '$'

  /** data structure represening all potential centers of palindromes - given by chars */
  val centers = {
    var c = new Array[Char](centersSize)
    c(0) = '^';
    c(1) = '#';
    var i = 0
    while (i < inputSize) {
      c(2 * i + 2) = sentence(i)
      c(2 * i + 3) = '#'
      i = i + 1
    }
    c(centersSize - 1) = '$'
    c
  }


}
