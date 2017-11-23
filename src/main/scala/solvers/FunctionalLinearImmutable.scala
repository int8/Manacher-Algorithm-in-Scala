package main.scala.solvers
import scala.annotation.tailrec

/** Class for palindromic factorization solver using functional programming with immutable data structures, it uses Manacher algorithm resulting in linear complexity
  *
  *  @constructor create a new solver for palindromic substring counting problem
  *  @param sentence input string
  *  @param maxPalindromes maximum number of palindromic substring to look for
  */
class FunctionalLinearImmutable(sentence: String, maxPalindromes: Long) extends ApproachUsingImmutableCentersArray(sentence, maxPalindromes) {
  /** manacher algorithm + summing over all lengths
    * @param P a Vector with radiuses of previous palindromes found up to P.length (i)in a string
    * @param c a center of the palindrome that reaches current index i
    * @param radius radius of current palindrome ( the one centered at c )
    * @param i index being currently processed 
    * @param acc sum of palindromes up to index i
    * */
  @tailrec final def manacherSum(P: Vector[Int], c: Int, radius: Int, i: Int, acc:Int):Int = {

    if(acc > maxPalindromes) return -1
    if (isSentenceEnding(i)) return acc

    val minLength = if (c + radius > i) Math.min(c + radius  - i ,P(2 * c - i)) else 1
    val maxLength = this.palindromeRadiusAtCenter(i, minLength)

    val (newCenter:Int, newRadius:Int) = if (i + maxLength > c + radius) (i, maxLength) else (c,radius)
    return manacherSum(P :+ maxLength,newCenter, newRadius, i + 1, acc + maxLength - maxLength / 2 - 1)
  }

  /** solves palindromic substring counting problem with manacher algorithm using functional programming with immutable data structures */
  override def solve = {
    manacherSum(Vector(1), 0, 0, 1, 0)
  }

  /** string representation of this */
  override def toString = "Functional Linear Immutable"
}
