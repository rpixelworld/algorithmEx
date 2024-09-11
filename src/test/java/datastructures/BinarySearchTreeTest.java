package datastructures;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeTest {

    @Test
    public void testConstructor() {
        BinarySearchTree myBST = new BinarySearchTree();

        System.out.println("Root: " + myBST.getRoot());
    }

    @Test
    public void testInsert() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);

        /*
            THE LINES ABOVE CREATE THIS TREE:
                         2
                        / \
                       1   3
        */


        System.out.println("Root: " + myBST.getRoot().value);
        System.out.println("\nRoot->Left: " + myBST.getRoot().left.value);
        System.out.println("\nRoot->Right: " + myBST.getRoot().right.value);
    }

    @Test
    public void testContains() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);


        System.out.println("BST Contains 27:");
        System.out.println(myBST.contains(27));

        System.out.println("\nBST Contains 17:");
        System.out.println(myBST.contains(17));
    }

    @Test
    public void testRContains() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);


        System.out.println("BST Contains 27:");
        System.out.println(myBST.rContains(27));

        System.out.println("\nBST Contains 17:");
        System.out.println(myBST.rContains(17));
    }

    @Test
    public void testRInsert() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.rInsert(2);
        myBST.rInsert(1);
        myBST.rInsert(3);
        myBST.rInsert(5);
        myBST.rInsert(4);
        myBST.rInsert(6);

        /*
            THE LINES ABOVE CREATE THIS TREE:
                         2
                        / \
                       1   3
        */



        System.out.println("Root: " + myBST.getRoot().value);
        System.out.println("\nRoot->Left: " + myBST.getRoot().left.value);
        System.out.println("\nRoot->Right: " + myBST.getRoot().right.value);
    }

    @Test
    public void testMinValue() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);


        System.out.println(myBST.minValue( myBST.getRoot() ));

        System.out.println(myBST.minValue( myBST.getRoot().right ));
    }

    @Test
    public void testDeleteNode() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);

        /*
               2
              / \
             1   3
        */

        System.out.println( "Root: " + myBST.getRoot().value );
        System.out.println( "Root->Left: " + myBST.getRoot().left.value );
        System.out.println( "Root->Right: " + myBST.getRoot().right.value );


        myBST.deleteNode(2);

        /*
               3
              / \
             1  null
        */


        System.out.println( "\nRoot: " + myBST.getRoot().value );
        System.out.println( "Root->Left: " + myBST.getRoot().left.value );
        System.out.println( "Root->Right: " + myBST.getRoot().right );
    }

    @Test
    public void testSortedArrayToBST() {
        // Test: Convert an empty array
//        System.out.println("\n----- Test: Convert Empty Array -----\n");
//        checkBalancedAndCorrectTraversal(new int[]{}, Arrays.asList());
//
//        // Test: Convert an array with one element
//        System.out.println("\n----- Test: Convert Single Element Array -----\n");
//        checkBalancedAndCorrectTraversal(new int[]{10}, Arrays.asList(10));
//
//        // Test: Convert a sorted array with odd number of elements
//        System.out.println("\n----- Test: Convert Sorted Array with Odd Number of Elements -----\n");
//        checkBalancedAndCorrectTraversal(new int[]{1, 2, 3, 4, 5}, Arrays.asList(1, 2, 3, 4, 5));
//
//        // Test: Convert a sorted array with even number of elements
//        System.out.println("\n----- Test: Convert Sorted Array with Even Number of Elements -----\n");
//        checkBalancedAndCorrectTraversal(new int[]{1, 2, 3, 4, 5, 6}, Arrays.asList(1, 2, 3, 4, 5, 6));

        // Test: Convert a large sorted array
        System.out.println("\n----- Test: Convert Large Sorted Array -----\n");
        checkBalancedAndCorrectTraversal(
                Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}).toArray(),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
    }

    private void checkBalancedAndCorrectTraversal(int[] nums, List<Integer> expectedTraversal) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.sortedArrayToBST(nums);
        boolean isBalanced = bst.isBalanced();
        List<Integer> inorder = bst.inorderTraversal();
        System.out.println("Is balanced: " + isBalanced);
        System.out.println("Inorder traversal: " + inorder);
        System.out.println("Expected traversal: " + expectedTraversal);
        if (isBalanced && inorder.equals(expectedTraversal)) {
            System.out.println("PASS: Tree is balanced and inorder traversal is correct.\n");
        } else {
            System.out.println("FAIL: Tree is either not balanced or inorder traversal is incorrect.\n");
        }
    }

    @Test
    public void testInvert() {
        testInvertBinarySearchTree();
    }

    private void performTest(String description, int[] insertValues, Integer[] expectedValues, boolean doubleInversion) {
        BinarySearchTree bst = new BinarySearchTree();
        for (int value : insertValues) {
            bst.insert(value);
        }
        if (doubleInversion) {
            bst.invert(); // First inversion
        }
        bst.invert(); // Perform inversion (or second inversion for the specific case)

        ArrayList<Integer> resultList = bst.BFS();

        // Use Arrays.asList for compatibility with older Java versions
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(expectedValues));

        System.out.println(description + ": " + (expectedList.equals(resultList) ? "Pass" : "Fail"));
        System.out.println("Expected: " + expectedList);
        System.out.println("Actual:   " + resultList);
    }

    private void testInvertBinarySearchTree() {
        System.out.println("--- Testing Inversion of Binary Search Tree ---");

        performTest("Invert an empty tree", new int[]{}, new Integer[]{}, false);
        performTest("Invert a tree with a single node", new int[]{1}, new Integer[]{1}, false);
        performTest("Invert a tree with only a left child", new int[]{2, 1}, new Integer[]{2, null, 1}, false);
        performTest("Invert a tree with only a right child", new int[]{1, 2}, new Integer[]{1, 2}, false);
        performTest("Invert a full binary tree", new int[]{2, 1, 3}, new Integer[]{2, 3, 1}, false);
        performTest("Invert a more complex binary tree", new int[]{4, 2, 6, 1, 3, 5, 7}, new Integer[]{4, 6, 2, 7, 5, 3, 1}, false);
        performTest("Double inversion returns original", new int[]{3, 1, 4}, new Integer[]{3, 1, 4}, true);
    }

    @Test
    public void testBFS() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("Breadth First Search:");
        System.out.println( myBST.BFS() );
    }

    @Test
    public void testDFSPreOrder() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("DFS PreOrder:");
        System.out.println( myBST.DFSPreOrder() );
    }

    @Test
    public void testDFSPostOrder() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("DFS PostOrder:");
        System.out.println( myBST.DFSPostOrder() );
    }

    @Test
    public void testDFSInOrder() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("DFS InOrder:");
        System.out.println( myBST.DFSInOrder() );
    }

    @Test
    public void testIsValidBST() {
        testSingleNodeTree();
        testValidBST();
        testValidBSTWithDeepLeftSubtree();
        testValidBSTWithDeepRightSubtree();
        testBalancedBST();
    }

    private void testSingleNodeTree() {
        System.out.println("\n----- Test: Single Node Tree -----\n");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        printIsValidBST(bst);
    }

    private void testValidBST() {
        System.out.println("\n----- Test: Valid BST -----\n");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        printIsValidBST(bst);
    }

    private void testValidBSTWithDeepLeftSubtree() {
        System.out.println("\n----- Test: BST With Deep Left Subtree -----\n");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(8);
        bst.insert(6);
        bst.insert(4);
        bst.insert(2);
        printIsValidBST(bst);
    }

    private void testValidBSTWithDeepRightSubtree() {
        System.out.println("\n----- Test: BST With Deep Right Subtree -----\n");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(12);
        bst.insert(14);
        bst.insert(16);
        bst.insert(18);
        printIsValidBST(bst);
    }

    private void testBalancedBST() {
        System.out.println("\n----- Test: Balanced BST -----\n");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        printIsValidBST(bst);
    }

    private void printIsValidBST(BinarySearchTree bst) {
        System.out.println("Is valid BST: " + bst.isValidBST());
    }

    @Test
    public void testKthSmallest() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println(bst.kthSmallest(1));  // Expected output: 2
        System.out.println(bst.kthSmallest(3));  // Expected output: 4
        System.out.println(bst.kthSmallest(6));  // Expected output: 7
    }
}
