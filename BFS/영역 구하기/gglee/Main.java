import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 영역 구하기 문제<br>
 * 알고리즘 분류 : BFS, DFS
 *
 * @author gglee
 */
public class Main {

	/**
	 * 상하좌우 방향 enum
	 *
	 * @author gglee
	 */
	enum Direction {
		Up(0, 1),
		Down(0, -1),
		Left(-1, 0),
		Right(1, 0);

		private int x;
		private int y;

		Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static boolean[][] gridPaper;

	private static int M;
	private static int N;

	private static int sum;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		M = scanner.nextInt();
		N = scanner.nextInt();
		int K = scanner.nextInt();

		gridPaper = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					gridPaper[y][x] = true;
				}
			}
		}

		List<Integer> regionSums = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				computeRegionArea(i, j);

				// 영역 넓이 값이 0보다 큰 경우만 regionSums 리스트에 추가한다.
				if (sum > 0) {
					regionSums.add(sum);
				}

				// 다른 영역의 넓이 값을 저장하기 위해서 sum 변수 초기화한다.
				sum = 0;
			}
		}

		// 영역 개수 출력
		System.out.println(regionSums.size());

		// 리스트 요소를 정렬한다.
		Collections.sort(regionSums);

		for (int regionSum : regionSums) {
			System.out.print(regionSum + " ");
		}

		scanner.close();
	}

	/**
	 * DFS 알고리즘을 이용하여 <code>gridPaper</code> 영역을 순회한다. 방문한 지점이면 true로
	 * 변경하고, sum 변수의 값을 증가시킨다.
	 *
	 * @param x int
	 * @param y int
	 */
	private static void computeRegionArea(int x, int y) {
		if (!isValidationPoint(x, y)) {
			return;
		}

		gridPaper[x][y] = true;
		sum++;

		// 현재 좌표를 기준으로 상하좌우 위치로 이동한다.
		for (Direction direction : Direction.values()) {
			computeRegionArea(x + direction.x, y + direction.y);
		}

	}

	/**
	 * 인자로 전달된 x,y 좌표가 유효한 값인지 체크하고 boolean 값을 반환한다.
	 *
	 * @param x int
	 * @param y int
	 * @return boolean
	 */
	private static boolean isValidationPoint(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N) {
			return false;
		}

		if (gridPaper[x][y]) {
			return false;
		}

		return true;
	}

}
