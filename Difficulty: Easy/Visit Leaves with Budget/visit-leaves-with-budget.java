/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
        // code here
        List<Integer> levels = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        int level =1;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                Node curr = que.poll();
                if(curr.left == null && curr.right == null){
                    levels.add(level);
                }
                if(curr.left != null){
                    que.add(curr.left);
                }
                if(curr.right != null){
                    que.add(curr.right);
                }
            }
            level++;
        }
        Collections.sort(levels);
        int count=0;
        for(int lvl : levels){
            if(k < lvl){
                break;
            }
            k = k-lvl;
            count++;
        }
        return count;
    }
}