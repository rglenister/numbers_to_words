package numtowords

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec


@RunWith(classOf[JUnitRunner]) 
class NumberToWordsSpec extends FlatSpec with ShouldMatchers {
 
  "The NumberToWords" should "handle zero" in {
	NumberToWords.numberToWords(0) should equal ("zero")
  }

  it should "handle a negative input" in {
	NumberToWords.numberToWords(-1) should equal ("minus one")
  }
  
  it should "handle a positive input" in {
	NumberToWords.numberToWords(1) should equal ("one")
  }
  
  it should "handle all powers of 10 from 1 to 15" in {
	NumberToWords.numberToWords(10L) should equal ("ten")
	NumberToWords.numberToWords(100L) should equal ("one hundred")
	NumberToWords.numberToWords(1000L) should equal ("one thousand")
	NumberToWords.numberToWords(10000L) should equal ("ten thousand")
	NumberToWords.numberToWords(100000L) should equal ("one hundred thousand")
	NumberToWords.numberToWords(1000000L) should equal ("one million")
	NumberToWords.numberToWords(10000000L) should equal ("ten million")
	NumberToWords.numberToWords(100000000L) should equal ("one hundred million")
	NumberToWords.numberToWords(1000000000L) should equal ("one billion")
	NumberToWords.numberToWords(10000000000L) should equal ("ten billion")
	NumberToWords.numberToWords(100000000000L) should equal ("one hundred billion")
	NumberToWords.numberToWords(1000000000000L) should equal ("one trillion")
	NumberToWords.numberToWords(10000000000000L) should equal ("ten trillion")
	NumberToWords.numberToWords(100000000000000L) should equal ("one hundred trillion")
	NumberToWords.numberToWords(1000000000000000L) should equal ("one quadrillion")
	NumberToWords.numberToWords(10000000000000000L) should equal ("ten quadrillion")
	NumberToWords.numberToWords(100000000000000000L) should equal ("one hundred quadrillion")
	NumberToWords.numberToWords(1000000000000000000L) should equal ("one quintillion")
  }
  
  it should "handle all numbers from 2 to 20" in {
	NumberToWords.numberToWords(2) should equal ("two")
	NumberToWords.numberToWords(3) should equal ("three")
	NumberToWords.numberToWords(4) should equal ("four")
	NumberToWords.numberToWords(5) should equal ("five")
	NumberToWords.numberToWords(6) should equal ("six")
	NumberToWords.numberToWords(7) should equal ("seven")
	NumberToWords.numberToWords(8) should equal ("eight")
	NumberToWords.numberToWords(9) should equal ("nine")
	NumberToWords.numberToWords(10) should equal ("ten")
	NumberToWords.numberToWords(11) should equal ("eleven")
	NumberToWords.numberToWords(12) should equal ("twelve")
	NumberToWords.numberToWords(13) should equal ("thirteen")
	NumberToWords.numberToWords(14) should equal ("fourteen")
	NumberToWords.numberToWords(15) should equal ("fifteen")
	NumberToWords.numberToWords(16) should equal ("sixteen")
	NumberToWords.numberToWords(17) should equal ("seventeen")
	NumberToWords.numberToWords(18) should equal ("eighteen")
	NumberToWords.numberToWords(19) should equal ("nineteen")
	NumberToWords.numberToWords(20) should equal ("twenty")
  }
  
  it should "handle numbers in the range 21..99" in {
	NumberToWords.numberToWords(21) should equal ("twenty one")
	NumberToWords.numberToWords(32) should equal ("thirty two")
	NumberToWords.numberToWords(43) should equal ("forty three")
	NumberToWords.numberToWords(54) should equal ("fifty four")
	NumberToWords.numberToWords(65) should equal ("sixty five")
	NumberToWords.numberToWords(76) should equal ("seventy six")
	NumberToWords.numberToWords(87) should equal ("eighty seven")
	NumberToWords.numberToWords(98) should equal ("ninety eight")
  }
  
  it should "handle 5" in {
	NumberToWords.numberToWords(Long.MaxValue / 10) should equal ("nine hundred twenty two quadrillion three hundred thirty seven trillion two hundred three billion six hundred eighty five million four hundred seventy seven thousand five hundred eighty")
  }
    
  it should "handle 14" in {
	NumberToWords.numberToWords(999999) should equal ("nine hundred ninety nine thousand nine hundred ninety nine")
  }
  
  it should "handle 17" in {
	NumberToWords.numberToWords(1001000000101L) should equal ("one trillion one billion one hundred one")
  }
}