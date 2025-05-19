import java.util.*;

class Solution {
    
    public class data{
        int sum;
        int count;
        public data(int sum, int count){
            this.sum = sum;
            this.count = count;
        }
    }
    
    public int solution(int x, int y, int n) {
        int answer = dfs(x,y,n);
        return answer;
    }
    
    public int dfs (int x, int y, int n){
        Queue<data> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.add(new data(x,0));
        visited.add(x);
        
        while(!q.isEmpty()){
            data d = q.poll();
            if (d.sum == y) return d.count;
            
            int[] nextValues = {d.sum + n, d.sum * 2, d.sum * 3};
            
            for (int next : nextValues) {
                if (next > y || visited.contains(next)) {
                    continue;
                }
                
                q.add(new data(next, d.count + 1));
                visited.add(next);
            }
        }
        return -1;
    }
}