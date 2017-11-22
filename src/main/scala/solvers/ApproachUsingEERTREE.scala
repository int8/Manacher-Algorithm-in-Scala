package main.scala.solvers

abstract class ApproachUsingEERTREE(sentence:String, maxPalindromes:Long) extends Approach(sentence, maxPalindromes) {
  def solve:Int 
  def approachCharacteristics = List("some", "members", "specific", "to", "this", "approach")
  def suffixTree(sentence:String) = null
}