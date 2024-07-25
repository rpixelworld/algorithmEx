package datastructures;

import java.util.ArrayList;

public class StackByArrayList<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public void push(T obj) {
        stackList.add(obj);
    }

    public T pop() {
        if(isEmpty())
            return  null;
        T removed = peek();
        stackList.remove(size()-1);
        return removed;
    }

    public int size() {
        return stackList.size();
    }

    public static String reverseString(String str) {

        StackByArrayList<Character> charStack = new StackByArrayList();
        char[] charArr = str.toCharArray();
        for(char c: charArr) {
            charStack.push(new Character(c));
        }

        StringBuffer sb = new StringBuffer();
        while (!charStack.isEmpty()) {
            sb.append(charStack.pop());
        }

        return sb.toString();
    }

    public static boolean isBalancedParentheses(String str) {
        StackByArrayList<Character> charStack = new StackByArrayList();
        char[] charArr = str.toCharArray();
        for(char c: charArr) {
            if(c=='('){
                charStack.push(new Character(c));
            }
            if(c==')') {
                if(charStack.isEmpty())
                    return false;
                charStack.pop();
            }
        }
        if(charStack.isEmpty())
            return true;

        return false;
    }

    public static void sortStack(StackByArrayList<Integer> stack) {
        StackByArrayList<Integer> sortedStack = new StackByArrayList();

        while (!stack.isEmpty()) {
            if(sortedStack.isEmpty() || sortedStack.peek()>=stack.peek()){
                sortedStack.push(stack.pop());
            }
            else {
                int max = stack.pop();
                while (!sortedStack.isEmpty() && sortedStack.peek()<=max){
                    stack.push(sortedStack.pop());
                }
                sortedStack.push(max);
            }
        }
        StackByArrayList<Integer> temp = new StackByArrayList();
        while (!sortedStack.isEmpty()){
            temp.push(sortedStack.pop());
        }

        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }

    }

}
