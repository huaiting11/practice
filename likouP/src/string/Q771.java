package string;

import java.util.HashSet;
import java.util.Set;

public class Q771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            set.add(c);
        }
        int total = 0;
        for (int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i))){
                total++;
            }
        }
        return total;
    }
}
