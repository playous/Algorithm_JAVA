import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < want.length ; i++){
            map.put(want[i],number[i]);
        }
        
        int answer = 0;
        int mart_len = discount.length;
        int num = 0;
        
        for (int i : number){
            num += i;
        }
        
        for (int i = 0 ; i <= mart_len - num ; i++){
            HashMap<String, Integer> tempMap = new HashMap<>(map);
            boolean isPossible = true;
            for (int j = i; j < num + i; j++){
                String item = discount[j];
                if (!tempMap.containsKey(item) || tempMap.get(item) <= 0){
                    isPossible = false;
                    break;
                }
                tempMap.put(item,tempMap.get(item) - 1);
            }
            if (isPossible) answer++;
        }
        return answer;
    }
}