package src.stack;
import src.linkedList.LinkedList;

public class Stack {
        // structure
        // LAST IN FIRST OUT (The element that is inserted last gets removed first.)
        // STACK : MANUAL IMPLEMENTATIONS
        // Using Arrays
        // Using ArrayList
        // Using LinkedList
        public static class StackLL {
            // is stack empty
            public static boolean isEmpty(LinkedList.Node top) {
                return top == null;
            }
            // push element 
            public static void push(LinkedList.Node top, int data) {
                // create new Node with given data
                LinkedList.Node newNode = new LinkedList.Node(data);
                if(top == null) {
                    top = newNode;
                    return;
                }
                LinkedList.Node temp = top;
                while(temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                return;
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
                if(top.next == null) {
                    LinkedList.Node popElm = top;
                    top = null;
                    return popElm;
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


    public static void main(String[] args) {
        LinkedList.Node top = null;
        top = LinkedList.addStart(top, 1);
        top = LinkedList.addStart(top, 2);
        top = LinkedList.addStart(top, 3);
        top = LinkedList.addStart(top, 4);
        top = LinkedList.addStart(top, 5);
        // isEmpty()
        if(StackLL.isEmpty(top)) {
            System.out.println("Man! Stack is Totally empty... What a pain");
        } else {
            System.out.println("ummMMMM Nah! We got elements in our Stack - go get em!");
        }
        // push()
        StackLL.push(top, 12);
        // peek()
        LinkedList.Node ans = StackLL.peek(top);
        System.out.println("Woah! This one is the fortunate who stands at the top: "+ans.data);
        // pop()
        LinkedList.Node popped = StackLL.pop(top);
        System.out.println("Man! This unfortunate is the popped element: "+ popped.data);
    }
}
