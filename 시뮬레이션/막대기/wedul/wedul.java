import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {

    private static final double initLength = 64;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double goalLength = sc.nextDouble();

        calcFindLengthCount(goalLength);
    }

    /**
     * 구하고자 하는 막대 값을 받고 구하는 함수
     * 
     * @param goalLength
     */
    private static void calcFindLengthCount(double goalLength) {
        Stack<Double> staffs = new Stack<>();
        staffs.push(initLength);

        while (!isEqaulGoalLength(staffs, goalLength)) {
            double minStaff = staffs.pop() / 2;

            staffs.push(minStaff);
            if (calStaffsLength(staffs) < goalLength) {
                staffs.push(minStaff);
            }

            if (isEqaulGoalLength(staffs, goalLength)) {
                break;
            }
        }

        System.out.print(staffs.size());
    }

    /**
     * 현재 막대 길의의 합이 목표의 합과 일치한지 확인
     * 
     * @param staffs
     * @param goalLength
     * @return
     */
    private static boolean isEqaulGoalLength(Stack<Double> staffs, double goalLength) {
        return calStaffsLength(staffs) == goalLength;
    }

    /**
     * 현재 막대의 합을 구하는 메서드
     * 
     * @param staffs
     * @return
     */
    private static double calStaffsLength(Stack<Double> staffs) {
        return staffs.stream().reduce(0.0, Double::sum);
    }
}

