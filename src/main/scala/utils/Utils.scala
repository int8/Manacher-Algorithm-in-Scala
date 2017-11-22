package main.scala.utils

import main.scala.solvers.Approach

object Utils {

  def sumUntilLimit(l: Seq[Int], maximum:Long): Int = {
    var sum = 0
    var i = 0
    val length = l.length
    while (i < length)
    {
      sum += l(i)
      i = i + 1
      if (sum >= maximum) return -1
    }
    sum
  }


  def time(solver: => Approach): Double = {
    val t0 = System.nanoTime()
    val result = solver.solve
    val t1 = System.nanoTime()
    (t1 - t0) / (10000000.0)
  }


  def randomSequence(numberOfChars:Int, length:Int) = {
    val alphabet = 'a' to 'z'
    val chars = alphabet.take(Math.min(alphabet.length - 1, numberOfChars))
    ((0 to length) map (x => chars(scala.util.Random.nextInt(chars.length)))).mkString
  }

}
