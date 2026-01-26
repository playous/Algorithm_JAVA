import java.util.*;

class Solution {
    static class Node{
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    static int len;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        len = book_time.length;
        
        Node[] nodes = new Node[len];
        for (int i = 0 ; i < len ; i ++){
            int start = strToInt(book_time[i][0]);
            int end = strToInt(book_time[i][1]);
            nodes[i] = new Node(start, end + 10);
        }
        
        Arrays.sort(nodes, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (Node n : nodes){
            if(!pq.isEmpty() && pq.peek() <= n.start){
                pq.poll();
            }
            pq.add(n.end);
        }
        
        answer = pq.size();
        return answer;
    }
    
    public int strToInt(String str){
        String[] arr = str.split(":");
        int num = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        return num;
    }
}