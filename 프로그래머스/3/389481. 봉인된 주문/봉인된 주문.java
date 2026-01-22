import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = calc(n);
        
        Arrays.sort(bans, (a,b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            else return a.length() - b.length();
        });
        
        long subN = n;
        
        for (int i = 0 ; i < bans.length;){
            boolean flag = false;
            while(i < bans.length && (compare(bans[i], answer) <= 0)) {
                subN++;
                i++;
                flag = true;
            }
            if(flag){
                answer = calc(subN);
            }
            else break;
        }
        
        return answer;
    }
    
    public int compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() - s2.length();
        }
        return s1.compareTo(s2);
    }
    
    public String calc(long n) {
        StringBuilder sb = new StringBuilder();
        int len = 1;
        long count = 26;

        while (n > count) {
            n -= count;
            count *= 26;
            len++;
        }

        n--;  
        for (int i = 0; i < len; i++) {
            sb.append((char)('a' + (n % 26)));
            n /= 26;
        }

        return sb.reverse().toString();
    }
}