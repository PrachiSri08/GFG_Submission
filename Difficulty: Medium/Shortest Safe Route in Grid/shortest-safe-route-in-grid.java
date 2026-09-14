class Solution {
    int shortestPath(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] safe = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                safe[i][j] = mat[i][j] == 1;
            }
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] ==0){
                    safe[i][j] = false;
                    for(int k=0; k<4; k++){
                        int nr = i+dr[k];
                        int nc = j+dc[k];
                        if(nr >=0 && nr <n && nc >=0 && nc <m){
                            safe[nr][nc] = false;
                        }
                    }
                }
            }
        }
        Queue<int[]> que = new LinkedList<>();
        boolean[] []vis = new boolean[n][m];
        for(int i=0; i<n; i++){
            if(safe[i][0]){
                que.add(new int[] {i, 0, 1});
                vis[i][0] = true;
            }
        }
        while(!que.isEmpty()){
            int[] curr = que.poll();
            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];
            if(col == m-1){
                return dist;
            }
            for(int k=0; k<4; k++){
                int nr = row + dr[k];
                int nc = col + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    safe[nr][nc] && !vis[nr][nc]) {
                        vis[nr][nc] = true;
                        que.add(new int[]{nr, nc, dist + 1});
                }
            }
        }
        return -1;
    }
}
