import java.util.*;

class Solution {
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        String[] s = letter.split(" ");
        String[] mos = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for (int i = 0; i < s.length; i++){
            for (int j = 0; j < mos.length; j++){
                if(s[i].equals(mos[j])){
                    sb.append((char)('a' + j));
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}