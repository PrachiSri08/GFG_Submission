/* Structure of binary tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
}
}*/

class Solution {
    Node lca(Node root, int n1, int n2) {
        // code here
        if( root == null || n1 == root.data || n2 == root.data){
            return root;
        }
         Node left = lca(root.left, n1, n2);
         Node right = lca(root.right, n1, n2);
         if(left == null){
             return right;
         }
         else if(right == null){
             return left;
         }
         else{
             return root;
         }
    }
}