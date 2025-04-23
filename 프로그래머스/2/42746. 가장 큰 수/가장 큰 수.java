import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        String[] st = new String[numbers.length];
        int index = 0;
        
        for (int i : numbers){
            st[index++] = String.valueOf(i);
        }
        Arrays.sort(st, (a,b) -> (b + a).compareTo(a + b));
        
        for (String s : st){
            sb.append(s);
        }
        if (sb.toString().startsWith("0")) return "0";
        return sb.toString();
    }
}