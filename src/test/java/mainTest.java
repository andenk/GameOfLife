import org.junit.Test;


import static org.junit.Assert.*;

public class mainTest {

    main main = new main();

    int[][] inputValus = {{1, 0, 0},
            {0, 0, 0},
            {0, 1, 1}
    };
    int[][] testGeneral = {{0, 0, 0},
            {0, 1, 0},
            {0, 0, 0},
    };

    @Test
    public void CheckTestGenerationyisEmptyWhenInputValueIsEmpty() {

        int[][] inputValus = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };
        int[][] testGeneral = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };
        assertArrayEquals(testGeneral, main.CreateNewGeneration(inputValus));
    }

    @Test
    public void AllCellOnEdgesDies() {

        assertEquals(0, main.CreateNewGeneration(inputValus)[0][0]);
        assertEquals(0, main.CreateNewGeneration(inputValus)[0][inputValus.length - 1]);
        assertEquals(0, main.CreateNewGeneration(inputValus)[inputValus[0].length - 1][0]);
        assertEquals(0, main.CreateNewGeneration(inputValus)[inputValus[0].length - 1][inputValus.length - 1]);

        assertEquals(0, main.CreateNewGeneration(inputValus)[2][1]);
    }

    @Test
    public void CheckAllOfTheInputValueAgenstTestGEneration() {

        assertArrayEquals(testGeneral, main.CreateNewGeneration(inputValus));

    }

    @Test
    public void CellWithZeroNegiboursDies() {

        int[][] inputValus = {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };
        int[][] testGeneral = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };


        assertArrayEquals(testGeneral, main.CreateNewGeneration(inputValus));
        assertEquals(0, main.CreateNewGeneration(inputValus)[1][1]);

    }

    @Test
    public void testOverCroudedCellDies() {

        int[][] inputValus = {{0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        assertEquals(0, main.CreateNewGeneration(inputValus)[2][1]);
    }

    @Test
    public void CellLivesWhenItHas3Neibours() {

        assertEquals(1, main.CreateNewGeneration(inputValus)[1][1]);
    }


    @Test
    public void CountAliveNeghbours() {

        assertEquals(3, main.getAliveNeighbours(inputValus, 1, 1, 0));

    }
}