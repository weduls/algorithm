import java.util.Scanner;

/**
 * 막대기 문제<br>
 * 알고리즘 유형 : 수학, 시뮬레이션
 *
 * @author gglee
 */
public class Main {

	// 처음 막대 크기
	private static int bar_length = 64;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Xcm 막대 크기
		int x = scanner.nextInt();

		// 막대 개수
		int bar_count = 0;

		while (x > 0) {
			if (bar_length > x) {
				bar_length /= 2;
			} else {
				bar_count++;
				x -= bar_length;
			}
		}

		System.out.println(bar_count);

		scanner.close();
	}
}
