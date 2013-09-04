class BaseConverter {

	public static void main(String[] args) {
		
		String number_string = args[0];
		String base_string = args[1];

		int decimal_int = toBaseTen(number_string, base_string);
		String decimal = "" + decimal_int;
		
		String binary = toBinary(decimal_int);
		String hex = toHex(decimal_int);

		System.out.println("Dec:\t" + decimal);
		System.out.println("Bin:\t" + binary);
		System.out.println("Hex:\t" + hex);

	} // end main method

	private static int toBaseTen(String number, String base_string) {
		int base = Integer.parseInt(base_string);
		
		int result = 0;	

		for( int i = 0; i < number.length(); i++) {
			char c = number.charAt(number.length() - 1 - i);
			int val = (int)(Integer.parseInt((new Character(c)).toString()) * Math.pow(base, i));
			result += val;
		}
		return result;
	}

	private static String toBinary(int decimal) {
		
		StringBuilder result = new StringBuilder("");
		if (decimal == 0) {
			return "" + 0;
		}
		int remainder = 0;

		while(decimal > 0) {
			remainder = decimal % 2;
			decimal /= 2;
			result.append(remainder);
		}
		return result.reverse().toString();
	}

	private static String toHex(int decimal) {
		
		StringBuilder result = new StringBuilder("");
		if (decimal == 0) {
			return "" + 0;
		}
		int remainder = 0;
		
		while(decimal > 0) {
			remainder = decimal % 16;
			decimal /= 16;

			switch(remainder) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
					result.append(remainder);
					break;
				case 10:
					result.append("a");
					break;
				case 11:
					result.append("b");
					break;
				case 12:
					result.append("c");
					break;
				case 13:
					result.append("d");
					break;
				case 14:
					result.append("e");
					break;
				case 15:
					result.append("f");
					break;
			} // end switch
		} // end while
		return result.reverse().toString();

	} // end method

} // end class