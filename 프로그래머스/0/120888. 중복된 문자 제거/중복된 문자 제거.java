import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        char[] ch = my_string.toCharArray();
        
        for (char c : ch){
            set.add(c);
        }
        
        for (char c : set){
            sb.append(c);
        }
        
        return sb.toString();
    }
}