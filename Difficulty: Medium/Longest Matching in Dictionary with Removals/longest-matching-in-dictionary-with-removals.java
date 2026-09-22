class Solution {
    public String findLongestWord(String s, List<String> d) {

        int n = s.length();

        // next[i][c] = next position of character c from index i
        int[][] next = new int[n + 1][26];

        Arrays.fill(next[n], -1);

        for(int i = n - 1; i >= 0; i--) {

            next[i] = next[i + 1].clone();

            next[i][s.charAt(i) - 'a'] = i;
        }

        String ans = "";

        for(String word : d) {

            int pos = 0;
            boolean possible = true;

            for(int i = 0; i < word.length(); i++) {

                int c = word.charAt(i) - 'a';

                if(pos > n || next[pos][c] == -1) {
                    possible = false;
                    break;
                }

                pos = next[pos][c] + 1;
            }

            if(possible) {

                if(word.length() > ans.length() ||
                   (word.length() == ans.length() &&
                    word.compareTo(ans) < 0)) {

                    ans = word;
                }
            }
        }

        return ans;
    }
}