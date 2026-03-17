
import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int start;
        int end;
        Node (int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        for (int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }

        list.sort((a, b) -> {
            if (a.start == b.start) return b.end - a.end;
            return a.start - b.start;
        });

        stack.push(list.remove(0));

        while(!list.isEmpty()){
            Node cur = list.remove(0);
            Node top = stack.peek();

            if (top.start <= cur.start && top.end >= cur.end) continue;

            if (top.end >= cur.start){
                stack.pop();
                stack.push(new Node(top.start, cur.end));
            }
            else{
                stack.push(cur);
            }
        }

        stack.sort((a, b) -> b.end - a.end);


        int canGo = 0;

        int answer = 0;

        while(!stack.isEmpty()){
            Node cur = stack.pop();
            if (cur.start > canGo) break;

            int len = cur.end - cur.start;
            canGo = Math.max(canGo, cur.end + len);

            answer = cur.end;
        }

        System.out.print(answer);
    }
}