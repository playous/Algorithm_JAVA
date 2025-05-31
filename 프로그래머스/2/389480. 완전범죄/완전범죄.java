import java.util.*;

class Solution {
    Set<String> memo = new HashSet<>();
    
    int answer = 120;
    int len = 0;
    public int solution(int[][] info, int n, int m) {
        len = info.length;
        dfs(info,n,m, 0, 0);
        return answer == 120 ? -1 : answer ;
    }
    void dfs(int[][] info , int n, int m, int count, int cost){
        if(cost > answer) return;
        if(count == len){
            answer = cost;
            return;
        }
        String key = n + " " + m + " " + count;
        if (memo.contains(key)) return;
        
        int a = info[count][0];
        int b = info[count][1];
        if(n - a > 0) dfs(info, n - a, m, count+1, cost + a);
        if(m - b > 0) dfs(info, n, m - b, count+1, cost);
        
        memo.add(key);
        
    }
}