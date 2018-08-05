import java.util.Scanner;

/**
 * 로또 문제<br>
 * 알고리즘 유형 : BFS, 브루트 포스, DFS, 백트래킹
 *
 * @author gglee
 */
public class Main {

	private static int[] outputNumber;
	private static int[] inputNumber;
	private static int inputK;

	private static int ROTTO_NUM = 6;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		inputK = scanner.nextInt();

		while (inputK > 6 && inputK < 13) {

			// 로또 번호 후보 숫자 배열 생성한다.
			inputNumber = new int[inputK];
			outputNumber = new int[ROTTO_NUM];

			// 후보 숫자를 입력받는다.
			for (int i = 0; i < inputK; i++) {
				inputNumber[i] = scanner.nextInt();
			}

			// 로또 숫자를 찾는다.
			dfs(0, 0);

			System.out.println();

			// 다음 k를 입력받는다.
			// k의 값으로 0을 입력하게 되면 종료된다.
			inputK = scanner.nextInt();
		}

		scanner.close();
	}

	/**
	 * DFS 방법으로 로또 번호를 찾는다.
	 *
	 * @param startIndex int 로또 후보 숫자 배열 중에서 시작할 인덱스 값
	 * @param depth int 로또로 선택한 숫자
	 */
	private static void dfs(int startIndex, int depth) {
		if (depth == ROTTO_NUM) {
			for (int value : outputNumber) {
				System.out.print(value + " ");
			}
			System.out.println();
			return;
		}

		for (int i = startIndex; i < inputK; i++) {
			outputNumber[depth] = inputNumber[i];
			dfs(i + 1, depth + 1);
		}
	}

}
