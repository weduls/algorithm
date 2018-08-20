import java.util.Scanner;

/**
 * 명령 프롬프트 문제<br>
 * 알고리즘 분류 : 문자열 처리
 *
 * @author gglee
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] searchTexItems;

		// 검색 문자열 개수를 입력 받는다.
		int N = scanner.nextInt();

		searchTexItems = new String[N];

		// 검색 문자열 값을 입력 받는다.
		for (int i = 0; i < N; i++) {
			searchTexItems[i] = scanner.next();
		}

		// 검색 문자열의 길이는 모두 동일하므로 첫 번째 검색 문자열의 길이를 구한다.
		int textLength = searchTexItems[0].length();

		// 첫 번째 검색 문자열 값을 char[] 형태로 데이터 타입을 변경한다.
		// 첫 번째 검색 문자열을 기준으로 다른 검색 문자열과 값을 비교하여 값을 변경한다.
		char[] arrCharFirstSearchText = searchTexItems[0].toCharArray();

		// 이미 첫 번째 검색 문자열은 값을 가져왔기 때문에 두 번째 검색 문자열부터 가져와서 비교한다.
		for (int i = 1; i < N; i++) {
			// 검색 문자열 값을 배열에서 가져와서 char[] 데이터 타입을 변경한다.
			char[] arrCharCompareSearchText = searchTexItems[i].toCharArray();

			// 문자열 길이만큼 루프를 반복하면서 char 값을 비교한다.
			// 문자 값이 서로 다르면 '?' 값으로 변경한다.
			for (int j = 0; j < textLength; j++) {
				if (arrCharFirstSearchText[j] != arrCharCompareSearchText[j]) {
					arrCharFirstSearchText[j] = '?';
				}
			}
		}

		System.out.println(arrCharFirstSearchText);

		scanner.close();
	}
}
