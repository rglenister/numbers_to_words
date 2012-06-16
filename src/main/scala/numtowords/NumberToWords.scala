package numtowords


object NumberToWords {

  val smallNumberNameMap = Map(
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
  
  val largeNumberNameMap = Map(
    0L -> "",
    1000L -> "thousand",
    1000000L -> "million",
    1000000000L -> "billion",
    1000000000000L -> "trillion",
    1000000000000000L -> "quadrillion",
    1000000000000000000L -> "quintillion"
  )
  
  val dividerList = largeNumberNameMap.keys.toList.sorted
  
  def numberToWords(i: Long): String = i match {
    case _ if i < 0 => "minus " + numberToWords(-i)
    case 0 => "zero"
    case _ => convert(i, dividerList).reverse.flatten.filterNot(_ isEmpty).mkString(" ")
  }
  
  private def convert(i: Long, dividers: List[Long]): List[List[String]] = i % 1000 match {
    case 0 if i > 0 => convert(i / 1000, dividers.tail)
    case 0 => Nil
    case j => convertHundreds(j) ++ convertTens(j) ++ List(largeNumberNameMap(dividers.head)) :: convert(i / 1000, dividers.tail)
  }
  
  private def convertHundreds(i: Long): List[String] = i / 100 match {
    case j if j > 0 =>  smallNumberNameMap(j) :: smallNumberNameMap(100L) :: Nil
    case _ => Nil
  }
  
  private def convertTens(i: Long): List[String] = i % 100 match {
    case 0 => Nil
    case j if j <= 20 => smallNumberNameMap(j) :: Nil
    case k => smallNumberNameMap(k - k % 10) :: smallNumberNameMap(k % 10) :: Nil
  }  
}
