package main.scala.solvers
import scala.annotation.tailrec

abstract class ApproachUsingMutableCharsArray(sentence: String, maxPalindromes: Long) extends Approach(sentence, maxPalindromes) {
 
  
  @tailrec final def palindromLength(i: Int, range: Int):Int = {      
    if (same(i - range, i + range)) {          
      palindromLength(i, range + 1)      
    }       
    else 
      range
  }
  
  def solve:Int
      
  val inputSize = sentence.size
  val centersSize = 2 * inputSize + 3
  
  def same(index1:Int, index2:Int):Boolean = {
    centers(index1) == centers(index2)
  }  
   
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
  
  val P = { 
    new Array[Int](centersSize)
  }
}