class Solution {
    public long formPyramid(int[] arr) {

        int n = arr.length;

        long total = 0;

        for(int x : arr)
            total += x;

        long[] prefix = new long[n + 1];

        for(int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + arr[i];

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;

        for(int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }

        right[n - 1] = 1;

        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        long ans = Long.MAX_VALUE;

        for(int i = 0; i < n; i++) {

            int peak = Math.min(left[i], right[i]);

            long pyramidSum = 1L * peak * peak;

            long cost = total - pyramidSum;

            ans = Math.min(ans, cost);
        }

        return ans;
    }
}