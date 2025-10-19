import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        for (int i : works){
            pq.add(i);
        }
        
        while(n > 0){
            int num = pq.poll();
            pq.add(--num);
            n--;
        }
        
        while (!pq.isEmpty()){
            long num = pq.poll();
            if (num < 0) continue;
            answer += Math.pow(num,2);
        }
        
        return answer;
    }
}