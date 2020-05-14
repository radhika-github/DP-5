// Brute Force
// Time Complexity: O(n^n)
// Space Complexity: O(size of dictionary)
 class Solution {

     Set<String> set;

     public boolean wordBreak(String s, List<String> wordDict) {
         set = new HashSet<>(wordDict);
         return helper(s);
     }

     private Boolean helper(String s) {
         if(s.length() == 0) {
             return true;
         }

         for(int i = 0; i <= s.length(); i++) {
             if(set.contains(s.substring(0, i)) && helper(s.substring(i))) {
                 return true;
             }
         }
         return false;
     }
 }

// Time Complexity: O(n x n)
// Space Complexity: O(n)
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}