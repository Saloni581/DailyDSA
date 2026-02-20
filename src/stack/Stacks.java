package src.stack;
import src.linkedList.LinkedList;
import java.util.ArrayList;
import java.util.Stack;

public class Stacks {
    // structure
    // LAST IN FIRST OUT (The element that is inserted last gets removed first.)
    // STACK : MANUAL IMPLEMENTATIONS
    // Using Arrays
    // Using ArrayList
    // Using LinkedList
    // 1 add on top (push)
    // 2 remove from top (pop)
    // 3 get the top element (peek)
    // 4 if stack is empty or not (isEmpty)
    public static class StackLL {
        static LinkedList.Node top = null;
        // is stack empty
        public static boolean isEmpty() {
            return top == null;
        }
        // push element 
        public static LinkedList.Node push(int data) {
            // create new Node with given data
            LinkedList.Node newNode = new LinkedList.Node(data);
            if(top == null) {
                top = newNode;
                return top;
            }
            newNode.next = top;
            top = newNode;
            return top;
        }
        // peek element (top)
        public static int peek() {
            if(top == null) {
                return -1;
            }
            return top.data;
        }
        // remove element (basically pop the last element)
        public static int pop() {
            if(top == null) {
                return -1;
            }
            int topElm = top.data;
            top = top.next;
            return topElm;
        }
    }
    public static class StackAL {
        static ArrayList<Integer> top = new ArrayList<>();
        // add on top
        public static void push(int data) {
            top.add(data);
        }
        // remove from top
        public static int pop() {
            if(top.size() == 0) {
                return -1;
            }
            int topElm = top.get(top.size()-1);
            top.remove(top.size()-1);
            return topElm;
        }
        // see the top element
        public static int peek() {
            if(top.size() == 0) {
                return -1;
            }
            return top.get(top.size()-1);
        } 
        // check if stack is empty
        public static boolean isEmpty() {
            return top.size() == 0;
        }  
    }

    // Iterative 
    public static Stack<Integer> pushAtTheBottom(Stack<Integer> s, int val) {
        Stack<Integer> newS = new Stack<>();
        while(!s.isEmpty()) {
            newS.push(s.pop());
        }
        s.push(val);
        while(!newS.isEmpty()) {
            s.push(newS.pop());
        }
        return s;
    }
    // Recursion
    public static Stack<Integer> pushAtTheBottomRec(Stack<Integer> s, int val) {
        // Base Case
        if(s.isEmpty()) {
            s.push(val);
            return s;
        }
        int top = s.pop();
        pushAtTheBottomRec(s, val);
        s.push(top);
        return s;
    }

    // reverse a string using stack
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    // reverse a stack
    public static void reverseStack(Stack<Integer> st) {
        ArrayList<Integer> al = new ArrayList<>();
        while(!st.isEmpty()) {
            al.add(st.pop());
        }
        for(int i=0; i<al.size(); i++) {
            st.push(al.get(i));
        }
    }

    // reverse a stack : Using Recursion
    public static void reverseStackRec(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }
        int top = st.pop();
        reverseStackRec(st);
        pushAtTheBottom(st, top);
    }

    // stock span problem: simpler version
    public static int stockSpan(int arr[], int i) {
        // core case 
        if(i >= arr.length || i < 0) {
            return -1;
        }
        int price = arr[i];
        int index = i-1;
        int span  = 1;
        while(index >= 0) {
            if(price >= arr[index]) {
                span++;
            } else {
                break;
            }
            index--;
        }
        return span;
    }

    // next greater element problem
    public static void nextGreater(int[] nums) {
        Stack<Integer> s = new Stack<>();
        for(int i=nums.length-1; i>=0; i--) {
            while(!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            int curr = nums[i];
            if(s.isEmpty()) {
                nums[i] = -1;
            } else {
                nums[i] = s.peek();
            }
            s.push(curr);
        }
    }

    // previous greater element problem 
    public static void prevGreater(int[] nums) {
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<nums.length; i++) {
            while(!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            int curr = nums[i];
            if(s.isEmpty()) {
                nums[i] = -1;
            } else {
                nums[i] = s.peek();
            }
            s.push(curr);
        }
    }

    // previous greater element problem : Modified Stock Span Problem
    public static Stack<int[]> stockSpan(int[] nums) {
        Stack<int[]> s = new Stack<>();
        for(int i=0; i<nums.length; i++) {
            int span = 1;
            int currPrice = nums[i];
            while(!s.isEmpty() && s.peek()[0] <= currPrice) {
                span += s.pop()[1];
            }
            s.push(new int[]{currPrice, span});
        }
        return s;
    }

    public static void printArr(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // // using linked list
        // LinkedList.Node top = null;
        // top = LinkedList.addStart(top, 1);
        // top = LinkedList.addStart(top, 2);
        // top = LinkedList.addStart(top, 3);
        // top = LinkedList.addStart(top, 4);
        // top = LinkedList.addStart(top, 5);
        // // isEmpty()
        // if(StackLL.isEmpty()) {
        //     System.out.println("Man! Stack is Totally empty... What a pain");
        // } else {
        //     System.out.println("ummMMMM Nah! We got elements in our Stack - go get em!");
        // }
        // // push()
        // top = StackLL.push(12);
        // // peek()
        // int ans = StackLL.peek();
        // System.out.println("Woah! This one is the fortunate who stands at the top: "+ans);
        // // pop()
        // int ans1 = StackLL.pop();
        // System.out.println("Man! This unfortunate is the popped element: "+ ans1);

        // using ArrayList
        // ArrayList<Integer> stack = new ArrayList<>();
        // StackAL.push(1);
        // StackAL.push(2);
        // StackAL.push(3);
        // StackAL.push(4);
        // StackAL.push(5);
        // System.out.println(stack);
        // StackAL.pop();
        // System.out.println(stack);
        // System.out.println(StackAL.peek());
        // System.out.println(StackAL.isEmpty());

        // using Built in Stack
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // s.push(5);
        // s.push(6);
        // s = pushAtTheBottom(s, 13);
        // while(!s.isEmpty()) {
        //     System.out.print(s.pop() + " ");
        // }
        
        // Reverse a string using stack
        // String input = "saloni";
        // System.out.println("Original String: "+ input);
        // String ans = reverseString(input);
        // for(int i=0; i<ans.length(); i++) {
        //     System.out.print(ans.charAt(i));
        // }

        // reverse a stack
        // Stack<Integer> st = new Stack<>();
        // st.push(1);
        // st.push(2);
        // st.push(3);
        // st.push(4);
        // st.push(5);
        // st.push(6);
        // System.out.println("Before Reversing: "+ st);
        // // reverseStack(st);
        // reverseStackRec(st);
        // System.out.println("After Reversing: "+ st);
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        // int span = stockSpan(arr, 6);
        // System.out.println(span);
        // System.out.println("Before finding Next Greater: ");
        // printArr(arr);
        // nextGreater(arr);
        // System.out.print("After finding Next Greater: ");
        // printArr(arr);
        
        // System.out.println("Before finding Prev Greater: ");
        // printArr(arr);
        // prevGreater(arr);
        // System.out.print("After finding Prev Greater: ");
        // printArr(arr);

        System.out.println("Before finding Stock Span: ");
        printArr(arr);
        Stack<int[]> stocks = stockSpan(arr);
        System.out.println("After finding Stock Span: ");
        while(!stocks.isEmpty()) {
            int[] priceSpan = stocks.pop();
            System.out.println("Price: " + priceSpan[0] + ", Span: " + priceSpan[1]);
        }
    }
}
