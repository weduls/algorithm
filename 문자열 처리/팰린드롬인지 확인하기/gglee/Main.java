import java.util.Scanner;

/**
 * 팰린드롬(회문)인지 확인하기 문제<br>
 * 알고리즘 분류 : 문자열 처리
 * 
 * @author gglee
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 팰린드롬인지 확인해야 할 문자열을 입력 받는다.
		String inputText = scanner.next();

		// 결과값 출력
		System.out.println(isPalindrome(inputText) == true ? 1 : 0);

		scanner.close();
	}

	/**
	 * 파라미터로 넘어온 문자열 값이 팰린드롬인지 아닌지 판단하고 boolean 값을 반환하는 메서드이다.<br>
	 * 문자열이 팰린드롬이면 true 값을 반환하고, 팰린드롬이 아니면 false 값을 반환한다.
	 * 
	 * @param inputText String
	 * @return boolean
	 */
	private static boolean isPalindrome(String inputText) {
		int textLength = inputText.length();

		/**
		 *  처음 문자와 마지막 문자를 비교하고, 각 인덱스를 옮겨가며 계속 비교한다.
		 *  비교 범위는 문자열의 중간 위치까지만 지정한다.
		 */
		for (int i = 0; i < (textLength / 2); i++) {
			int rearIndex = textLength - 1 - i;
			if (!(inputText.charAt(i) == inputText.charAt(rearIndex))) {
				return false;
			}
		}
		return true;
	}

}