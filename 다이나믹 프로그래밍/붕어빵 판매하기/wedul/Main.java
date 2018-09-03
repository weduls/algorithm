import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] pi = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++)
            pi[i] = in.nextInt();

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;

            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + pi[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
