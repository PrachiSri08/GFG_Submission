class Solution {

    int transform(String s1, String s2) {

        // Length different hai toh transformation impossible
        if (s1.length() != s2.length()) {
            return -1;
        }

        int n = s1.length();

        // Check whether both strings have same characters
        int[] freq = new int[256];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                return -1;
            }
        }

        int i = n - 1;
        int j = n - 1;
        int ans = 0;

        while (i >= 0) {

            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j--;
            } 
            else {
                ans++;
                i--;
            }
        }

        return ans;
    }
}