import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 소수 구하기 문제<br>
 * 알고리즘 분류 : 에라토스테네스의 체
 *
 * @author gglee
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int startNumber = scanner.nextInt();
		int endNumber = scanner.nextInt();

		List<Integer> primeNumbers = findPrimeNumberRange(startNumber, endNumber);

		// 소수 숫자 결과값 출력
		for (int primeNumber : primeNumbers) {
			System.out.println(primeNumber);
		}

		scanner.close();
	}

	/**
	 * 두 개의 숫자를 인자로 전달 받아서 범위 내에 있는 모든 소수를 찾아서 반환한다.
	 *
	 * @param startNumber int
	 * @param endNumber int
	 * @return List<Integer>
	 */
	private static List<Integer> findPrimeNumberRange(int startNumber, int endNumber) {
		List<Integer> primeNumbers = new ArrayList<>();

		for (int i = startNumber; i <= endNumber; i++) {
			// 소수인지 체크한다. 소수이면 List에 요소를 추가한다.
			if (isPrime(i)) {
				primeNumbers.add(i);
			}
		}

		return primeNumbers;
	}

	/**
	 * 인자로 전달 받는 숫자가 소수인지 판별하고 boolean 값을 반환한다.
	 *
	 * @param number int
	 * @return boolean
	 */
	private static boolean isPrime(int number) {
		// 숫자가 2보다 작으면 false 반환한다.
		if(number < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0) {
				return false;
			}
		}

		return true;
	}

}
