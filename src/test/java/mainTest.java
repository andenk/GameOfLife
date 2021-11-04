import org.junit.Test;


import static org.junit.Assert.*;

public class mainTest {

    main main = new main();

    int x = 8;
    int y = 8;
    int[][] ControllOfSpecificValue;

    int[][] inputValus = {{1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1}

    };
    int[][] testGeneral = {{0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}

    };
    @Test
    public void CheckIfGenOneIsAllDeadGEnTwoShoudeBeZero(){
        ControllOfSpecificValue = main.newGeneration(inputValus, y, x);

    }
    @Test
    public void LifeNotExistAroundEdges() {

        ControllOfSpecificValue = main.newGeneration(inputValus, y, x);
        x = x - 1;
        y = y - 1;

        assertEquals(1,inputValus[0][0]);
        assertEquals(1,inputValus[y][x]);

        assertEquals(0, ControllOfSpecificValue[0][0]);
        assertEquals(0, ControllOfSpecificValue[0][x]);
        assertEquals(0, ControllOfSpecificValue[y][0]);
        assertEquals(0, ControllOfSpecificValue[y][x]);
    }

    @Test
    public void testOutPutIsCorect() {


        assertArrayEquals(testGeneral, main.newGeneration(inputValus, y, x));

    }
    @Test
    public void testAlounCellDies() {

        assertEquals(0, inputValus[6][1]);

        inputValus[6][1] = 1;

        assertEquals(1, inputValus[6][1]);

        ControllOfSpecificValue = main.newGeneration(inputValus, y, x);

        assertArrayEquals(testGeneral, ControllOfSpecificValue);

        assertEquals(0, ControllOfSpecificValue[6][1]);
    }
    @Test
    public void testOverCroudedCellDies() {

        inputValus[5][4] = 1;
        inputValus[5][5] = 1;
        inputValus[5][6] = 1;
        inputValus[6][4] = 1;
        inputValus[6][5] = 1;

        testGeneral[4][5] = 1;
        testGeneral[5][4] = 1;
        testGeneral[5][6] = 1;
        testGeneral[6][4] = 1;
        testGeneral[6][6] = 1;


        assertEquals(1, inputValus[5][5]);
        assertEquals(1, inputValus[6][5]);

        ControllOfSpecificValue = main.newGeneration(inputValus, y, x);


        assertEquals(0, ControllOfSpecificValue[5][5]);
        assertEquals(0, ControllOfSpecificValue[6][5]);

    }

    @Test
    public void testCellLiveswhen3Neibours() {

        assertEquals(0, inputValus[1][3]);

        ControllOfSpecificValue = main.newGeneration(inputValus, y, x);

        assertEquals(1, ControllOfSpecificValue[1][3]);

    }


    @Test
    public void testCountAliveNeghbour(){
        assertEquals(2,main.getAliveNeighbours(inputValus, 2, 5,0));

    }
}