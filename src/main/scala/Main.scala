import main.scala.solvers._
import main.scala.utils.Utils

object Main extends App {

  val maxPalindromes = 1000000000

  var distinctChars = 20
  var sentenceLength = 100000
  var sentence = Utils.randomSequence(distinctChars, sentenceLength)

  var quadraticTime = Utils.time (new Quadratic(sentence, maxPalindromes))
  var functionalLinearImmutableTime = Utils.time (new FunctionalLinearImmutable(sentence, maxPalindromes))
  var imperativeLinearTime = Utils.time (new ImperativeLinear(sentence, maxPalindromes))

  println("Quadratic solver takes " + quadraticTime + " ms to finish for random sentence of length " + sentenceLength + " composed of " + distinctChars  +" distinct chars")
  println("Functional Linear solver takes " + functionalLinearImmutableTime + " ms to finish for random sentence of length " + sentenceLength + " composed of " + distinctChars  +" distinct chars")
  println("Imperative linear solver takes " + imperativeLinearTime + " ms to finish for random sentence of length " + sentenceLength + " composed of " + distinctChars  +" distinct chars")

  println()

  quadraticTime = Utils.time (new Quadratic("a"*1000 + "b" * 1000 + "c" * 1000, maxPalindromes))
  functionalLinearImmutableTime = Utils.time (new FunctionalLinearImmutable("a"*1000 + "b" * 1000 + "c" * 1000, maxPalindromes))
  imperativeLinearTime = Utils.time (new ImperativeLinear("a"*1000 + "b" * 1000 + "c" * 1000, maxPalindromes))

  println("Quadratic solver takes " + quadraticTime + " ms to finish for sentence a^1000 + b^1000 + c^1000")
  println("Functional Linear solver takes " + functionalLinearImmutableTime + " ms to finish for sentence a^1000 + b^1000 + c^1000")
  println("Imperative linear solver takes " + imperativeLinearTime +  " ms to finish for sentence a^1000 + b^1000 + c^1000")

  println()

  distinctChars = 3
  sentenceLength = 500000
  sentence = Utils.randomSequence(distinctChars, sentenceLength)

  quadraticTime = Utils.time (new Quadratic(sentence, maxPalindromes))
  functionalLinearImmutableTime = Utils.time (new FunctionalLinearImmutable(sentence, maxPalindromes))
  imperativeLinearTime = Utils.time (new ImperativeLinear(sentence, maxPalindromes))

  println("Quadratic solver takes " + quadraticTime + " ms to finish for random sentence of length " + sentenceLength + " composed of " + distinctChars  +" distinct chars")
  println("Functional Linear solver takes " + functionalLinearImmutableTime + " ms to finish for random sentence of length " + sentenceLength + " composed of " + distinctChars  +" distinct chars")
  println("Imperative linear solver takes " + imperativeLinearTime + " ms to finish for random sentence of length " + sentenceLength + " composed of " + distinctChars  +" distinct chars")


}
