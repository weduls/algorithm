import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        Map<Integer, List<Integer>> datas = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // x 좌표를 키로 y 좌표들을 보관하고 있는 List를 value로 사용함.
            if (datas.containsKey(x)) {
                insertSort(datas.get(x), y);
            } else {
                List<Integer> dataList = new LinkedList<>();
                insertSort(dataList, y);
                datas.put(x, dataList);
            }
        }

        // 키 값들을 정렬한 후 stream에 foreach를 사용하여 정렬
        datas.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> {
            int key = e.getKey();
            for (Integer value : e.getValue()) {
                System.out.println(key + " " + value);
            }
        });
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

}

