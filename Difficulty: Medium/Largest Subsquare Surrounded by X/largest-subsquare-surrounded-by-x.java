class Solution {
    public int largestSubsquare(char[][] a) {
        int n = a.length;
        int[][] right = new int[n][n];
        int[][] down = new int[n][n];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(a[i][j] == 'X') {
                    right[i][j] = 1;
                    down[i][j] = 1;
                    if(j + 1 < n)
                        right[i][j] += right[i][j + 1];
                    if(i + 1 < n)
                        down[i][j] += down[i + 1][j];
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int size = Math.min(right[i][j], down[i][j]);
                while(size > ans) {
                    int bottom = i + size - 1;
                    int rightCol = j + size - 1;
                    if(bottom < n && rightCol < n &&
                       right[bottom][j] >= size &&
                       down[i][rightCol] >= size) {
                        ans = size;
                        break;
                    }
                    size--;
                }
            }
        }
        return ans;
    }
}