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
        loopGridAndPrint(grid, y, x);
        System.out.println();
        newGeneration(grid, y, x);
    }

    private static void loopGridAndPrint(int[][] grid, int y, int x) {

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == 0) {
                    System.out.print(".");
                } else
                    System.out.print("*");
            }
            System.out.println();

        }
    }

    static int[][] newGeneration(int[][] grid, int Y, int X) {
        int[][] newG = new int[Y][X];
        for (int i = 1; i < Y - 1; i++) {
            for (int j = 1; j < X - 1; j++) {

                int aliveNeighbours = 0;

                // hämta hur många grannar som lever grannarna
                aliveNeighbours = getAliveNeighbours(grid, i, j, aliveNeighbours);

                checkLifeStatusOfCells(grid, newG, i, j, aliveNeighbours);

            }
        }


        System.out.println("Generation 2");
        loopGridAndPrint(newG, Y, X);


        return newG;

    }

    private static int getAliveNeighbours(int[][] grid, int i, int j, int aliveNeighbours) {

        aliveNeighbours -= grid[i][j]; // Ta bort orginal cellen från grannar

        for (int l = -1; l <= 1; l++) {
            for (int k = -1; k <= 1; k++) {
                aliveNeighbours += grid[i + l][j + k];

            }
        }

        return aliveNeighbours;
    }

    public static void checkLifeStatusOfCells(int[][] grid, int[][] newG, int i, int j, int aliveNeighbours) {
        //  har en cell färe en 2 grannar dö
        if ((grid[i][j] == 1) && (aliveNeighbours < 2)) {
            changeStateOfCell(newG, i, j, 0);
        }

        // celler med fler än 3 neighbors dör för mycket folk
        else if ((grid[i][j] == 1) && (aliveNeighbours > 3))
            changeStateOfCell(newG, i, j, 0);

            //om cell är död och har tre grannar vakna
        else if ((grid[i][j] == 0) && (aliveNeighbours == 3))
            changeStateOfCell(newG, i, j, 1);

            //låt den vara
        else
            changeStateOfCell(newG, i, j, grid[i][j]);


    }

    private static void changeStateOfCell(int[][] newG, int i, int j, int aliveOrNot) {
        newG[i][j] = aliveOrNot;
    }


}
