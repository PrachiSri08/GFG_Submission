/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int solve(Node root, int maxAncs){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int curr = maxAncs - root.data;
        maxAncs = Math.max(maxAncs, root.data);
        int left = solve(root.left, maxAncs);
        int right = solve(root.right, maxAncs);
        return Math.max(curr, Math.max(left, right));
    }
    int maxDiff(Node root) {
        //  code here
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        return Math.max(
            solve(root.left, root.data),
            solve(root.right, root.data)
        );
    }
}