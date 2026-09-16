/* Structure of Doubly Linked List Node
class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}; */

class Solution {
    public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node left = head;
        Node curr = head;
        Node right = head;
        while(curr != null){
            right = curr;
            curr = curr.next;
        }
        int sum=0;
        while(left != right && left.prev != right){
            sum = left.data + right.data;
            if(sum > target){
                right = right.prev;
            }
            else if(sum < target){
                left = left.next;
            }
            else{
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                ans.add(pair);
                left= left.next;
                right = right.prev;
            }
        }
        return ans;
    }
}