import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 파일 개수 입력
        int wordCnt = sc.nextInt();

        // 첫 번째 파일이름
        char[] creteria = sc.next().toCharArray();

        // 나머지 파일들 이름을 받으면서 Regex todtjd
        for (int i = 1; i < wordCnt; i++) {
            String fileName = sc.next();

            // 첫 번째 이름을 기준으로 이름이 다른 부분에 대해서 ? 처리
            for (int j = 0; j < creteria.length; j++) {
                char data = creteria[j];

                if (data != '?') {
                    if (data != fileName.charAt(j)) {
                        creteria[j] = '?';
                    }
                }
            }
        }

        for (char ch : creteria) {
            System.out.print(ch);
        }
    }

}

