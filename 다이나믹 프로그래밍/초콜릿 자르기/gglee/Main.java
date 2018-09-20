import java.util.Scanner;

/**
 * 초콜릿 자르기 문제<br>
 * 알고리즘 분류 : DP
 *
 * @author gglee
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int M = scanner.nextInt();

		int size = N * M;

		System.out.println(size - 1);

		scanner.close();
	}
}
