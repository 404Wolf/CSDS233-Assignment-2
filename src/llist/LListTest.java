package llist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.*;


class LListTest {
    public LList<Integer> makeTestLList() {
        LList<Integer> testList = new LList<>();
        testList.append(1);
        testList.append(2);
        testList.append(3);
        testList.append(4);
        testList.append(5);
        return testList;
    }

    @Test
    public void testClear() {
        LList<Integer> testList = makeTestLList();
        testList.clear();
        assertEquals(0, testList.length());
        assertTrue(testList.equals(new ArrayList<>()));
    }

    @Test
    public void testRemove() {
        LList<Integer> testList = makeTestLList();
        ArrayList<Integer> mirroredTestList = new ArrayList<Integer>();
        mirroredTestList.add(1);
        mirroredTestList.add(2);
        mirroredTestList.add(3);
        mirroredTestList.add(4);
        mirroredTestList.add(5);
        assertEquals(testList, mirroredTestList);

        testList.remove(3);
        mirroredTestList.remove((Object) 3);
        assertTrue(testList.equals(mirroredTestList));

        testList.remove( 4);
        mirroredTestList.remove((Object) 4);
        assertTrue(testList.equals(mirroredTestList));

        testList.remove(1);
        mirroredTestList.remove((Object) 1);
        assertTrue(testList.equals(mirroredTestList));

        testList.remove( 5);
        mirroredTestList.remove((Object) 5);
        assertTrue(testList.equals(mirroredTestList));
    }

    @Test
    public void testToString() {
        LList<Integer> testList = makeTestLList();
        assertEquals("[1, 2, 3, 4, 5]", testList.toString());
        testList.remove(3);
        testList.remove(4);
        assertEquals("[1, 2, 5]", testList.toString());
        assertEquals("[]", (new LList<>()).toString());
    }

    @Test
    public void testEquals() {
        LinkedList<Integer> equivalentTestList = new LinkedList<>();
        equivalentTestList.add(1);
        equivalentTestList.add(2);
        equivalentTestList.add(3);
        equivalentTestList.add(4);
        equivalentTestList.add(5);

        assertTrue(makeTestLList().equals(equivalentTestList));
        equivalentTestList.remove(1);
        assertFalse(makeTestLList().equals(equivalentTestList));
    }

    @Test
    public void testSwap(){
        LList<Integer> testList = makeTestLList();

        testList.swap(2, 3);
        assertTrue(testList.equals(new LList<>(new Integer[]{1, 3, 2, 4, 5})));


        testList = makeTestLList();
        testList.swap(3, 2);
        assertTrue(testList.equals(new LList<>(new Integer[]{1, 3, 2, 4, 5})));

        testList = makeTestLList();
        testList.swap(1, 2);
        assertTrue(testList.equals(new LList<>(new Integer[]{2, 1, 3, 4, 5})));

        testList = makeTestLList();
        testList.swap(1, 5);
        assertTrue(testList.equals(new LList<>(new Integer[]{5, 2, 3, 4, 1})));

        testList.swap(1, 3);
        assertTrue(testList.equals(new LList<>(new Integer[]{5, 2, 1, 4, 3})));
    }

    @Test
    public void testLength(){
        LList<Integer> testList = makeTestLList();
        assertEquals(5, testList.length());
        testList.remove(1);
        assertEquals(4, testList.length());
        testList.remove(5);
        assertEquals(3, testList.length());
        testList.clear();
        assertEquals(0, testList.length());
        testList.append(55);
        assertEquals(1, testList.length());
    }
}