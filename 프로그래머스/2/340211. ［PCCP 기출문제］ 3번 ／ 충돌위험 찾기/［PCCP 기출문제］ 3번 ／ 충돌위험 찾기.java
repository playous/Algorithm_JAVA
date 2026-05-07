import java.util.*;

class Solution {
    
    HashMap<String, Integer> map = new HashMap<>();
    
    int time;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int robot = routes.length;
        int route = routes[0].length;
        
        for (int i = 0 ; i < robot; i ++){
            int start = routes[i][0];
            
            int startR = points[start-1][0];
            int startC = points[start-1][1];
            
            time = 0;
            
            String s = new String(startR + "," + startC + "," + time);
            map.put(s, map.getOrDefault(s, 0) + 1);
                        
            for (int j = 1 ; j < route; j ++){
                int next = routes[i][j];
                
                int goalR = points[next-1][0];
                int goalC = points[next-1][1];
                
                calc(startR, startC, goalR, goalC);
                
                startR = goalR;
                startC = goalC;
            }
        }
        
        for (int num : map.values()){
            if (num > 1){
                answer ++;
            }
        }
        
        return answer;
    }
    
    public void calc(int sr, int sc, int gr, int gc){
        
        if (sr < gr){
            for (int i = sr + 1; i <= gr ; i ++){
                time++;
                String s = new String(i + "," + sc + "," + time);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
            
        if (sr > gr){
             for (int i = sr - 1; i >= gr ; i --){
                time++;
                String s = new String(i + "," + sc + "," + time);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        
        if (sc < gc){
            for (int j = sc + 1; j <= gc ; j ++){
                time++;
                String s = new String(gr + "," + j + "," + time);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        
        if (sc > gc){
            for (int j = sc - 1; j >= gc ; j --){
                time++;
                String s = new String(gr + "," + j + "," + time);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
    }
}