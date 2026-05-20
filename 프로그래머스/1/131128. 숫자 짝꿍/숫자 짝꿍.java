import java.util.*;

class Solution {
    public String solution(String X, String Y) {

        StringBuilder sb = new StringBuilder();
        
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        
        for (int i = 0 ; i < 10 ; i ++){
            xMap.put(i, 0);
            yMap.put(i, 0);
        }
        
        for (int i = 0; i < X.length(); i ++){
            int cur = X.charAt(i)-'0';
            xMap.put(cur, xMap.get(cur) + 1);
        }
        for (int i = 0; i < Y.length(); i ++){
            int cur = Y.charAt(i)-'0';
            yMap.put(cur, yMap.get(cur) + 1);
        }
        
        for (int i = 9 ; i >= 0 ; i--){
            int cnt = Math.min(xMap.get(i), yMap.get(i));
            
            if (cnt == 0) continue;
            
            if (i == 0 && sb.length() == 0) {
                sb.append(0);
                break;
            }
            for (int j = 0; j < cnt ; j ++){
                sb.append(i);
            }
        }
        
        if (sb.length() == 0) sb.append("-1");
        
        return sb.toString();
    }
}