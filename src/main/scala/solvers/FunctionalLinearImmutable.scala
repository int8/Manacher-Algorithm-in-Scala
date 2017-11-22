package main.scala.solvers

import main.scala.symbols.StringEnding
import scala.annotation.tailrec


class FunctionalLinearImmutable(sentence: String, maxPalindromes: Long) extends ApproachUsingImmutableCentersArray(sentence, maxPalindromes) {     
    
  
  @tailrec final def manacherSum(P: Vector[Int], c: Int, radius: Int, i: Int, acc:Int):Int = {    
    
    if(acc > maxPalindromes) return -1     
    if (centers(i) == StringEnding) return acc
    
    val minLength = if (c + radius > i) Math.min(c + radius  - i ,P(2 * c - i)) else 1
    val maxLength = this.palindromLength(i, minLength)
      
    val (newCenter:Int, newRadius:Int) = if (i + maxLength > c + radius) (i, maxLength) else (c,radius)     
    return manacherSum(P :+ maxLength,newCenter, newRadius, i + 1, acc + maxLength - maxLength / 2 - 1)
  }
  
  override def solve = {        
    manacherSum(Vector(1), 0, 0, 1, 0)       
  }

  override def toString = "Functional Linear Immutable"
}
