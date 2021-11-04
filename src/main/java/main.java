public class main {

    public static void main(String[] args) {

        int Y = 8, X = 8;

        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };


        GenerationOne(Y, X, grid);


    }

    private static void GenerationOne(int y, int x, int[][] grid) {
        System.out.println("Generation 1");
        loopGridAndPrint(grid,y, x);
        System.out.println();
        newGeneration(grid, y, x);
    }

    private static void loopGridAndPrint(int[][] grid,int y, int x) {
    }

    static int[][] newGeneration(int[][] grid, int Y, int X) {
        int[][] newG = new int[Y][X];
        for (int i = 1; i < Y - 1; i++) {
            for (int j = 1; j < X - 1; j++) {

                int aliveNeighbours = 0;
                aliveNeighbours += grid[i][j];


                aliveNeighbours -= grid[i][j];
                // Any live cell with fewer than two live neighbors dies, as if caused by underpopulation

            }
        }



        return newG;

    }


}
