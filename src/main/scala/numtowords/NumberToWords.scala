package numtowords


object NumberToWords {

  private val smallNumberNameMap = Map(
    0L -> "",
    1L -> "one",
    2L -> "two",
    3L -> "three",
    4L -> "four",
    5L -> "five",
    6L -> "six",
    7L -> "seven",
    8L -> "eight",
    9L -> "nine",
    10L -> "ten",
    11L -> "eleven",
    12L -> "twelve",
    13L -> "thirteen",
    14L -> "fourteen",
    15L -> "fifteen",
    16L -> "sixteen",
    17L -> "seventeen",
    18L -> "eighteen",
    19L -> "nineteen",
    20L -> "twenty",
    30L -> "thirty",
    40L -> "forty",
    50L -> "fifty",
    60L -> "sixty",
    70L -> "seventy",
    80L -> "eighty",
    90L -> "ninety",
    100L -> "hundred"
  )
  
  private val largeNumberNames = List("", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion")
  
  def numberToWords(i: Long): String = i match {
    case _ if i < 0 => "minus " + numberToWords(-i)
    case 0 => "zero"
    case _ => normalizeWhiteSpace(convert(i, largeNumberNames).trim)
  }
  
  private def convert(i: Long, dividers: List[String]): String = {
    if (i > 0) {
      convert(i / 1000, dividers.tail) + " " + convertNamedLargeNumber(i % 1000, dividers.head)
    } else ""
  }
  
  private def convertNamedLargeNumber(i: Long, largeNumberName: String): String = {
    if (i > 0) {
      convertHundreds(i / 100) + " " +  convertTens(i % 100) + " " + largeNumberName 
    } else ""
  }
  
  private def convertHundreds(i: Long): String = {
    if (i > 0) {
      smallNumberNameMap(i) + " " + smallNumberNameMap(100L)
    } else {
       ""
    }
  }
  
  private def convertTens(i: Long): String = {
    if (i <= 20) {
      smallNumberNameMap(i)
    } else {
      smallNumberNameMap(i - i % 10) + " " + smallNumberNameMap(i % 10)
    }
  }  
  
  private def normalizeWhiteSpace(s: String) = {
    s replaceAll("\\s+", " ")
  }
}
