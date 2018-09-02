import java.util.Arrays;
import java.util.Scanner;

/**
 * 경로찾기 문제<br>
 * 알고리즘 분류 : DFS
 *
 * @author gglee
 */
public class Main {

	// 정점 개수
	private static int N;

	// 각 정점에 방문했는지 체크하는 변수
	private static boolean[] visitedVertex;

	// 처음 입력 받는 인접 행렬
	private static int[][] originalMatrix;

	// 방문할 수 있는 경로를 체크한 인접 행렬
	private static int[][] visitedMatrix;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 정점의 개수를 입력받는다.
		N = scanner.nextInt();

		originalMatrix = new int[N + 1][N + 1];
		visitedMatrix = new int[N + 1][N + 1];
		visitedVertex = new boolean[N + 1];

		// 인접 행렬 원본 데이터를 받아서 배열에 저장한다.
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				originalMatrix[i][j] = scanner.nextInt();
			}
		}

		// 정점을 기준으로 연결되었는지 여부를 체크한다.
		for (int i = 1; i <= N; i++) {
			// 경로를 찾는다.
			findEdgePathByDFS(i);

			// 방문할 수 있는 경로 값을 담은 visitedVertex 배열을 기준으로
			// visitedMatrix 배열에 값을 설정한다.
			for (int j = 1; j <= N; j++) {
				if (visitedVertex[j]) {
					visitedMatrix[i][j] = 1;
				}
			}

			// 방문 체크하는 배열을 초기화한다.
			Arrays.fill(visitedVertex, false);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(visitedMatrix[i][j] + " ");
			}
			System.out.println();
		}

		scanner.close();
	}

	/**
	 * DFS 알고리즘 재귀 방법을 이용해서 첫 번째 경로를 찾으면, 다음 이어진 경로를 이어서 계속 찾는다.<br>
	 * 입력 예제 중 아래와 같은 인접 행렬이 있다. 처음에 (1,2) 경로를 찾고 다음 경로는 (2,3) -> (3,1)
	 * 이어져 있다.
	 *
	 * <pre>
	 * 0 1 0
	 * 0 0 1
	 * 1 0 0
	 * </pre>
	 */
	private static void findEdgePathByDFS(int startVertex) {
		for(int i = 1; i <= N; i++) {
			// 정점에 방문했는지 여부와 방문할 수 있는지 값을 체크한다.
			if(!visitedVertex[i] && originalMatrix[startVertex][i] == 1) {
				visitedVertex[i] = true;
				findEdgePathByDFS(i);
			}
		}
	}

}
