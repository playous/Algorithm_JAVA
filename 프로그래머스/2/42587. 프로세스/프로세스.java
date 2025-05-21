import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> high = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++){
            high.add(priorities[i]);
            q.offer(i);
        }
        
        high.sort((a,b) -> b - a);
        
        int count = 1;
        
        while (!q.isEmpty()){
            int k = q.poll();
            if(priorities[k] == high.get(0)) {
                if (k == location) return count;
                high.remove(0);
                count++;
            }
            q.offer(k);
        }
        return count;
    }
}