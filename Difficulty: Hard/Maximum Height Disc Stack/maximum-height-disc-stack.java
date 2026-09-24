class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        int[][] disc = new int[n][2];
        for(int i = 0; i < n; i++) {
            disc[i][0] = r[i];
            disc[i][1] = h[i];
        }
        Arrays.sort(disc, (a, b) -> a[0] - b[0]);
        int[] bit = new int[1002];
        int ans = 0;
        int i = 0;
        while(i < n) {
            int j = i;
            while(j < n && disc[j][0] == disc[i][0]) {
                j++;
            }
            int[] dp = new int[j - i];
            for(int k = i; k < j; k++) {
                int height = disc[k][1];
                dp[k - i] = query(bit, height - 1) + height;
                ans = Math.max(ans, dp[k - i]);
            }
            for(int k = i; k < j; k++) {
                int height = disc[k][1];
                update(bit, height, dp[k - i]);
            }
            i = j;
        }
        return ans;
    }
    private int query(int[] bit, int index) {
        int ans = 0;
        while(index > 0) {
            ans = Math.max(ans, bit[index]);
            index -= index & -index;
        }
        return ans;
    }
    private void update(int[] bit, int index, int value) {
        while(index < bit.length) {
            bit[index] = Math.max(bit[index], value);
            index += index & -index;
        }
    }
}