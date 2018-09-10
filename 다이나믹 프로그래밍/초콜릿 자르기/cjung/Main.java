초콜릿
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        int result = 0;

        for (int i = 0 ; i <N; i++) {
            for (int j =0; j< M; j++) {
                ++result;
            }
        }

        System.out.println(result - 1);
    }

}
