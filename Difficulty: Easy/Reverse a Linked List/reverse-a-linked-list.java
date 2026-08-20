/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node reverseList(Node head) {
        // code here
        if(head == null || head.next == null){
            return head;
        }
        Node curr = head;
        Node prev = null;
        Node front = head;
        while(curr!= null){
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
    
}