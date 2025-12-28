import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int n = tangerine.length;
        int[] count = new int[n + 1];
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < n; i++){
            int num = tangerine[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : map.values()){
            count[num]++;
        }
        
        for (int i = n ; i >= 0 ; i--){
            for (int j = 0 ; j < count[i]; j++){
                k -= i;
                answer++;
                if (k <= 0) break;
            }
            if (k <= 0) break;
        }
        
        return answer;
    }
}