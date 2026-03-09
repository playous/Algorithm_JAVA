import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Node(s, e));
        }

        list.sort((a, b) -> {
            if (a.end == b.end) return a.start - b.start;
            return a.end - b.end;
        });

        int prev = 0;
        int answer = 0;

        for (int i = 0; i < n; i ++){
            Node cur = list.get(i);

            int curStart = cur.start;
            int curEnd = cur.end;

            if (prev <= curStart){
                prev = curEnd;
                answer++;
            }
        }

        System.out.print(answer);

    }

}