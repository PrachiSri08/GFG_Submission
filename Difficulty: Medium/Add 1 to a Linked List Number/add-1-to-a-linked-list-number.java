/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node front = head;
        while(curr != null){ 
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
           
        }
        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        if(head == null){
            return new Node(1);
        }
        head = reverse(head);
        Node curr = head;
        Node prev = null;
        int carry = 1;
        while(curr != null && carry ==1){
            int sum = curr.data + carry;
            curr.data = sum%10;
            carry = sum/10;
            prev = curr;
            curr = curr.next;
        }
        if(carry == 1){
            prev.next = new Node(1);
        }
        head = reverse(head);
        return head;
    }
}