package leetcode;

import java.util.List;

/**
 * Created by ruidli on 2017/6/12.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for (int i = 1; i <=length; i++) {
            for (String str : wordDict) {
                if (str.length() <= i) {
                    if (dp[i - str.length()]) {
                        if (s.substring(i-str.length(),i).equals(str)){
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[length];
    }

    public static void main(String args[]){
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
    }
}
