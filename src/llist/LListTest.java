package llist;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


class LListTest {
    @Test
    void remove() {
        LList<Integer> testList = new LList<>();
        testList.append(1);
        testList.append(2);
        testList.append(3);
        testList.append(4);

        assertTrue(testList.contains(1));
        assertTrue(testList.contains(2));
        assertTrue(testList.contains(3));
        assertTrue(testList.contains(4));

        testList.remove(3);
        assertTrue(testList.contains(1));
        assertTrue(testList.contains(2));
        assertFalse(testList.contains(3));
        assertTrue(testList.contains(4));
    }
}