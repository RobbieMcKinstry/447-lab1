class BaseConverter {

	public static void main(String[] args) {
		
		String number_string = args[0];
		String base_string = args[1];

		int decimal_int = toBaseTen(number_string, base_string);
		
		String decimal = "" + decimal_int;
		String binary = toBinary(decimal_int);
		String hex = toHex(decimal_int);
		
		decimal = pad(decimal, 5); // five is the max number of digits accepted	
		binary = pad(binary, 16); // max number of bits is 16 
		hex = pad(hex, 4); // max number of digits is 4
		
		System.out.println("Dec:\t" + decimal);
		System.out.println("Bin:\t" + binary);
		System.out.println("Hex:\t" + hex);

	} // end main method

	private static int toBaseTen(String number, String base_string) {
		int base = Integer.parseInt(base_string);
		int result = 0;	
		int val = 0;

		for( int i = 0; i < number.length(); i++) {
			char c = number.charAt(number.length() - 1 - i);
			String charAsString = (new Character(c)).toString();
			if (base != 16) {
				val = (int)(Integer.parseInt(charAsString) * Math.pow(base, i));
			}
			else {
				switch(c) {
					case 'a':
						val =  (int)(10 * Math.pow(base, i));
						break;
					case 'b':
						val = (int)(11 * Math.pow(base, i));
						break;
					case 'c':
						val = (int)(12 * Math.pow(base, i));
						break;
					case 'd':
						val = (int)(13 * Math.pow(base, i));
						break;
					case 'e':
						val = (int)(14 * Math.pow(base, i));
						break;
					case 'f':
						val = (int)(15 * Math.pow(base, i));
						break;
				}
			}
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

	private static String pad(String str, int maxSize) {
		while(str.length() < maxSize) {
			str = "0" + str; 
		}
		return str;
	}

} // end class
