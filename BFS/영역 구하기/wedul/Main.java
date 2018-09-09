import java.util.*;

public class Main {

    private static int M; // 세로
    private static int N; // 가로
    private static List<AreaWeightCntDto> areaWeightCntList = new ArrayList<>(); // 결과를 보관할 리스트
    private static List<Dot> visisted = new ArrayList<>();     // 방문여부를 체크할 리스트
    private static Set<Dot> box = new HashSet<>();             // box의 위치를 부여하는 hashset

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        M = in.nextInt();
        N = in.nextInt();
        int K = in.nextInt();

        // 공간 개수
        int areaCnt = 0;

        // 현재 박스의 위치 좌표를 모두 보관
        for (int i = 0; i < K; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            for (int tmpX = x1; tmpX < x2; tmpX++) {
                for (int tmpY = y1; tmpY < y2; tmpY++) {
                    box.add(new Dot(tmpX, tmpY));
                }
            }
        }

        //
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (enableGo(i, j)) {
                    ++areaCnt;
                    AreaWeightCntDto areaWeightCnt = new AreaWeightCntDto(1);
                    areaWeightCntList.add(areaWeightCnt);
                    visisted.add(new Dot(i, j));
                    getResult(i, j, areaWeightCnt);
                }
            }
        }

        // 결과 정렬
        areaWeightCntList.sort((o1, o2) -> {
            return o1.getCnt() > o2.getCnt() ? 1 : -1;
        });

        // 개수 출력
        System.out.println(areaCnt);

        // 출력
        areaWeightCntList.stream().forEach((e) -> {
            System.out.print(e.getCnt() + " ");
        });

    }

    /**
     * 공간들의 합을 저장할 Dto
     */
    static class AreaWeightCntDto {
        private int cnt;

        public AreaWeightCntDto(int cnt) {
            this.cnt = cnt;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        public void increCnt() {
            ++this.cnt;
        }
    }

    /**
     * 공간 넓이 구하기
     *
     * @param x
     * @param y
     * @param sum
     */
    private static void getResult(int x, int y, AreaWeightCntDto sum) {
        if (enableGo(x, y + 1)) {
            visisted.add(new Dot(x, y + 1));
            sum.increCnt();
            ;
            getResult(x, y + 1, sum);
        }

        if (enableGo(x + 1, y)) {
            visisted.add(new Dot(x + 1, y));
            sum.increCnt();
            getResult(x + 1, y, sum);
        }

        if (enableGo(x, y - 1)) {
            visisted.add(new Dot(x, y - 1));
            sum.increCnt();
            getResult(x, y - 1, sum);
        }

        if (enableGo(x - 1, y)) {
            visisted.add(new Dot(x - 1, y));
            sum.increCnt();
            getResult(x - 1, y, sum);
        }
    }

    /**
     * 해당 좌표가 지나갈 수 있는 좌표인지 여부 확인
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean enableGo(int x, int y) {
        // 경로 이탈 확인
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return false;
        }

        // 이미 방문했는지, 박스가 있는 위치인지 여부 확인.
        return (!box.contains(new Dot(x, y)) && !visisted.contains(new Dot(x, y)));
    }

    /**
     * 좌표를 담는 Dot 객체
     */
    static class Dot {

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int x;
        private int y;

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Dot)) {
                return false;
            }

            Dot tmp = (Dot) obj;

            return Objects.equals(this.x, tmp.x) && Objects.equals(this.y, tmp.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }

}
