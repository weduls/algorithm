import java.math.BigInteger;
import java.util.Scanner;

/**
 * 피보나치 수<br>
 * 알고리즘 유형 : 수학, 큰 수
 *
 * @author gglee
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();

		// 피보나치 첫 번째(0)와 두 번째 값(1)
		// long 데이터 타입보다 결과 값이 더 크기 때문에 큰 수를 표현하기 위해서
		// BigInteger 사용
		BigInteger bigInteger0 = BigInteger.ZERO;
		BigInteger bigInteger1 = BigInteger.ONE;

		if (number == 0) {
			System.out.println(bigInteger0);
			return;
		} else if (number == 1) {
			System.out.println(bigInteger1);
			return;
		}

		BigInteger bigIntegerResult;

		for (int i = 1; i <= number; i++) {
			bigIntegerResult = bigInteger0.add(bigInteger1);
			bigInteger0 = bigInteger1;
			bigInteger1 = bigIntegerResult;
		}

		System.out.println(bigInteger0);

		scanner.close();
	}
}
