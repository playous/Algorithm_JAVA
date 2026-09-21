import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i ++){
            int cur = tangerine[i];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int v : map.values()){
            list.add(v);
        }
        
        Collections.sort(list, (a, b) -> b - a);
        
        while (k > 0){
            answer++;
            k -= list.remove(0);
        }
        
        return answer;
    }
}