package test;
import java.util.Arrays;
import java.util.Scanner;

public class Wedul {

	public enum InputType {
		ROWCNT {
			@Override
			public boolean isCheckRange(int... value) {
				return value[0] >= 1 && value[0] <= 300;
			}
		},
		COLCNT {
			@Override
			public boolean isCheckRange(int... value) {
				return value[0] >= 1 && value[0]<= 300;
			}
		},
		VALUE {
			@Override
			public boolean isCheckRange(int... value) {
				return value[0] >= 1 && value[0] <= 10000;
			}
		},
		CALRANGE {
			@Override 
			public boolean isCheckRange(int... value) {
				return value[0] <= value[1];
			}
		};
		
		public boolean isCheckRange(int... value) {
			return false;
		}
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int arrayRowCnt = scanner.nextInt();
		
		if (!InputType.ROWCNT.isCheckRange(arrayRowCnt)) {
			System.out.println("Row must 1 ~ 100 range.");
			scanner.close();
			return;
		}
		
		int arrayColCnt = scanner.nextInt();
		
		if (!InputType.COLCNT.isCheckRange(arrayRowCnt)) {
			System.out.println("Col must 1 ~ 100 range.");
			scanner.close();
			return;
		}
		
		int dp[][] = new int[301][301];
		
		// value ¹Þ±â
		for (int i = 1; i <= arrayRowCnt; i++) {
			for (int j = 1; j <= arrayColCnt; j++) {
				int value = scanner.nextInt();
				if (!InputType.VALUE.isCheckRange(value)) {
					
					System.out.println("Value must 1 ~ 10000");
					scanner.close();
					return;
				}
				
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + value;  
			}
		}
		
		int count = scanner.nextInt();
		for (int index = 0; index < count; index++) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			if (!InputType.CALRANGE.isCheckRange(i, x) ||
					!InputType.CALRANGE.isCheckRange(j, y)) {
				System.out.println("Range Error.");
				scanner.close();
				return;
			}
			
			System.out.println(dp[x][y] - dp[i - 1][y] - dp[x][j - 1] + dp[i - 1][j - 1]);
		}
		
		scanner.close();
	}
	
};