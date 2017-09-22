/**
 * Example of reverse function for a simple list
 */
public class Node {
    Node next;
    int value;

    // Time complexity: O(n)
    // Space complexity: O(n)
    public static Node reverse(Node head) {
        Node oldPrev = null, oldNext = null;
        if(head == null){
            return null;
        }
        while (head.next != null) {
            oldNext = head.next;
            head.next = oldPrev;
                oldPrev = head;
                head = oldNext;
        }
        oldNext = head.next;
        head.next = oldPrev;
        return head;
    }
}