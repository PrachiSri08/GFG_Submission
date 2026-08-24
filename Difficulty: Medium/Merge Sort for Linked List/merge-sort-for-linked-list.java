/* Structure of a Linked List node
class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
} */

class Solution {
    public Node merge(Node first, Node second){
        Node dummy = new Node(0);
        Node temp = dummy;
        Node temp1 = first;
        Node temp2 = second;
        while(temp1 != null && temp2 != null){
            if(temp1.data <= temp2.data){
            temp.next = temp1;
            temp1 = temp1.next;
            }
            else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 != null){
            temp.next = temp1;
        }
        else if(temp2 != null){
            temp.next = temp2;
        }
        return dummy.next;
}
        
    public Node mergeSort(Node head) {
        // code here
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next!= null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHead = slow.next;
        slow.next = null;
        Node firstHead = head;
        Node first = mergeSort(firstHead);
        Node second = mergeSort(secondHead);
        Node ans = merge(first, second);
        return ans;
    }
}