import java.util.*;

class Solution {
    int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        dfs(1,n,0, q, ans, new ArrayList<Integer>());
        return answer;
    }
    
    void dfs(int start, int n, int count, int[][]q, int[] ans, List<Integer> current){
        if(count == 5){
            answer += check(current, q, ans);
        }
        
        for (int i = start ; i <= n ; i ++){
            current.add(i);
            dfs(i+1, n, count+1, q, ans, current);
            current.remove(current.size() - 1);
        }
    }
    
    int check(List<Integer> current, int[][] q, int[] ans){
        int idx = 0;
        int check = 0;
        for (int[] arr : q){
            int cnt = ans[idx++];
            for (int i : arr){
                if(current.indexOf(i) != -1) cnt--;
            }
            if (cnt == 0) check++;
        }
        return check == ans.length ? 1 : 0;
    }
}