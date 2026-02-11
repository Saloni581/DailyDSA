package src.stack;
import src.linkedList.LinkedList;
import java.util.ArrayList;
public class Stack {
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
            // is stack empty
            public static boolean isEmpty(LinkedList.Node top) {
                return top == null;
            }
            // push element 
            public static LinkedList.Node push(LinkedList.Node top, int data) {
                // create new Node with given data
                LinkedList.Node newNode = new LinkedList.Node(data);
                if(top == null) {
                    top = newNode;
                    return top;
                }
                LinkedList.Node temp = top;
                while(temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                return top;
            }
            // peek element (top)
            public static LinkedList.Node peek(LinkedList.Node top) {
                if(top == null || top.next == null) {
                    return top;
                }
                LinkedList.Node temp = top;
                while(temp.next != null) {
                    temp = temp.next;
                }
                return temp;
            }
            // remove element (basically pop the last element)
            public static LinkedList.Node pop(LinkedList.Node top) {
                if(top == null) {
                    return top;
                }
                LinkedList.Node temp = top;
                while(temp.next.next != null) {
                    temp = temp.next;
                }
                LinkedList.Node popElm = temp.next;
                temp.next = null;
                return popElm;
            }
        }


        public static class StackAL {
            // add on top
            public static void push(ArrayList<Integer> stack, int data) {
                stack.add(data);
            }
            // remove from top
            public static int pop(ArrayList<Integer> stack) {
                return stack.remove(stack.size()-1);
            }
            // see the top element
            public static int peek(ArrayList<Integer> stack) {
                return stack.get(stack.size()-1);
            } 
            // check if stack is empty
            public static boolean isEmpty(ArrayList<Integer> stack) {
                return stack.size() == 0;
            }  
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
        // if(StackLL.isEmpty(top)) {
        //     System.out.println("Man! Stack is Totally empty... What a pain");
        // } else {
        //     System.out.println("ummMMMM Nah! We got elements in our Stack - go get em!");
        // }
        // // push()
        // top = StackLL.push(top, 12);
        // // peek()
        // LinkedList.Node ans = StackLL.peek(top);
        // System.out.println("Woah! This one is the fortunate who stands at the top: "+ans.data);
        // // pop()
        // LinkedList.Node popped = StackLL.pop(top);
        // System.out.println("Man! This unfortunate is the popped element: "+ popped.data);

        // using ArrayList
        ArrayList<Integer> stack = new ArrayList<>();
        StackAL.push(stack, 1);
        StackAL.push(stack, 2);
        StackAL.push(stack, 3);
        StackAL.push(stack, 4);
        StackAL.push(stack, 5);
        System.out.println(stack);
        StackAL.pop(stack);
        System.out.println(stack);
        System.out.println(StackAL.peek(stack));
        System.out.println(StackAL.isEmpty(stack));
    }
}
