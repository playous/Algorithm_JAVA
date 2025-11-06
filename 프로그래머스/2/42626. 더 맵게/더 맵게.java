import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int len = scoville.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < len; i ++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K && pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + (b*2));
            answer++;
        }
        if (pq.size() == 1){
            if (pq.poll() < K) answer = -1;
        }
        
        return answer;
    }
}