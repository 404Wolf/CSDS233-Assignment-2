package bst;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    public int randomData() {
        return (int)(Math.random() * 100);
    }

    public BST<Integer> makeEmptyBst() { return new BST<Integer>(); }

    @Test
    public void testInorder() {
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
        assertEquals(output, bst.inorder());

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
        assertEquals(output, bst.inorder());
    }

    @Test
    public void testPreorder() {
        BST<Integer> bst = new BST<>();
        ArrayList<Integer> output = new ArrayList<>();

        bst.insert(3, 3);
        bst.insert(2, 2);
        bst.insert(4, 4);
        bst.insert(1, 1);
        output.add(3);
        output.add(2);
        output.add(1);
        output.add(4);
        assertEquals(output, bst.preorder());

        bst.clear();
        output.clear();

        bst.insert(1, 1);
        bst.insert(2, 2);
        bst.insert(5, 5);
        bst.insert(3, 3);
        output.add(1);
        output.add(2);
        output.add(5);
        output.add(3);
        assertEquals(output, bst.preorder());
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

    @Test
    public void testKeySum() {
        BST<Integer> bst = makeEmptyBst();

        bst.insert(1, 1);
        bst.insert(2, 2);
        bst.insert(3, 3);
        bst.insert(4, 4);
        assertEquals(10, bst.keySum());

        bst.clear();

        bst.insert(11, randomData());
        bst.insert(-11, randomData());
        bst.insert(11, randomData());
        bst.insert(-11, randomData());
        assertEquals(0, bst.keySum());
    }

    @Test
    public void testKthBiggest() {
        BST<Integer> bst = makeEmptyBst();

        bst.insert(1, 1);
        bst.insert(4, 4);
        bst.insert(1, 1);
        bst.insert(1, 1);
        bst.insert(3, 3);
        bst.insert(33, 33);
        bst.insert(4, 4);
        assertEquals(1, bst.kthBiggest(1));
        assertEquals(3, bst.kthBiggest(2));
        assertEquals(4, bst.kthBiggest(3));
        assertEquals(33, bst.kthBiggest(4));

        bst.clear();

        bst.insert(444, 444);
        bst.insert(4, 4);
        bst.insert(11, 11);
        bst.insert(11, 11);
        bst.insert(1, 1);
        bst.insert(33, 33);
        bst.insert(2, 2);
        bst.insert(11, 11);
        bst.insert(4, 4);
        assertEquals(11, bst.kthBiggest(4));
        assertEquals(1, bst.kthBiggest(1));
        assertEquals(2, bst.kthBiggest(2));
        assertEquals(33, bst.kthBiggest(5));
        assertEquals(4, bst.kthBiggest(3));
        assertEquals(11, bst.kthBiggest(4));
        assertEquals(33, bst.kthBiggest(5));
        assertEquals(444, bst.kthBiggest(6));
    }
}