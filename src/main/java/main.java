public class main {

    public static void main(String[] args) {

     int[][] gridFirstGen = {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };


        GenerationOne(gridFirstGen);


    }

    private static void GenerationOne(int[][] gridFirstGen) {
        System.out.println("Generation 1");
        loopGridAndPrint(gridFirstGen);
        System.out.println();
        CreateNewGeneration(gridFirstGen);
    }

    private static void loopGridAndPrint(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    System.out.print(".");
                } else
                    System.out.print("*");
            }

            System.out.println();

        }
    }

    static int[][] CreateNewGeneration(int[][] gridFirstGen) {

        int[][] gridNewGen = new int[gridFirstGen.length][gridFirstGen[0].length];

        for (int cordinateY = 1; cordinateY < gridFirstGen.length - 1; cordinateY++) {
            for (int cordinateX = 1; cordinateX < gridFirstGen[cordinateY].length - 1; cordinateX++) {

                int aliveNeighbours = 0;

                aliveNeighbours = getAliveNeighbours(gridFirstGen, cordinateY, cordinateX, aliveNeighbours);

                checkLifeStatusOfCells(gridFirstGen, gridNewGen, cordinateY, cordinateX, aliveNeighbours);

            }
        }


        System.out.println("Generation 2");
        loopGridAndPrint(gridNewGen);


        return gridNewGen;

    }

    public static int getAliveNeighbours(int[][] grid, int cordinateY, int cordinateX, int aliveNeighbours) {

        aliveNeighbours -= grid[cordinateY][cordinateX];

        for (int l = -1; l <= 1; l++) {
            for (int k = -1; k <= 1; k++) {
                aliveNeighbours += grid[cordinateY + l][cordinateX + k];

            }
        }

        return aliveNeighbours;
    }

    public static void checkLifeStatusOfCells(int[][] grid, int[][] newG, int cordinateY, int cordinateX, int aliveNeighbours) {

        if ((grid[cordinateY][cordinateX] == 1) && (aliveNeighbours < 2)) {
            changeStateOfCell(newG, cordinateY, cordinateX, 0);
        }

        else if ((grid[cordinateY][cordinateX] == 1) && (aliveNeighbours > 3))
            changeStateOfCell(newG, cordinateY, cordinateX, 0);

        else if ((grid[cordinateY][cordinateX] == 0) && (aliveNeighbours == 3  ))
            changeStateOfCell(newG, cordinateY, cordinateX, 1);
        else
            changeStateOfCell(newG, cordinateY, cordinateX, grid[cordinateY][cordinateX]);


    }

    private static void changeStateOfCell(int[][] newG, int cordinateY, int cordinateX, int aliveOrNot) {

        newG[cordinateY][cordinateX] = aliveOrNot;
    }


}
