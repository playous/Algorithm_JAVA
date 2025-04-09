import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        
        for (int i = 0 ; i < ch.length ; i++){
            answer += ch[i] -'0';
        }

        return answer;
    }
}