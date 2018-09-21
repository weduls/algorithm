import java.util.Scanner;

/**
 * 섬의 개수 문제<br>
 * 알고리즘 분류 : 그래프 알고리즘
 *
 * @author gglee
 */
public class Main {

	private static int map[][] = null;
	private static boolean visited[][] = null;

	// 왼쪽, 위쪽, 오른쪽, 아래쪽, 대각선 4개 방향
	private static int nx[] = {-1, 0, 1, 0, -1, 1, -1, 1};
	private static int ny[] = {0, 1, 0, -1, 1, 1, -1, -1};

	private static int w = 0;
	private static int h = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int count = 0;

		w = scanner.nextInt();
		h = scanner.nextInt();

		while(w != 0 && h != 0) {

			map = new int[h][w];
			visited = new boolean[h][w];

			// 맵 입력 받는다.
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = scanner.nextInt();
				}
			}

			// 섬의 개수 변수 초기화
			count = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}

			System.out.println(count);

			w = scanner.nextInt();
			h = scanner.nextInt();
		}

		scanner.close();
	}

	/**
	 * 깊이 우선 탐색을 통해서 연결된 섬을 방문한다.
	 *
	 * @param x int
	 * @param y int
	 */
	private static void dfs(int x, int y) {
		visited[x][y] = true;

		int ax, ay;

		// 현재 위치를 기준으로 아래, 위, 왼쪽, 오른쪽, 대각선 방향으로 이동한다.
		for (int i = 0; i < 8; i++) {
			ax = x + nx[i];
			ay = y + ny[i];

			// 좌표 값이 벗어났는지 체크한다.
			if (ax >= h || ax < 0 || ay >= w || ay < 0) {
				continue;
			}

			if (!visited[ax][ay] && map[ax][ay] == 1) {
				dfs(ax, ay);
			}
		}
	}

}
