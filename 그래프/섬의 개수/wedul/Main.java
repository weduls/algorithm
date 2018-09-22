import java.util.*;

public class Main {

    public static void main(String[] args) {

        // 붕어빵 개수
        Scanner sc = new Scanner(System.in);
        List<LandDto> lands = new ArrayList<>();

        while (true) {
            int weight = sc.nextInt();
            int height = sc.nextInt();

            if (weight == 0 && height == 0) {
                break;
            }

            int[][] dataMatrix = new int[height][weight];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < weight; x++) {
                    dataMatrix[y][x] = sc.nextInt();
                }
            }

            lands.add(new LandDto(weight, height, dataMatrix, new boolean[height][weight]));
        }

        lands.forEach(land -> {
            calLandCount(land);
        });

    }

    private static void calLandCount(LandDto landDto) {
        int count = 0;
        for (int y = 0; y < landDto.getHeight(); y++) {
            for (int x = 0; x < landDto.getWeight(); x++) {
                if (!landDto.getVisited()[y][x]) {
                    if (landDto.getDataMatrix()[y][x] == 1) {
                        count++;
                        findLand(x, y, landDto);
                    } else {
                        landDto.getVisited()[y][x] = true;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static void findLand(int x, int y, LandDto landDto) {
        landDto.getVisited()[y][x] = true;

        if (checkIsGo(x + 1, y, landDto)) {
            findLand(x + 1, y, landDto);
        }

        if (checkIsGo(x + 1, y - 1, landDto)) {
            findLand(x + 1, y - 1, landDto);
        }

        if (checkIsGo(x, y - 1, landDto)) {
            findLand(x, y - 1, landDto);
        }

        if (checkIsGo(x - 1, y - 1, landDto)) {
            findLand(x - 1, y - 1, landDto);
        }

        if (checkIsGo(x - 1, y, landDto)) {
            findLand(x - 1, y, landDto);
        }

        if (checkIsGo(x - 1, y + 1, landDto)) {
            findLand(x - 1, y + 1, landDto);
        }

        if (checkIsGo(x, y + 1, landDto)) {
            findLand(x, y + 1, landDto);
        }

        if (checkIsGo(x + 1, y + 1, landDto)) {
            findLand(x + 1, y + 1, landDto);
        }

    }

    private static boolean checkIsGo(int x, int y, LandDto landDto) {
        return x >= 0 && y >= 0 && x < landDto.getWeight() && y < landDto.getHeight() && landDto.getDataMatrix()[y][x] == 1 && !landDto.getVisited()[y][x];
    }

    static class LandDto {
        private int weight;
        private int height;

        private int[][] dataMatrix;
        private boolean[][] visited;

        LandDto(int weight, int height, int[][] dataMatrix, boolean[][] visited) {
            this.weight = weight;
            this.height = height;
            this.dataMatrix = dataMatrix;
            this.visited = visited;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        public int[][] getDataMatrix() {
            return dataMatrix;
        }

        public boolean[][] getVisited() {
            return visited;
        }

    }

}

