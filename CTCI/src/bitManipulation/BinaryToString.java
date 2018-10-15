package bitManipulation;

public class BinaryToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bs = printBinary(.625);
		System.out.println(bs);
		
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = printBinary(num);
			//String binary2 = printBinary2(num);
			if (!binary.equals("ERROR")) {
				System.out.println(num + " : " + binary);
			}
		}

	}
	
	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
	
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() > 32) {
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}

}
