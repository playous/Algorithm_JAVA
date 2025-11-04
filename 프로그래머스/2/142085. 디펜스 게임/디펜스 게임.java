import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long sum = 0;
        
        for (int i = 0 ; i < enemy.length ; i ++){
            int cur = enemy[i];
            sum += cur;
            if (k == 0 && sum > n) break;
            pq.add(cur);
            if (sum > n){
                int max = pq.poll();
                sum -= max;
                k--;
            }
            answer++;
            
        }
        return answer;
    }
}