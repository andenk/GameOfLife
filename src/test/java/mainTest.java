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

}