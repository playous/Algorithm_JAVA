import java.util.*;

class Solution {
    Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int goal : course) {
            map = new HashMap<>();
            
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                if (arr.length < goal) continue;
                calc(arr, goal, 0, new char[goal], 0);
            }
            
            int max = 0;
            for (int v : map.values()) max = Math.max(max, v);
            
            if (max >= 2) {
                for (String key : map.keySet()) {
                    if (map.get(key) == max) answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    private void calc(char[] arr, int goal, int start, char[] cur, int idx) {
        if (idx == goal) {
            String key = new String(cur);
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            cur[idx] = arr[i];
            calc(arr, goal, i + 1, cur, idx + 1);
        }
    }
}