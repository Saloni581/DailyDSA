public class Code {

    // Creating Linked List Manually
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // add => at start, at end, in the middle
    // start
    public static Node addStart(Node head, int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    // middle
    public static Node addMiddle(Node head, int val, int index) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            return head;
        }
        if(index == 0) {
            head = addStart(head, val);
            return head;
        }

        Node temp = head;
        int i = 0;
        while(i < index-1 && temp != null) {
            temp = temp.next;
            i++;
        } 
        newNode.next = temp.next;
        temp.next = newNode;
        return head; // my mistake : returned temp here and lost reference to nodes prev to temp as temp will be 
        // pointing to a diff index
    }

    // end
    public static Node addEnd(Node head, int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    // remove => from start, from end, from middle
    // start
    public static Node removeStart(Node head) {
        if(head == null) {
            return null;
        }
        head = head.next;
        return head;
        // shortened version: head == null? null : head.next;
    }

    // middle
    public static Node removeMiddle(Node head, int index) {
        if(head == null || index < 0) {
            return null;
        }
        if(index == 0) {
            return removeStart(head);
        }
        Node temp = head;
        // not index-1 => will break for index == 2
        for(int i=1; i<index; i++) {
            // index out of bounds check 
            if(temp.next == null) {
                return head;    
            }
            temp = temp.next;
        }
        if(temp.next == null) {
            return head; 
        }
        temp.next = temp.next.next;
        return head;
    }

    // end
    public static Node removeEnd(Node head) {
        // only one node or no node at all
        if(head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while(temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // search in linked list (linear search)
    // 2 ways => iteration and recursion
    // using iteration 
    public static int searchIteration(Node head, int val) {
        // edge case
        if(head == null) {
            return -1;
        }
        Node temp = head;
        int index = 0;
        while(temp != null) {
            if(temp.data == val) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    // using recursion
    public static int searchRecursion(Node head, int val) {
        // base case
        if(head == null) {
            return -1;
        }
        // recursion actual work 
        if(head.data == val) {
            return 0;
        }

        // recursive call
        int index = searchRecursion(head.next, val);
        if(index == -1) {
            return -1;
        }
        return index+1;
    }

    // reverse linked list
    public static Node reverseLL(Node head) {
        Node curr = head;
        Node prev = null;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // remove nth node the end of the linked list - iterative 
    public static Node removeNthFromEndIter(Node head, int n) {
        // nth from end but size-n from start
        Node temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        // head is the node to remove
        if(n == size) {
            return head.next;
        }
        temp = head;
        for(int i=1; i<size-n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    // remove nth node the end of the linked list - recursive

    // palindrome linked list
    public static boolean isPalindromeLL(Node head) {
        if(head == null || head.next == null) {
            return true;
        }
        // find mid of the Linked list
        Node slow = head;
        Node fast = head;
        // odd = fast == null and even fast.next == null
        // Rule to remember: Always check fast before fast.next
        // my mistake : fast.next != null || fast != null (This is dangerous and will cause NullPointerException)
        while(fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        // reverse the second half Linked List
        Node prev = null;
        Node curr = slow;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // comparing first and second half 
        Node leftHalfHead = head;
        Node rightHalfHead = prev;
        while(rightHalfHead != null) {
            if(leftHalfHead.data != rightHalfHead.data) {
                return false;
            }
            leftHalfHead = leftHalfHead.next;
            rightHalfHead = rightHalfHead.next;
        }
        return true;
    }


    // print the linked list
    public static void printLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head = addStart(head, 2);
        head = addStart(head, 1);
        head = addMiddle(head, 2, 3);
        head = addMiddle(head, 3, 2);
        head = addEnd(head, 3);
        head = addEnd(head, 2);
        head = addEnd(head, 1);
        // head = removeMiddle(head, 3);
        // System.out.println(searchRecursion(head, 12));
        // head = removeEnd(head);
        // head = reverseLL(head);
        printLL(head);
        // head = removeNthFromEndIter(head, 5);
        // System.out.println();
        // printLL(head);
        System.out.println(isPalindromeLL(head));
    }
}