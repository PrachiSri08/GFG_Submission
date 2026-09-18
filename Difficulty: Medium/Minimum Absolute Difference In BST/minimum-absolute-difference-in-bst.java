/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int absDiff(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++) {
            ans = Math.min(ans, list.get(i) - list.get(i - 1));
        }
        return ans;
    }
    void inorder(Node root, ArrayList<Integer> list) {
        if(root == null)
            return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}