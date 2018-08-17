import java.util.Scanner;

/**
 * ATM 문제<br>
 * 알고리즘 분류 : 그리디
 *
 * @author gglee
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 인출 시간을 담을 배열
		int[] injectionTimeItems;

		// 사람 수를 입력 받는다.
		int N = scanner.nextInt();

		injectionTimeItems = new int[N];

		// 인출 시간을 입력 받는다.
		for (int i = 0; i < N; i++) {
			injectionTimeItems[i] = scanner.nextInt();
		}

		// 최소 인출 시간부터 선택하기 위해서 정렬
		// 정렬 알고리즘은 버블 정렬
		bubbleSort(injectionTimeItems);

		// 인출 시간의 합 계산
		int result = computeTotalInjectionTime(injectionTimeItems);

		// 결과 출력
		System.out.println(result);

		scanner.close();
	}

	/**
	 * 버블 정렬 알고리즘을 사용해서 전달 받은 배열을 오름차순으로 정렬한다.
	 *
	 * @param injectionTimeItems int[] 돈 인출하는 시간을 담은 정보
	 */
	private static void bubbleSort(int[] injectionTimeItems) {
		int timeItemSize = injectionTimeItems.length;
		for (int i = 0; i < timeItemSize - 1; i++) {
			for (int j = 0; j < timeItemSize - i - 1; j++) {
				if (injectionTimeItems[j] > injectionTimeItems[j + 1]) {
					int temp = injectionTimeItems[j];
					injectionTimeItems[j] = injectionTimeItems[j + 1];
					injectionTimeItems[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 각 사람들의 돈을 인출한 시간의 총합을 계산해서 반환한다.
	 *
	 * @param injectionTimeItems int[] 돈 인출하는 시간을 담은 정보
	 * @return int 모든 사람들이 돈 인출하는 시간의 합
	 */
	private static int computeTotalInjectionTime(int[] injectionTimeItems) {
		int tiemItemSize = injectionTimeItems.length;

		// 모든 사람들의 돈을 인출하는데 필요한 시간의 합
		int totalTimeSum = 0;

		int peopleInjectionTime = 0;
		for (int i = 0; i < tiemItemSize; i++) {
			// 이전 사람의 인출 시간과 현재 사람의 인출 시간을 더한다.
			peopleInjectionTime += injectionTimeItems[i];

			// 각 사람들의 돈을 인출하는 시간 값을 최종 결과값 변수에 더한다.
			totalTimeSum += peopleInjectionTime;
		}

		return totalTimeSum;
	}

}
