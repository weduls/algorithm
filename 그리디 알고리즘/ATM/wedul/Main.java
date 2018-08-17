import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 사람 수
        int peopleCnt = sc.nextInt();

        // 사람 별 기다리는 시간
        List<Integer> waitTimes = new LinkedList<>();

        for (int cnt = 0; cnt < peopleCnt; cnt ++) {
            insertSort(waitTimes, sc.nextInt());
        }

        // 가장 적게 기다릴 수 있는 시간 구하기
        calMinWaitTimeSum(peopleCnt, waitTimes);
    }

    /**
     * 데이터를 정렬하면서 삽입
     *
     * @param list
     * @param insertData
     */
    private static void insertSort(List<Integer> list, int insertData) {
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) > insertData) {
                list.add(index, insertData);
                return;
            }
        }

        list.add(insertData);
    }

    /**
     * 사람별 기다리는 최소 시간의 합
     *
     * @param peopleCnt
     * @param waitTimes
     */
    private static void calMinWaitTimeSum(int peopleCnt, List<Integer> waitTimes) {
        int timeSum = 0;

        for (int index = 0; index < waitTimes.size(); index++ ) {
            for (int subIndex = 0; subIndex <= index; subIndex++) {
                timeSum += waitTimes.get(subIndex);
            }
        }

        System.out.println(timeSum);
    }


}

