package j_numtowords;

import junit.framework.TestCase;

public class NumberToWordsTest extends TestCase {
	
	public void testZero() {
		assertEquals("zero", NumberToWords.numberToWords(0L));
	}
	
	public void testNegativeInput() {
		System.out.println(NumberToWords.numberToWords(-1L));
		assertEquals("minus one", NumberToWords.numberToWords(-1L));
	}
	
	public void testPositiveInput() {
		assertEquals("one", NumberToWords.numberToWords(1L));
	}
	
	public void testPowersOfTen() {
		assertEquals("ten", NumberToWords.numberToWords(10L));
		assertEquals("one hundred", NumberToWords.numberToWords(100L));
		assertEquals("one thousand", NumberToWords.numberToWords(1000L));
		assertEquals("ten thousand", NumberToWords.numberToWords(10000L));
		assertEquals("one hundred thousand", NumberToWords.numberToWords(100000L));
		assertEquals("one million", NumberToWords.numberToWords(1000000L));
		assertEquals("ten million", NumberToWords.numberToWords(10000000L));
		assertEquals("one hundred million", NumberToWords.numberToWords(100000000L));
		assertEquals("one billion", NumberToWords.numberToWords(1000000000L));
		assertEquals("ten billion", NumberToWords.numberToWords(10000000000L));
		assertEquals("one hundred billion", NumberToWords.numberToWords(100000000000L));
		assertEquals("one trillion", NumberToWords.numberToWords(1000000000000L));
		assertEquals("ten trillion", NumberToWords.numberToWords(10000000000000L));
		assertEquals("one hundred trillion", NumberToWords.numberToWords(100000000000000L));;
		assertEquals("one quadrillion", NumberToWords.numberToWords(1000000000000000L));
		assertEquals("ten quadrillion", NumberToWords.numberToWords(10000000000000000L));
		assertEquals("one hundred quadrillion", NumberToWords.numberToWords(100000000000000000L));
		assertEquals("one quintillion", NumberToWords.numberToWords(1000000000000000000L));
	}

	public void testNumbersFromOneToTwenty() {
		assertEquals("two", NumberToWords.numberToWords(2));
		assertEquals("three", NumberToWords.numberToWords(3));
		assertEquals("four", NumberToWords.numberToWords(4));
		assertEquals("five", NumberToWords.numberToWords(5));
		assertEquals("six", NumberToWords.numberToWords(6));
		assertEquals("seven", NumberToWords.numberToWords(7));
		assertEquals("eight", NumberToWords.numberToWords(8));
		assertEquals("nine", NumberToWords.numberToWords(9));
		assertEquals("ten", NumberToWords.numberToWords(10));
		assertEquals("eleven", NumberToWords.numberToWords(11));
		assertEquals("twelve", NumberToWords.numberToWords(12));
		assertEquals("thirteen", NumberToWords.numberToWords(13));
		assertEquals("fourteen", NumberToWords.numberToWords(14));
		assertEquals("fifteen", NumberToWords.numberToWords(15));
		assertEquals("sixteen", NumberToWords.numberToWords(16));
		assertEquals("seventeen", NumberToWords.numberToWords(17));
		assertEquals("eighteen", NumberToWords.numberToWords(18));
		assertEquals("nineteen", NumberToWords.numberToWords(19));
		assertEquals("twenty", NumberToWords.numberToWords(20));
	}
	
	public void test21To99() {
		assertEquals("twenty one", NumberToWords.numberToWords(21));
		assertEquals("thirty two", NumberToWords.numberToWords(32));
		assertEquals("forty three", NumberToWords.numberToWords(43));
		assertEquals("fifty four", NumberToWords.numberToWords(54));
		assertEquals("sixty five", NumberToWords.numberToWords(65));
		assertEquals("seventy six", NumberToWords.numberToWords(76));
		assertEquals("eighty seven", NumberToWords.numberToWords(87));
		assertEquals("ninety eight", NumberToWords.numberToWords(98));
	}
	
	public void testLargeNumber1() {
		assertEquals("nine hundred twenty two quadrillion three hundred thirty seven trillion two hundred three billion six hundred eighty five million four hundred seventy seven thousand five hundred eighty", NumberToWords.numberToWords(Long.MAX_VALUE / 10));
	}
	
	public void test999999() {
		assertEquals("nine hundred ninety nine thousand nine hundred ninety nine", NumberToWords.numberToWords(999999));
	}
	
	public void testLargeNumber2() {
		assertEquals("one trillion one billion one hundred one", NumberToWords.numberToWords(1001000000101L));
	}
}
