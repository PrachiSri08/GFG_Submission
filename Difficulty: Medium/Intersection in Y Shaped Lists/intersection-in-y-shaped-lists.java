/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        int len1 = 1;
        int len2 = 1;
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1.next!=null){
            temp1=temp1.next;
            len1++;
        }
        while(temp2.next != null){
            temp2 = temp2.next;
            len2++;
        }
        temp1 = head1;
        temp2 = head2;
        if(len1 >= len2){
            while(len1 != len2){
                temp1 = temp1.next;
                len1--;
            }
            while(temp1 != temp2){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return temp1;
        }
        else{
            while(len1 != len2){
                temp2 = temp2.next;
                len2--;
            }
            while(temp1 != temp2){
                temp1 = temp1.next;
                temp2 = temp2.next;
                
            }
            return temp1;
        }
        
    }
}