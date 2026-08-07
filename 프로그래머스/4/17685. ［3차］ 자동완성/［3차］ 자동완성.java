import java.util.*;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        
        Arrays.sort(words);
        int n = words.length;
        
        for (int i = 0; i < n; i++) {
            int maxPrefix = 0;
            
            if (i > 0) {
                maxPrefix = Math.max(maxPrefix, calc(words[i], words[i - 1]));
            }
            
            if (i < n - 1) {
                maxPrefix = Math.max(maxPrefix, calc(words[i], words[i + 1]));
            }
            
            answer += Math.min(words[i].length(), maxPrefix + 1);
        }
        
        return answer;
    }
    
    private int calc(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return i;
            }
        }
        return len;
    }
}