/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public boolean pathfind(Node root, int target, StringBuilder path){
        if(root == null){
            return false;
        }
        if(root.data == target){
            return true;
        }
        path.append("L");
        if(pathfind(root.left, target, path)){
            return true;
        }
        path.deleteCharAt(path.length()-1);
        
        path.append("R");
        if(pathfind(root.right, target, path)){
            return true;
        }
        path.deleteCharAt(path.length()-1);
        return false;
    }
    public Node lca(Node root, int p, int q){
        if(root == null || root.data == p || root.data == q){
            return root;
        }
        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);
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
    public int numberOfTurns(Node root, int p, int q) {
        // code here
        int count =0;
        Node ancs = lca(root, p, q);
        StringBuilder pathp = new StringBuilder();
        pathfind(ancs, p, pathp);
        StringBuilder pathq = new StringBuilder();
        pathfind(ancs, q, pathq);
        String totalpath = pathp.reverse().toString() + pathq.toString();
        for(int i=1; i<totalpath.length(); i++){
            if(totalpath.charAt(i) != totalpath.charAt(i-1)){
                count++;
            }
        }
        if(count == 0){
            return -1;
        }
        return count;
    }
}