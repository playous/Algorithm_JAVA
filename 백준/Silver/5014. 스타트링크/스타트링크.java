import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int x;
        int time;
        public Node(int x, int time){
            this.x = x;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] count = new int[1000001];
        Arrays.fill(count, Integer.MAX_VALUE);

        Queue<Node> q = new ArrayDeque<Node>();
        q.add(new Node(s, 0));

        int answer = -1;

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.x == g) {
                answer = cur.time;
                break;
            }

            if (cur.x + u <= f){
                if(count[cur.x + u] > cur.time + 1) {
                    count[cur.x + u] = cur.time + 1;
                    q.add(new Node(cur.x + u , cur.time + 1));
                }
            }
            if (cur.x - d >= 1) {
                if (count[cur.x - d] > cur.time + 1) {
                    count[cur.x - d] = cur.time + 1;
                    q.add(new Node(cur.x - d, cur.time + 1));
                }
            }
        }
        if (answer == -1) System.out.println("use the stairs");
        else System.out.println(answer);
    }
}