package main.scala.solvers

import main.scala.symbols._

import scala.annotation.tailrec

abstract class ApproachUsingImmutableCentersArray(sentence: String, maxPalindromes: Long) extends Approach(sentence, maxPalindromes) {
 
  
  @tailrec final def palindromLength(i: Int, range: Int):Int = {      
    if (same(i - range, i + range)) {          
      palindromLength(i, range + 1)      
    }       
    else 
      range
  }
  
  def solve:Int
  val inputSize = sentence.size
  
  def same(index1:Int, index2:Int):Boolean = {
    centers(index1) == centers(index2)
  }  

  def isSpace(index:Int):Boolean = centers(index) match {    
    case Space => true
    case _ => false
  }
  
  def isLetter(index:Int): Boolean = !isSpace(index)
    
  val centers = {      
    @tailrec def buildCenters(i: Int, v:Vector[Center]):Vector[Center] = {
      if (i == inputSize) return v 
      else {
        buildCenters(i + 1, (v :+ Letter(sentence(i))) :+ Space)
      }
   }
   buildCenters(0, Vector[Center](StringBeginning, Space)) :+ StringEnding    
  }
    
}