class Solution {
    public int count(int[] arr, int target){
        int countVal =0;
        int n = arr.length;
        for(int i=0; i<n-2; i++){
            int j=i+1;
            int k=n-1;
            while(j < k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum <= target){
                    countVal+=k-j;
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return countVal;
    }
    public int countTriplets(int[] arr, int l, int r) {
        // code here
        //int n = arr.length;
        Arrays.sort(arr);
        return count(arr, r) - count(arr, l-1);
        
    }
}