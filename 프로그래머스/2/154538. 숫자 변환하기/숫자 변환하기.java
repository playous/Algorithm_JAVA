import java.util.*;

class Solution {
    class Node {
        int value;
        int count;
        Node(int value, int count){
            this.value = value;
            this.count = count;
        }
    }
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[1000001];
        
        q.add(new Node(x, 0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            int v = cur.value;
            int c = cur.count;
                        
            if (v == y) {
                answer = c;
                break;
            }
            
            if (v + n <= y && !visited[v + n]) {
                q.add (new Node(v + n, c + 1));
                visited[v + n] = true;
            }
            if (v * 2 <= y && !visited[v * 2]) {
                q.add (new Node(v * 2, c + 1));
                visited[v * 2] = true;
            }
            if (v * 3 <= y && !visited[v * 3]) {
                q.add (new Node(v * 3, c + 1));
                visited[v * 3] = true;
            }
        }
        
        return answer;
    }
}