package test;

import java.util.Scanner;

public class WedulDfs {
	private static StringBuilder sb = new StringBuilder();
	private static int cnt;
	private static int k;
	private static int arr[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while ((k = in.nextInt()) != 0) {
			// 배열 초기화
			arr = new int[13];
			
			for (int i = 0; i < k; i++) {
				arr[i] = in.nextInt();
			}

			// 로또 번호가 최소 6개이므로 k - 5 번째 까지만 처음 시작이 가능
			for (int i = 0; i < k - 5 ; i++) {
				cnt = 1;
				findLottoNum(i, String.valueOf(arr[i]));
			}
			
			// 결과 출력 및 sb 초기화
			System.out.print(sb.append("\n").toString());
			sb = new StringBuilder();
		}

		in.close();
	}

	public static void findLottoNum(int index, String str) {
		if (6 == cnt) {
			sb.append(str + "\n");
		} else {
			for (int i = index + 1; i < k; i++) {
				cnt++;
				findLottoNum(i, str + " " + arr[i]);
			}
		}
		
		// 백 트레킹 (하나씩 건너 뛰면서 가능한지 여부 확인)
		cnt--; 
	}
}
