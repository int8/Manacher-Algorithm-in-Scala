import main.scala.solvers._
import main.scala.utils.Utils

object Main extends App {


  val distinctChars = 20
  val sentenceLength = 100000
  val sentence = Utils.randomSequence(distinctChars, sentenceLength)

  val quadraticTime = Utils.time (new Quadratic(sentence, 1000000000))
  val functionalLinearImmutableTime = Utils.time (new FunctionalLinearImmutable(sentence, 1000000000))
  val imperativeLinearTime = Utils.time (new ImperativeLinear(sentence, 1000000000))

  println("Quadratic solver takes " + quadraticTime + "ms to finish for sentence of length " + sentenceLength + " composed of " + distinctChars  +" distinct chars")
  println("Functional Linear solver takes " + functionalLinearImmutableTime + "ms to finish for sentence of length " + sentenceLength + " composed of " + distinctChars  +" distinct chars")
  println("Imperative linear solver takes " + imperativeLinearTime + "ms to finish for sentence of length " + sentenceLength + " composed of " + distinctChars  +" distinct chars")

  
}
