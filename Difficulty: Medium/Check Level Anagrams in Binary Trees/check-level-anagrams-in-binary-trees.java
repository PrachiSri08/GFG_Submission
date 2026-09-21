/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        // code here
        Queue<Node> que1 = new LinkedList<>();
        Queue<Node> que2 = new LinkedList<>();
        que1.add(root1);
        que2.add(root2);
        while(!que1.isEmpty() && !que2.isEmpty()){
            int n1 = que1.size();
            int n2 = que2.size();
            if(n1 != n2){
                return false;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<n1; i++){
                Node curr1 = que1.poll();
                map.put(curr1.data, map.getOrDefault(curr1.data, 0)+1);
                if(curr1.left!=null){
                    que1.add(curr1.left);
                }
                if(curr1.right != null){
                    que1.add(curr1.right);
                }
            }
            for(int i=0; i<n2; i++){
                Node curr2 = que2.poll();
                if(!map.containsKey(curr2.data)){
                    return false;
                }
                map.put(curr2.data, map.get(curr2.data)-1);
                if(map.get(curr2.data) == 0){
                    map.remove(curr2.data);
                }
                if(curr2.left != null){
                    que2.add(curr2.left);
                }
                if(curr2.right != null){
                    que2.add(curr2.right);
                }
            }
        }
            
        return que1.isEmpty() && que2.isEmpty();
        
    }
}
