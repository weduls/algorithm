import java.util.Scanner;

/**
 * 2차원 배열의 합 문제<br>
 * 알고리즘 유형 : DP
 * 
 * @author gglee
 */
public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 2차원 배열의 크기 N, M 크기를 입력 받는다.
		int N = scanner.nextInt();
		int M = scanner.nextInt();

		int[][] twoDimensionalArray = new int[N + 1][M + 1];

		// 각 배열의 원소 위치에 본래의(raw) 값을 넣는다.
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				twoDimensionalArray[i][j] = scanner.nextInt();
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

			resultArray[testCase] = computeRangeElement(twoDimensionalArray, i, j, x, y);
		}

		// 결과값 출력
		for (int element : resultArray) {
			System.out.println(element);
		}

		scanner.close();
	}

	/**
	 * 배열 원본과 부분 합을 구할 범위 값을 매개변수로 받아서, 해당 범위의 요소를 더한 값을 반환하는 메서드이다.
	 * 
	 * @param twoDimensionalArray int[][]
	 * @param startX int
	 * @param startY int
	 * @param endX int 
	 * @param endY int
	 * @return int
	 */
	private static int computeRangeElement(int[][] twoDimensionalArray, int startX, int startY, int endX, int endY) {
		// 결과값을 담는 변수
		int result = 0;

		/**
		 * 시작 위치(startX, startY) 와 마지막 위치(endX, endY) 정보를 이용해서<br>
		 * 루프를 돌면서 요소 값을 가져온 다음 결과값에 누적으로 더한다.
		 */
		for (int i = startX; i <= endX; i++) {
			for (int j = startY; j <= endY; j++) {
				result += twoDimensionalArray[i][j];
			}
		}

		return result;
	}
}
