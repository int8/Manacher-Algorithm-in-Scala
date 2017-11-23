package main.scala.symbols
/** Class representing potential center of palindrome in a sequence */
class Center

/** Class representing potential center of palindrome in a sequence being a letter */
case class Letter(char: Char) extends Center {
  val validityCheck = if (('a' to 'z') contains char) true else throw new IllegalArgumentException("Please use chars from range a to z")
  
  override def toString = {
    this.char.toString()
  }

  def equals(arg0: Letter): Boolean = {
    this.char == arg0.char
  }
}
/** Object representing potential center of palindrome in a sequence being space between letters */
object Space extends Center {
  override def toString = {
    "|"
  }
}
/** Object representing beginning of the string */
object StringBeginning extends Center {
  override def toString = {
    "^"
  }
}

/** Object representing end of the string */
object StringEnding extends Center {
  override def toString = {
    "$"
  }
}