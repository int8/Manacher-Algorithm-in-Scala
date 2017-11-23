package main.scala.solvers

/** Class for palindromic factorization solver using imperative programming with mutable data structures, it uses Manacher algorithm resulting in linear complexity
  *
  *  @constructor create a new solver for palindromic substring counting problem
  *  @param sentence input string
  *  @param maxPalindromes maximum number of palindromic substring to look for
  */
class ImperativeLinear(sentence: String, maxPalindromes: Long) extends ApproachUsingMutableCharsArray(sentence, maxPalindromes) {

  /** manacher algorithm + summing over all lengths  */
 def manacherSum:Int = {        
    var i = 1 // current index
    var c = 0 // current palindrome that reaches i with radius
    var radius = 0 // radius of the current palindrome
    var sum = 0 // current sum
    while (centers(i) != '$') {
      if (sum > maxPalindromes) {
        return - 1 // if sum reaches max, return -1
      }
      val minLength = if (c + radius > i) Math.min(c + radius - i, P(2 * c - i)) else 1 // minimum length of palindrome around current index, the trick sits here
      val maxLength = this.palindromLength(i, minLength) // look for palindrome
      if (i + maxLength > c + radius) { // shall we update center and radius
        c = i
        radius = maxLength         
      }
      P(i) = maxLength              
      sum = sum + (maxLength - maxLength/2 - 1) // manacher gives radius - this transform it to lengths
      i = i + 1  
    }
    sum 
  }

  /** solves palindromic substring counting problem with manacher algorithm using imperative programming with mutable data structures */
  override def solve:Int = {                  
    manacherSum
  }

  /** string representation of this */
  override def toString = "Impreative Linear"
  
}