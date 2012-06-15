package numtowords


object NumberToWords {

  val hundred = 100L
  val thousand = 1000L
  val million = 1000000L
  val billion = 1000000000L
  val trillion = 1000000000000L
  val quadrillion = 1000000000000000L
  val quintillion = 1000000000000000000L
  
  
  val lookup = Map(
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
    hundred -> "hundred",
    thousand -> "thousand",
    million -> "million",
    billion -> "billion",
    trillion -> "trillion",
    quadrillion -> "quadrillion",
    quintillion -> "quintillion"
  )
  
  val dividerList = List(quintillion, quadrillion, trillion, billion, million, thousand)
  
  def numberToWords(i: Long): String = i match {
    case _ if i < 0 => "minus " + numberToWords(-i)
    case 0 => "zero"
    case _ => convertLargeNumber(i, dividerList).filterNot(_ isEmpty).reverse.mkString(" ")
  }
  
  private def convertLargeNumber(i: Long, dividers: List[Long]): List[String] = dividers match {
    case divider :: t if 1 until 1000 contains i / divider => convertLargeNumber(i % divider, t) ++ convertNamedNumber(i / divider, divider)
    case divider :: t => convertLargeNumber(i % divider, dividers.tail) 
    case _ => convertSmallNumber(i)
  }
  
  private def convertNamedNumber(i: Long, divider: Long): List[String] = lookup(divider) :: convertSmallNumber(i)
  
  private def convertSmallNumber(i: Long): List[String] = convertTens(i) ++ convertHundreds(i)
  
  private def convertHundreds(i: Long): List[String] = i / 100 match {
    case j if j > 0 => lookup(hundred) :: lookup(j) :: Nil
    case _ => Nil
  }
  
  private def convertTens(i: Long): List[String] = i % 100 match {
    case 0 => Nil
    case j if j <= 20 => lookup(j) :: Nil
    case k => lookup(k % 10) :: lookup(k / 10 * 10) :: Nil
  }  
}
