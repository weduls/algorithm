import java.util.Scanner;

/**
 * 2차원 배열의 합 문제<br>
 * 알고리즘 유형 : DP
 * 
 * @author gglee
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 2차원 배열의 크기 N, M 크기를 입력 받는다.
		int N = scanner.nextInt();
		int M = scanner.nextInt();

		int[][] arrData = new int[N + 1][M + 1];

		// 처음 배열에 값을 넣을 때, 각 위치까지의 합을 배열의 요소로 넣는다.
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arrData[i][j] = arrData[i - 1][j] + arrData[i][j - 1] - arrData[i - 1][j - 1] + scanner.nextInt();
			}
		}

		// 테스트 케이스 수를 입력 받는다.
		int K = scanner.nextInt();
		int[] resultArray = new int[K];

		int i, j, x, y;

		for (int testCase = 0; testCase < K; testCase++) {
			i = scanner.nextInt();
			j = scanner.nextInt();
			x = scanner.nextInt();
			y = scanner.nextInt();

			/**
			 * 각 배열의 요소 값들은 이미 시작위치(1,1) 부터 해당 위치(?,?) 까지 더한 값이 들어 있다. 두 개의 영역([i-1][y],
			 * [x][j-1]) 을 빼고, 중복된 영역([i-1][j-1] 을 더한다.
			 */
			resultArray[testCase] = arrData[x][y] + arrData[i - 1][j - 1] - arrData[i - 1][y] - arrData[x][j - 1];
		}

		// 결과값 출력
		for (int element : resultArray) {
			System.out.println(element);
		}

		scanner.close();
	}
}
