import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 좌표 정렬하기 문제<br>
 * 알고리즘 분류 : 정렬
 *
 * @author gglee
 */
public class Main {
  
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();

		// 좌표 정보를 담은 객체를 관리하는 리스트 선언
		List<Location> locationItems = new ArrayList<>();

		// 좌표 정보를 얻어서 Location 객체를 생성한다.
		for(int i = 0; i < N; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			locationItems.add(new Location(x, y));
		}

		// Collections 정적 클래스의 정렬 기능 사용
		// 해당 기능을 사용하기 위해서는 클래스가 Comparable 인터페이스를 구현해야 한다.
		Collections.sort(locationItems);

		for (Location locationItem : locationItems) {
			System.out.println(locationItem);
		}

		scanner.close();
	}
}

/**
 * 2차원 평면 좌표 정보를 담는 클래스<br>
 * 객체 정렬 기능을 수행하기 위해서 Comparable 인터페이스를 구현한다.
 *
 * @author gglee
 */
class Location implements Comparable<Location> {
	private int x; // 2차원 X 좌표
	private int y; // 2차원 Y 좌표

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

	@Override
	public int compareTo(Location otherLocation) {
		// X 좌표 위치 값을 비교하기 위해서 계산한다.
		int compareXPositionResult = this.x - otherLocation.x;

		// X 좌표 계산한 결과값이 0이 아닐 경우에만 즉시 반환한다.
		// 결과값이 0이라는 것은 두 개의 X 좌표가 같은 경우이므로 Y좌표 값을 계산한다.
		if (compareXPositionResult != 0) {
			return compareXPositionResult;
		}

		// Y 좌표 계산한 결과값을 반환한다.
		// X, Y 좌표가 동일한 지점은 없기 때문에 따로 더 계산을 수행하지 않는다.
		return this.y - otherLocation.y;
	}
}
