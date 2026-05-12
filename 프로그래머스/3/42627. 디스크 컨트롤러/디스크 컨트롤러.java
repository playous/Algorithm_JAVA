import java.util.*;

class Solution {
    class Node{
        int start;
        int time;
        int id;
        Node(int id, int start, int time){
            this.id = id;
            this.start = start;
            this.time = time;
        }
    }
    
    PriorityQueue<Node> pq;
    List<Node> list;
    
    public int solution(int[][] jobs) {
        int answer = 0;
        pq = new PriorityQueue<>((a, b) -> {
            if (a.time == b.time){
                if (a.start == b.start){
                    return a.id - b.id;
                }
                return a.start - b.start;
            }
            return a.time - b.time;
        });
        
        list = new ArrayList<>();
        for (int i = 0 ; i < jobs.length; i ++){
            int id = i;
            int start = jobs[i][0];
            int time = jobs[i][1];
            list.add(new Node(id, start, time));
        }
        
        list.sort((a,b) -> a.start - b.start);
        
        int curTime = list.get(0).start;
        push(curTime);
        
        
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            
            int start = Math.max(curTime, cur.start);
            
            int end = start + cur.time;
            
            answer += (end - cur.start);
            curTime = end;
            push(curTime);
            
            if (!list.isEmpty() && pq.isEmpty()){
                int maxTime1 = list.get(0).start;
                push(maxTime1);
            }
        }
        
        return answer / jobs.length;
    }
    
    public void push(int maxTime){
        while(!list.isEmpty()){
            Node cur = list.get(0);
            if (cur.start <= maxTime){
                pq.add(cur);
                list.remove(0);
            }
            else break;
        }
    }
}