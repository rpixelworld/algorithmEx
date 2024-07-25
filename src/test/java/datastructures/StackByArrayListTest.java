package datastructures;

import org.junit.Test;

public class StackByArrayListTest {

    @Test
    public void testPush() {
        StackByArrayList myStack = new StackByArrayList();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        myStack.printStack();
    }

    @Test
    public void testPop() {
        StackByArrayList myStack = new StackByArrayList();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println("Stack before pop():");
        myStack.printStack();

        System.out.println("\nPopped node:");
        System.out.println(myStack.pop());

        System.out.println("\nStack after pop():");
        myStack.printStack();
    }

    @Test
    public void testReverseString() {
        String myString = "hello";
        String reversedString = StackByArrayList.reverseString(myString);
        System.out.println(reversedString);
    }

    @Test
    public void testIsBalancedParentheses () {
        testAndPrint("()", true);
        testAndPrint("()()", true);
        testAndPrint("(())", true);
        testAndPrint("()()()", true);
        testAndPrint("(()())", true);
        testAndPrint(")()(", false);
        testAndPrint(")(", false);
        testAndPrint("(()", false);
        testAndPrint("))", false);
        testAndPrint("(", false);
        testAndPrint(")", false);
    }

    @Test
    public void testSortStack() {
        StackByArrayList<Integer> stack = new StackByArrayList<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
        stack.printStack();

        StackByArrayList.sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();
    }

    private void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = StackByArrayList.isBalancedParentheses(testStr);

        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        // Print a separator for better readability
        System.out.println("--------------");
    }
}
