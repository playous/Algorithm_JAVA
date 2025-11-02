import java.util.*;
import java.io.*;

class Solution {
    static class Node {
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int solution(int[][] routes) {
        int answer = 0;
        List<Node> list = new ArrayList<>();
        int len = routes.length;
        for (int i = 0; i < len; i ++){
            list.add(new Node(routes[i][0], routes[i][1]));
        }
        
        list.sort((a,b) -> a.start - b.start);
        
        int idx = 0;
        
        while (idx < len){
            Node cur = list.get(idx);
            int start = cur.start;
            int end = cur.end;
            idx += 1;
             
            while (idx < len && list.get(idx).start <= end){
                end = Math.min(end, list.get(idx).end);
                idx++;
            }
            answer += 1;
        }
        return answer;
    }
}