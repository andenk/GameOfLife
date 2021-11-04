import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class mainTest {

    main main = new main();

    int x = 8;
    int y = 8;
    int[][] ControllOfSpecificValue;

    int[][] inputValus = {{1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
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
        // all edges ar dead

        ControllOfSpecificValue = main.newGeneration(inputValus, y, x);
        x = x - 1;
        y = y - 1;
        //check old inputArray that edges is alive
        assertEquals(1,inputValus[0][0]);
        assertEquals(1,inputValus[y][x]);

        // check that the new array edges is dead
        assertEquals(0, ControllOfSpecificValue[0][0]);
        assertEquals(0, ControllOfSpecificValue[0][x]);
        assertEquals(0, ControllOfSpecificValue[y][0]);
        assertEquals(0, ControllOfSpecificValue[y][x]);
    }

    @Test
    public void testOutPutIsCorect() {

        //  check testGeneral that its equal to newGeneration(array)
        assertArrayEquals(testGeneral, main.newGeneration(inputValus, y, x));

    }
    @Test
    public void testAlounCellDies() {
        // add life to a alune cell
        //check 6,1 change state to zero
        assertEquals(0, inputValus[6][1]);

        inputValus[6][1] = 1;

        assertEquals(1, inputValus[6][1]);

        ControllOfSpecificValue = main.newGeneration(inputValus, y, x);

        assertArrayEquals(testGeneral, ControllOfSpecificValue);

        assertEquals(0, ControllOfSpecificValue[6][1]);
    }
    @Test
    public void testOverCroudedCellDies() {
        // Overcruding same cell most die
        // check for 5,5 is 6,5 dead
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

        //check that 5,5 and 6,5 is alive before newGeneration start
        assertEquals(1, inputValus[5][5]);
        assertEquals(1, inputValus[6][5]);

        ControllOfSpecificValue = main.newGeneration(inputValus, y, x);


        // 5,5 and 6,5 is dead
        assertEquals(0, ControllOfSpecificValue[5][5]);
        assertEquals(0, ControllOfSpecificValue[6][5]);

    }

    @Test
    public void testCellLiveswhen3Neibours() {
        // if cell is dead and have 3 alive neighbours
        // check for 1,3 wakes upp all becuase 3 neighbuars on the around is a live

        assertEquals(0, inputValus[1][3]);

        ControllOfSpecificValue = main.newGeneration(inputValus, y, x);

        assertEquals(1, ControllOfSpecificValue[1][3]);

    }


    //kom på hur jag skulle testa mot slutet
    @Test
    public void testCountAliveNeghbour(){
        assertEquals(2,main.getAliveNeighbours(inputValus, 2, 5,0));

    }
}