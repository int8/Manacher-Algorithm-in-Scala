package main.scala.symbols

class Center

case class Letter(char: Char) extends Center {
  val validityCheck = if (('a' to 'z') contains char) true else throw new IllegalArgumentException("Please use chars from range a to z")
  
  override def toString = {
    this.char.toString()
  }

  def equals(arg0: Letter): Boolean = {
    this.char == arg0.char
  }
}

object Space extends Center {
  override def toString = {
    "|"
  }
}

object StringBeginning extends Center {
  override def toString = {
    "^"
  }
}

object StringEnding extends Center {
  override def toString = {
    "$"
  }
}