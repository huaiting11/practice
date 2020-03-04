package dp;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 */
public class Q647_palindromic_substrings {
    public int countSubstrings(String s) {
        int res = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("d:/dd/cell1.xml");
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println("dddd");
    }
}
