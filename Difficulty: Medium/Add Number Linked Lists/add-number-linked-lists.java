/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
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
    
    public Node addTwoLists(Node head1, Node head2) {
        // code here
        head1 = reverse(head1);
        head2 = reverse(head2);
        
        int carry = 0;
        Node curr1 = head1;
        Node curr2 = head2;
        Node dummy = new Node(0);
        Node temp = dummy;
        //Node prev2 = null;
        while(curr1 != null || curr2 != null || carry != 0){
            int sum = carry;
            if(curr1 != null){
                sum+=curr1.data;
                curr1 = curr1.next;
            }
            if(curr2 != null){
                sum+=curr2.data;
                curr2 = curr2.next;
            }
            temp.next = new Node(sum%10);
            temp = temp.next;
            carry = sum/10;
        }
        Node ans = reverse(dummy.next);
        while(ans != null && ans.data == 0 && ans.next != null){
            ans = ans.next;
        }
        return ans;
    }    
}
