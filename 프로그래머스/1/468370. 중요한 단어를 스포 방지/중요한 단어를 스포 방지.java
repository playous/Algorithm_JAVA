import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        int n = spoiler_ranges.length;
        
        HashSet<String> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for (int i = 0; i < n ; i++){
            int s = spoiler_ranges[i][0];
            int e = spoiler_ranges[i][1];
            
            for (int j = s; j <= e; j ++){
                set2.add(j);
            }
        }
        
        int startIdx = 0;
        
        String[] words = message.split(" ");
        
         for (int i = 0 ; i < words.length; i ++){
            String s = words[i];
                
            int len = s.length();
            
            boolean flag = false;
            
            for (int j = startIdx; j < startIdx + len; j ++){
                if (set2.contains(j)){
                    flag = true;
                    break;
                }
            }
            
            if (!flag){
                set.add(s);
            }
            
            startIdx += len + 1;
        }
        
        startIdx = 0;
        
        for (int i = 0 ; i < words.length; i ++){
            String s = words[i];
            
            int len = s.length();
            
            if (!set.contains(s)){
                set.add(s);
                answer++;
            }            
            
            startIdx += len + 1;
        }
        
        return answer;
    }
}