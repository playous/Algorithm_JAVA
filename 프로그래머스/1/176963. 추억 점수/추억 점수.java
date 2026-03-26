import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int n = name.length;
        int len = photo.length;
        
        for (int i = 0 ; i < n ; i ++){
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[len];
        
        for (int i = 0 ; i < len ; i++){
            int p = photo[i].length;
            int score = 0;
            
            for (int j = 0; j < p ; j++){
                score += map.getOrDefault(photo[i][j], 0);    
            }
            
            answer[i] = score;
        }

        return answer;
    }
}