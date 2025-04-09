import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] answer = new char[my_string.length()];
        char[] ch = my_string.toCharArray();
        for (int i = 0 ; i < ch.length ; i++){
            answer[i] = ch[ch.length - i - 1];
        }
        return new String(answer);
    }
}