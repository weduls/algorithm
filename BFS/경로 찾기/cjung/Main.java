import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] arr = new int[n + 1][n + 1];

        // 입렵 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        // 경로 여부 확인 (플로이드 와샬)
        for (int k = 0; k < n; k++) {
            for (int h = 0; h < n; h++) {
                for (int w = 0; w < n; w++) {
                    if (arr[h][k] == 1 && arr[k][w] == 1)
                        arr[h][w] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
