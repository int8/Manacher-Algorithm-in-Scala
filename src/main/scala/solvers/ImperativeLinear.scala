package main.scala.solvers

class ImperativeLinear(sentence: String, maxPalindromes: Long) extends ApproachUsingMutableCharsArray(sentence, maxPalindromes) {   
  
 def manacherSum:Int = {        
    var i = 1
    var c = 0
    var radius = 0    
    var sum = 0 
    while (centers(i) != '$') {
      if (sum > maxPalindromes) {
        return - 1 
      }
      val minLength = if (c + radius > i) Math.min(c + radius - i, P(2 * c - i)) else 1
      val maxLength = this.palindromLength(i, minLength)
      if (i + maxLength > c + radius) {
        c = i
        radius = maxLength         
      }
      P(i) = maxLength              
      sum = sum + (maxLength - maxLength/2 - 1)
      i = i + 1  
    }
    sum 
  }   
 
  override def solve:Int = {                  
    manacherSum
  }

  override def toString = "Impreative Linear"
  
}