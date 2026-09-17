class Solution {
    class Pair{
        int node;
        int cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new Pair(v , 0));
            adj.get(v).add(new Pair(u , 1));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(src);
        dist[src] = 0;
        while(!dq.isEmpty()){
            int node = dq.pollFirst();
            for(Pair p : adj.get(node)){
                int newDist = dist[node] + p.cost;
                if(newDist < dist[p.node]){
                    dist[p.node] = newDist;
                    if(p.cost == 0){
                        dq.addFirst(p.node);
                    }
                    else{
                        dq.addLast(p.node);
                    }
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}