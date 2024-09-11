package datastructures;

import org.junit.Test;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTree {

    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (temp!=null) {
            if(value==temp.value) {
                return false;
            }

            if (value<temp.value) {
                if(temp.left==null) {
                    temp.left=newNode;
                    break;
                }
                temp = temp.left;
            }
            else {
                if(temp.right==null) {
                    temp.right=newNode;
                    break;
                }
                temp = temp.right;
            }
        }
        return true;
    }

    public boolean contains(int value) {
        if(root == null) {
            return false;
        }

        Node temp = root;
        while (temp!=null) {
            if(value==temp.value) {
                return true;
            }

            if (value<temp.value) {
                temp = temp.left;
            }
            else {
                temp = temp.right;
            }
        }
        return false;
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode==null)
            return false;

        if (currentNode.value == value) {
            return true;
        }

        if(currentNode.value > value) {
            return rContains(currentNode.left, value);
        }
        else {
            return rContains(currentNode.right, value);
        }
    }

    public void rInsert(int value) {
        if (root == null) {
            Node newNode = new Node(value);
            root = newNode;
        }
        else {
            rInsert(root, value);
        }
    }

    private void rInsert(Node currentNode, int value) {
        if (currentNode.left!=null && currentNode.right!=null) {
            if(value < currentNode.value){
                rInsert(currentNode.left, value);
            }
            if(value > currentNode.value) {
                rInsert(currentNode.right, value);
            }
        }
        else{
            if(currentNode.left == null && value<currentNode.value) {
                Node newNode = new Node(value);
                currentNode.left = newNode;
//                return;
            }
            if (currentNode.right == null && value>currentNode.value) {
                Node newNode = new Node(value);
                currentNode.right = newNode;
//                return;
            }
        }
    }

    public int minValue(Node node) {
        if(node == null) {
            throw new NullPointerException("null");
        }
        return minValue(node, 0);
    }

    private int minValue(Node currentNode, int min) {
        if(currentNode==null)
            return min;

        min = currentNode.value;
        return minValue(currentNode.left, min);
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode==null)
            return null;

        if(value<currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        }
        else if(value>currentNode.value){
            currentNode.right = deleteNode(currentNode.right, value);
        }
        else{
            if(currentNode.left == null && currentNode.right==null){
                return null;
            }
            else if(currentNode.left != null && currentNode.right==null) {
                currentNode = currentNode.left;
            }
            else if(currentNode.left == null && currentNode.right != null) {
                currentNode = currentNode.right;
            }
            else {
                int min = minValue(currentNode.right);
                currentNode.value = min;
                currentNode.right = deleteNode(currentNode.right, min);
            }
        }
        return currentNode;
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderHelper(this.root, result);
        return result;
    }

    private void inorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.value);
        inorderHelper(node.right, result);
    }

    public boolean isBalanced() {
        return height(this.root) != -1;
    }

    private int height(Node node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return;
        if(nums.length == 1) {
            root = new Node(nums[0]);
            return;
        }

        root = sortedArrayToBST(nums,0, nums.length-1);

    }

    private Node sortedArrayToBST(int[] nums, int left, int right){

        if(left>right)
            return null;

        int mid = left + (right-left)/2;
        Node currentNode = new Node(nums[mid]);
        currentNode.left = sortedArrayToBST(nums, left, mid-1);
        currentNode.right = sortedArrayToBST(nums, mid+1, right);

        return currentNode;
    }

    public void invert() {
        root = invertTree(root);
    }

    private Node invertTree(Node node) {
        if (node==null)
            return null;

        Node tmp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(tmp);

        return node;
    }

    public ArrayList<Integer> BFS() {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        Node currentNode = root;
        queue.add(currentNode);

        while (queue.size()>0) {
            Node node = queue.remove();
            result.add(node.value);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);

        }

        return result;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> result = new ArrayList<>();

        DFSPreOrder(root, result);
        return result;
    }

    private void DFSPreOrder(Node currentNode, ArrayList<Integer> result) {
         if(currentNode==null)
             return;

         result.add(currentNode.value);
         if(currentNode.left!=null)
             DFSPreOrder(currentNode.left, result);
         if(currentNode.right!=null)
             DFSPreOrder(currentNode.right, result);
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> result = new ArrayList<>();

        DFSPostOrder(root, result);
        return result;
    }

    private void DFSPostOrder(Node currentNode, ArrayList<Integer> result) {
        if(currentNode==null)
            return;

        if(currentNode.left!=null)
            DFSPostOrder(currentNode.left, result);
        if(currentNode.right!=null)
            DFSPostOrder(currentNode.right, result);

        result.add(currentNode.value);
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> result = new ArrayList<>();

        DFSInOrder(root, result);
        return result;
    }

    private void DFSInOrder(Node currentNode, ArrayList<Integer> result) {
        if(currentNode==null)
            return;

        if(currentNode.left!=null)
            DFSInOrder(currentNode.left, result);
        result.add(currentNode.value);
        if(currentNode.right!=null)
            DFSInOrder(currentNode.right, result);
    }

    public boolean isValidBST() {
        ArrayList<Integer> ascending = DFSInOrder();

        if(ascending.size()==0)
            return true;

        int min=ascending.get(0);
        for(int i=1; i<ascending.size(); i++) {
            if( min >ascending.get(i)){
                return false;
            }
        }
        return true;
    }

    public Integer kthSmallest(int k) {
        if(k<1)
            return null;

        ArrayList<Integer> result = new ArrayList<>();

        kthSmallest(root, result, k);
        if(result.size()<k)
            return null;
        return result.get(k-1);
    }

    private void kthSmallest(Node currentNode, ArrayList<Integer> result, int k) {
        if(currentNode==null)
            return;

        if(currentNode.left!=null)
            kthSmallest(currentNode.left, result, k);
        result.add(currentNode.value);
        if(result.size()==k)
            return;
        if(currentNode.right!=null)
            kthSmallest(currentNode.right, result, k);
    }




}
