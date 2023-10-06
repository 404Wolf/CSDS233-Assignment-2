package bst;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    public int randomData() {
        return (int)(Math.random() * 100);
    }

    public BST<Integer> makeEmptyBst() { return new BST<Integer>(); }

    @Test
    public void testIterate() {
        BST<Integer> bst = new BST<>();
        ArrayList<Integer> output = new ArrayList<>();

        bst.insert(3, 3);
        bst.insert(2, 2);
        bst.insert(4, 4);
        bst.insert(1, 1);
        output.add(1);
        output.add(2);
        output.add(3);
        output.add(4);
        assertTrue(output.equals(bst.inorder()));

        bst.clear();
        output.clear();

        bst.insert(1, 1);
        bst.insert(2, 2);
        bst.insert(5, 5);
        bst.insert(3, 3);
        output.add(1);
        output.add(2);
        output.add(3);
        output.add(5);
        assertTrue(output.equals(bst.inorder()));
    }

    @Test
    public void testInsert() {
        BST<Integer> bst = makeEmptyBst();

        bst.insert(1, randomData());
        bst.insert(2, randomData());
        bst.insert(3, randomData());
        bst.insert(4, randomData());
        assertEquals(1, bst.getRootNode().getKey());
        assertEquals(2, bst.getRootNode().getRight().getKey());
        assertEquals(3, bst.getRootNode().getRight().getRight().getKey());
        assertEquals(4, bst.getRootNode().getRight().getRight().getRight().getKey());

        bst.clear();

        bst.insert(2, randomData());
        bst.insert(3, randomData());
        bst.insert(1, randomData());
        bst.insert(4, randomData());
        assertEquals(2, bst.getRootNode().getKey());
        assertEquals(1, bst.getRootNode().getLeft().getKey());
        assertEquals(3, bst.getRootNode().getRight().getKey());
        assertEquals(4, bst.getRootNode().getRight().getRight().getKey());

        bst.clear();

        bst.insert(-8, randomData());
        bst.insert(22, randomData());
        bst.insert(49, randomData());
        bst.insert(-48, randomData());
        bst.insert(-4, randomData());
        bst.insert(2, randomData());
        assertEquals(-8, bst.getRootNode().getKey());
        assertEquals(-48, bst.getRootNode().getLeft().getKey());
        assertEquals(22, bst.getRootNode().getRight().getKey());
        assertEquals(-4, bst.getRootNode().getRight().getLeft().getKey());
        assertEquals(22, bst.getRootNode().getRight().getLeft().getParent().getKey());
        assertEquals(-4, bst.getRootNode().getRight().getLeft().getKey());
        assertEquals(2, bst.getRootNode().getRight().getLeft().getRight().getKey());
        assertEquals(49, bst.getRootNode().getRight().getRight().getKey());
    }

    @Test
    public void testClear() {
        BST<Integer> bst = makeEmptyBst();

        bst.insert(1, randomData());
        bst.insert(2, randomData());
        bst.insert(3, randomData());
        bst.insert(4, randomData());
        bst.clear();
        bst.insert(1, randomData());
        bst.clear();
        assertNull(bst.getRoot());
        assertEquals(0, bst.length());
    }
}