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

    // remove nth node from the end of the linked list - iterative 
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

    // remove nth node from the end of the linked list - recursive
    public static Node removeNthFromEndRec(Node head, int n) {
        int count = removeNthFromEndRecHelper(head, n);
        // head is the node to remove
        if(count == n) {
            return head.next;
        }
        return head;
    }

    public static int removeNthFromEndRecHelper(Node head, int n) {
        // base case
        if(head == null) {
            return 0;
        }
        // work 
        int count = removeNthFromEndRecHelper(head.next, n)+1;
        if(count == n+1 && head.next != null) {
            head.next = head.next.next;
        }
        return count;
    }

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

    // find if there exist a cycle in linked list
    public static boolean isCycle(Node head) {
        if(head == null) {
            return false;
        }
        // slow fast pointer approach : if(slow == fast) ==> cycle exists
        Node slow, fast;
        slow = fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    // remove a cycle from the linked list if exists any
    public static Node removeCycle(Node head) {
        if(head == null) {
            return head;
        }
        // Detect the cycle
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle) {
            return head;
        }
        slow = head;
        Node prev = null;

        // special case => cycle starts at head
        if (slow == fast) {
        while (fast.next != slow) {
            fast = fast.next;
        }
            fast.next = null;
            return head;
        }

        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
        return head;
    }

    // merge sort in linked list
    // public static Node merge(Node leftHead, Node rightHead) {

    // }

    public static Node mergeSort(Node head) {
        // base case
        if(head == null || head.next == null) {
            return head;
        }
        // merge sort (work)
        // find mid
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow now is at mid Node
        Node rightHalfHead = slow.next;
        slow.next = null;
        // sorting left half
        Node leftSorted = mergeSort(head);    
        // sorting right half
        Node rightSorted = mergeSort(rightHalfHead); 
        head = merge(leftSorted, rightSorted);
        return head;
    }

    // size of the linked list
    public static int size(Node head) {
        Node temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
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
    // -------- Create Linked List --------
    Node head = new Node(1);
    head = addEnd(head, 2);
    head = addEnd(head, 3);
    head = addEnd(head, 4);
    head = addEnd(head, 5);
    System.out.println("Original Linked List: ");
    printLL(head);
    // // -------- Create Cycle in Middle (node with value 3) --------
    // Node temp = head;
    // Node cycleNode = null;
    // while (temp.next != null) {
    //     if (temp.data == 3) {
    //         cycleNode = temp;
    //     }
    //     temp = temp.next;
    // }
    // temp.next = cycleNode;  // last node → node with value 3
    // System.out.println("\nLinked list cycle: " +isCycle(head));
    // // -------- Remove Cycle --------
    // head = removeCycle(head);
    // // -------- Print After Cycle Removal --------
    // System.out.print("Linked List after removing cycle:");
    // printLL(head);
    // System.out.println("\nLinked list cycle: " +isCycle(head));
    // -----------------SIZE OF LL-----------------------
    int size = size(head);
    mergeSort(head, 0, size-1);
 }
}