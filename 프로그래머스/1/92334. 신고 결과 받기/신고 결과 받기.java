import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>();

        int n = id_list.length;
        for (int i = 0 ; i < n ; i ++){
            map.put(id_list[i], new HashSet<String>());   
            map1.put(id_list[i], 0);
        }
        
        for (int i = 0 ; i < report.length ; i ++){
            String[] str = report[i].split(" ");
            String a = str[0];
            String b = str[1];
            
            HashSet<String> sub = map.get(a);
            
            if (sub.contains(b)) continue;
            
            sub.add(b);
            map.put(a, sub);
            map1.put(b, map1.get(b) + 1);
        }
        
        Set<String> remove = new HashSet<>();
        
        for (int i = 0 ; i < n ; i ++){
            if(map1.get(id_list[i]) >= k){
                remove.add(id_list[i]);
            }
        }
        
        int[] answer = new int[n];

        for (int i = 0 ; i < n ; i ++){
            String cur = id_list[i];
            int cnt = 0;
            for (String str : remove){
                if (map.get(cur).contains(str)){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }
}