package j_numtowords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberToWords {

	private static final  Map<Long, String> smallNumberNameMap = new HashMap<Long, String>();
	static {
		smallNumberNameMap.put(0L, "");
		smallNumberNameMap.put(1L, "one");
		smallNumberNameMap.put(2L, "two");
		smallNumberNameMap.put(3L, "three");
		smallNumberNameMap.put(4L, "four");
		smallNumberNameMap.put(5L, "five");
		smallNumberNameMap.put(6L, "six");
		smallNumberNameMap.put(7L, "seven");
		smallNumberNameMap.put(8L, "eight");
		smallNumberNameMap.put(9L, "nine");
		smallNumberNameMap.put(10L, "ten");
		smallNumberNameMap.put(11L, "eleven");
		smallNumberNameMap.put(12L, "twelve");
		smallNumberNameMap.put(13L, "thirteen");
		smallNumberNameMap.put(14L, "fourteen");
		smallNumberNameMap.put(15L, "fifteen");
		smallNumberNameMap.put(16L, "sixteen");
		smallNumberNameMap.put(17L, "seventeen");
		smallNumberNameMap.put(18L, "eighteen");
		smallNumberNameMap.put(19L, "nineteen");
		smallNumberNameMap.put(20L, "twenty");
		smallNumberNameMap.put(30L, "thirty");
		smallNumberNameMap.put(40L, "forty");
		smallNumberNameMap.put(50L, "fifty");
		smallNumberNameMap.put(60L, "sixty");
		smallNumberNameMap.put(70L, "seventy");
		smallNumberNameMap.put(80L, "eighty");
		smallNumberNameMap.put(90L, "ninety");
		smallNumberNameMap.put(100L, "hundred");
	}
	
	private static final String[] largeNumberNames = { "", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion" };
	
	public static String numberToWords(final long i) {
		return i < 0?
				"minus " + numberToWords(-i) :
					i == 0?
							"zero" :
								normaliseWhiteSpace(convert(i, 0));
	}

	private static String convert(final Long i, final int largeNumberNamesIndex) {
	    if (i > 0) {
	        return convert(i / 1000, largeNumberNamesIndex + 1) + " " + convertNamedLargeNumber(i % 1000, largeNumberNames[largeNumberNamesIndex]);
	    } else {
	    	return "";		
	    }
	}
	
	private static String convertNamedLargeNumber(final long i, final String largeNumberName) {
	    if (i > 0) {
	        return convertHundreds(i / 100) + " " +  convertTens(i % 100) + " " + largeNumberName;
	    } else {
	    	return "";
	    }
	}
	
	private static String convertHundreds(final Long i) {
		if (i > 0) {
			return smallNumberNameMap.get(i) + " " + smallNumberNameMap.get(100L);
		} else {
			return "";			
		}
	}
	
	private static String convertTens(final Long i) {
		if (i <= 20) {
			return smallNumberNameMap.get(i);
		} else {
			final long units = i % 10;
			return (smallNumberNameMap.get(i - units) + " " + smallNumberNameMap.get(units)).trim();			
		}
	}
	
	private static String normaliseWhiteSpace(final String s) {
		return s.trim().replaceAll("\\s+", " ");
	}
}
