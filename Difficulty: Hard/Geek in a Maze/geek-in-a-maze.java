class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        if(mat[r][c] == '#'){
            return 0;
        }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r,c,0});
        int[][] countUp = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(countUp[i], Integer.MAX_VALUE);
        }
        countUp[r][c]=0;
        boolean[][] vis = new boolean[n][m];
        vis[r][c] = true;
        int count =1;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        while(!que.isEmpty()){
            int row = que.peek()[0];
            int col = que.peek()[1];
            int up = que.peek()[2];
            que.poll();
            //count++;
            for(int i=0; i<4; i++){
                int nr = row+dr[i];
                int nc = col+dc[i];
                if(nr >=n || nr<0 || nc <0 || nc >=m || mat[nr][nc] == '#'){
                    continue;
                }
                int newUp = up;
                if(nr < row){
                    newUp++;
                }
                int down = newUp + nr-r;
                if(newUp <=u && down<=d && newUp<countUp[nr][nc]){
                    countUp[nr][nc] = newUp;
                    que.add(new int[]{nr, nc, newUp});
                    if(!vis[nr][nc]){
                    vis[nr][nc] = true;
                    count++;
                }
                }
                
            }
            
        }
        return count;
    }
}