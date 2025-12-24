import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        boolean[] check = new boolean[n];
        Arrays.fill(check, true);
        
        Set<Integer>[] set = new Set[8];
        for (int i = 1; i <= 7 ; i ++){
            set[i] = new HashSet<>();
        }
        for (int i = 1; i <= 6 ; i ++){
            set[i].add(7 - i);
            set[i].add(6 - i);
        }
        set[7].add(0);
        set[7].add(6);
        
        for (int i = 0 ; i < n; i ++){
            int goal = change(schedules[i] + 10);
            for (int j = 0; j < 7 ; j++){
                if(set[startday].contains(j)) continue;
                if(change(timelogs[i][j]) > goal) {
                    check[i] = false;
                    break;
                }
            }
        }
        
        for (int i = 0 ; i < n ; i ++){
            if(check[i]) answer++;
        }
        return answer;
    }
    
    public int change(int num){
        int h = num / 100;
        int m = num % 100;
        return h * 60 + m;
    }
}