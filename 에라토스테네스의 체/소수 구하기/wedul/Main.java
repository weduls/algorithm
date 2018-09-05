import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer> result = new ArrayList<>();

        // 순환
        for (int i = n; i <= m; i++) {
            if (isDecimal(i)) {
                result.add(i);
            }
        }

        // 결과 출력
        result.stream().forEach((e) -> {
            System.out.println(e);
        });

    }

    /**
     * 소수 체크
     *
     * @param num
     * @return
     */
    private static boolean isDecimal(int num) {

        if (1 == num) {
            return false;
        }

        /**
         * 자연수는 자신의 제곱근 이상의 수로 나눠지지 않는다는 조건을 이용해서, 자신의 제곱근 수 까지의 수로 나눠지는지 여부를 판단.
         */
        int sqrpData = new BigDecimal(Math.sqrt(num)).intValue();

        for (int i = 2; i <= sqrpData; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
