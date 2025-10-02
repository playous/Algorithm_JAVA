import java.util.*;
import java.io.*;

class Main {
    static class Node {
        int day;
        int score;
        public Node(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Node(d, w));
        }
        list.sort((a,b) -> {
            if (a.day == b.day) {
                return b.score - a.score;
            }
            return b.day - a.day;
        });

        int max = list.get(0).day;

        int answer = 0;

        for (int i = max ; i > 0; i--) {
            if (list.isEmpty()) break;
            int size = 0;
            int maxScore = 0;
            int maxIdx = 0;
            boolean flag = false;
            while (list.get(size).day >= i){
                if (list.get(size).score > maxScore){
                    maxScore = list.get(size).score;
                    maxIdx = size;
                }
                flag = true;
                size++;
                if (size == list.size()) {
                    break;
                }
            }
            if (flag) {
                answer += maxScore;
                list.remove(maxIdx);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}