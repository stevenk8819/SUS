import java.io.*;
import java.util.*; 

public class ImposterFinder {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner (new File("SUSPi.in"));
		ArrayList<Integer> pi = new ArrayList<Integer>(); 
		ArrayList<String> pi4 = new ArrayList<String>(); 
		int susIndex = 0; 
		int digits = 0; 
		String[] list = sc.nextLine().split(""); 
		for (int i = 0; i < list.length;i++) {
			pi.add(Integer.parseInt(list[i])); 
		}


		String sp = ""; 
		for (int i = 0; i < pi.size(); i++) {
			String s = regBinary(pi.get(i)); 
			sp += s; 

		}
		int place = getPlace(sp); 

		int count = 0; 
		String tempS = ""; 
		for (int i = 0; i < sp.length(); i++) {
			tempS += sp.charAt(i); 
			count++; 
			if (count == 4) {
				count = 0; 
				pi4.add(tempS); 
				tempS = ""; 
			}
		}

		for (int i = 0; i < pi4.size()-4; i++) {
			if (check1(pi4.get(i))) {
				if (check2(pi4.get(i+1))) {
					if (check3(pi4.get(i+2))) {
						if (check4(pi4.get(i+3))) {
							susIndex = i+3; 
						}
					}
				}

			}
		}

		for (int i = 0; i < susIndex+1; i++) {
			String s = pi4.get(i); 
//			System.out.println (s); 
			digits += 4; 
			if (i == susIndex-3) {
				System.out.println (""); 
			}
			for (int j = 0; j < 4; j++) {
				if (s.charAt(j) == '0') {
					System.out.print ("\u2B1C"); 
				}
				else {
					System.out.print ("\uD83D\uDFE5"); 
				}
			}
			System.out.println (""); 
		}
		System.out.println (digits + " binary digits"); 
	}

	public static String fourBinary(int n) {
		String ret = ""; 
		ret += Integer.toBinaryString(n); 
		if (ret.length() < 4) {
			while (ret.length() < 4) {
				ret = "0" + ret; 
			}
		}
		return ret; 
	}



	public static String regBinary(int n) {
		return Integer.toBinaryString(n); 
	}

	public static boolean check1(String s) {
		return (s.equals("0111")); 
	}
	public static boolean check2(String s) {
		return (s.equals("1100")); 
	}
	public static boolean check3(String s) {
		return (s.equals("1111")); 
	}
	public static boolean check4(String s) {
		return (s.equals("0101")); 
	}
	public static int getPlace(String s) {
		return s.indexOf("0111110011110101"); 
	}
}
