import java.util.Scanner;

/**
 * 붕어빵 판매하기 문제<br>
 * 알고리즘 분류 : DP
 *
 * @author gglee
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();

		// 각 묶음별 가격
		int[] priceItems = new int[N + 1];

		// 각 묶음별 최대 가격
		int[] maxPriceItems = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			priceItems[i] = scanner.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			// 최대 가격 임시 변수
			int tempMaxPrice = 0;

			// N이 3일 때,
			// 1개 묶음 단일 가격 + N이 2일 때 최대 가격
			// 2개 묶음 단일 가격 + N이 1일 때 최대 가격
			// 3개 묶음 단일 가격 + N이 0일 때 최대 가격
			for (int j = 1; j <= i; j++) {
				tempMaxPrice = Math.max(tempMaxPrice, priceItems[j] + maxPriceItems[i - j]);
			}

			maxPriceItems[i] = tempMaxPrice;
		}

		// N일 때 최대 가격
		System.out.println(maxPriceItems[N]);

		scanner.close();
	}
}
