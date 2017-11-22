package test.scala

import org.scalatest._
import main.scala.solvers._
import main.scala.utils._

class SolverTests extends FlatSpec with Matchers {

  "Number of palindromes found by Quadratic solver for aaa" should "match 3" in {
    val quadratic = new Quadratic("aaa",maxPalindromes = 100)
    quadratic.solve should be (3)
  }

  "Number of palindromes found by FunctionalLinearImmutable solver for aaa" should "match 3 " in {
    val functionalLinearImmutable = new FunctionalLinearImmutable("aaa",maxPalindromes = 100)
    functionalLinearImmutable.solve should be (3)
  }

  "Number of palindromes found by ImperativeLinear solver for aaa" should "match 3 " in {
    val imperativeLinear = new ImperativeLinear("aaa",maxPalindromes = 100)
    imperativeLinear.solve should be (3)
  }

  "Number of palindromes found by Quadratic solver for abc" should "match 0" in {
    val quadratic = new Quadratic("abc",maxPalindromes = 100)
    quadratic.solve should be (0)
  }

  "Number of palindromes found by FunctionalLinearImmutable solver for abc" should "match 0 " in {
    val functionalLinearImmutable = new FunctionalLinearImmutable("abc",maxPalindromes = 100)
    functionalLinearImmutable.solve should be (0)
  }

  "Number of palindromes found by ImperativeLinear solver for abc" should "match 0 " in {
    val imperativeLinear = new ImperativeLinear("abc",maxPalindromes = 100)
    imperativeLinear.solve should be (0)
  }

  "Number of palindromes found by Quadratic solver for ababa" should "match 4" in {
    val quadratic = new Quadratic("ababa",maxPalindromes = 100)
    quadratic.solve should be (4)
  }

  "Number of palindromes found by FunctionalLinearImmutable solver for ababa" should "match 4 " in {
    val functionalLinearImmutable = new FunctionalLinearImmutable("ababa",maxPalindromes = 100)
    functionalLinearImmutable.solve should be (4)
  }

  "Number of palindromes found by ImperativeLinear solver for ababa" should "match 4 " in {
    val imperativeLinear = new ImperativeLinear("ababa",maxPalindromes = 100)
    imperativeLinear.solve should be (4)
  }

  "Number of palindromes found by Quadratic solver for a^1000 and maxPalindromes = 100" should "match -1" in {
    val quadratic = new Quadratic(Utils.randomSequence(1,1000) ,maxPalindromes = 100)
    quadratic.solve should be (-1)
  }

  "Number of palindromes found by FunctionalLinearImmutable solver for a^1000 and maxPalindromes = 100" should "match -1" in {
    val functionalLinearImmutable = new FunctionalLinearImmutable(Utils.randomSequence(1,1000) ,maxPalindromes = 100)
    functionalLinearImmutable.solve should be (-1)
  }

  "Number of palindromes found by ImperativeLinear solver for a^1000 and maxPalindromes = 100" should "match -1" in {
    val imperativeLinear = new ImperativeLinear(Utils.randomSequence(1,1000),maxPalindromes = 100)
    imperativeLinear.solve should be (-1)
  }

}