import java.util.*;
import java.io.*;

class Solution {
    class Node {
        int start;
        int end;
        Node (int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int solution(int[][] routes) {
        int answer = 0;

        int n = routes.length;
        
        List<Node> list = new ArrayList<>();
        
        for (int i = 0 ; i < n ; i ++){
            int s = routes[i][0];
            int e = routes[i][1];
            list.add(new Node(s, e));
        }
        
        Collections.sort(list, (a, b) -> a.end - b.end);
        
        int last = -30001;
        
        for (Node node : list){
            if (node.start <= last) continue;
            last = node.end;
            answer++;
        }
        
        return answer;
    }
}