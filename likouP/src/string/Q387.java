package string;

public class Q387 {
    public int firstUniqChar(String s) {
        if(s.length() == 0) return -1;
        for (int i = 0; i < s.length(); i++) {
            boolean flag = true;
            for (int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                    flag = false;
                }
            }
            if(flag){
                return i;
            }

        }
        return 0;
    }
}
