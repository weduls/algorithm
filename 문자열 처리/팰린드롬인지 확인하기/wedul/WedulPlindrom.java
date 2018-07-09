package test;

import java.util.Scanner;

public class WedulPlindrom {
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String in = scanner.next();
		
		System.out.println(checkPalindrom(in));
		
		scanner.close();
	}
	
	/**
	 * 팰린드롬 체크
	 * 
	 * @param arg
	 * @return
	 */
	private static int checkPalindrom(String arg) {
		int j = arg.length() - 1;
		for (int i = 0; i < arg.length() / 2; i++, j--) {
			if (arg.charAt(i) != arg.charAt(j)) {
				return 0;
			}
		}
		
		return 1;
	}

}
