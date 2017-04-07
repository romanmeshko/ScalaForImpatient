import java.time.LocalDate

import scala.annotation.tailrec

// ex.2.1
def abs(x: Double) = if (x >= 0) x else -x

// ex.2.4
for (i <- 10 to (0, -1)) println(i)

// ex.2.6
def prodUnicode(str: String) = {
  var result = 1L
  for(s <- str) result *= s
  result
}
prodUnicode("Hello")

// ex.2.7
def prodUnicodeNonLoop(str: String) = {
  var result = 1L
  str.foreach((f:Char) => result *= f)
  result
}
prodUnicodeNonLoop("Hello")

// ex.2.9
def prodRec(str: String): Long = {
  @tailrec
  def product(str: String, accumulator: Long): Long = {
    if (str.isEmpty) accumulator
    else product(str.tail, str.head * accumulator)
  }

  product(str, 1)
}
prodRec("Hello")

// ex.2.10
def PowerRec(n: Integer): Double = {
  if (n > 0 && n % 2 == 0) PowerRec(n / 2) * PowerRec(n / 2)
  else if (n > 0 && n % 2 > 0) PowerRec(1) * PowerRec(n - 1)
  else if (n == 0) 1
  else 1 / PowerRec(-n)
}


//http://scala-puzzles.herokuapp.com/
//String
def capitalize(s: String) = {
  var result = ""
  s.split(" ").foreach((str:String) =>
    result += (str.head.toString.toUpperCase +
      str.tail.toString.toLowerCase + " "))
  result.trim
}

capitalize("man OF stEEL")

//Functions
def addOne(m: Int): Int = m + 1
addOne(1) == 2
addOne(2) == 3

def isOne(m:Int) : Boolean = (m == 1)

isOne(1) == true
isOne(0) == false
// now you write the function...
def addTwo(m:Int):Int = m + 2
addTwo(1) == 3
addTwo(2) == 4
def three() = 1 + 2
three == 3

//ex. 2.11 in Second Edition
implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
  def date(args: Any*): LocalDate = {
    val list = args.map(_.toString).map(Integer.valueOf)
    LocalDate.of(list.head, list(1), list(2))
  }
}