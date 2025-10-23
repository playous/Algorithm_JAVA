import java.io.*;
import java.util.*;

class Main {
    static int[] days = new int[13];

    static class Node{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int answer = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i < 13; i++) {
            days[i] = days[i - 1];
            if(i == 2 || i == 4 || i == 6 || i == 8 || i == 9 || i == 11) {
                days[i] += 31;
            }
            else if (i == 5 || i == 7 || i == 10 || i == 12) {
                days[i] += 30;
            }
            else days[i] += 28;
        }

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int start = days[a] + b;
            int end = days[c] + d ;

            if (c <= 2 || a == 12) continue;
            list.add(new Node(start, end));
        }

        list.sort((a, b) -> (a.start - b.start));
        int len = list.size();

        int idx = 0;

        int start = 31 + 29;
        int end = 365 - 30;

        int max = 0;
        while (start < end){
            boolean flag = false;
            for (int i = idx; i < len; i++) {
                Node cur = list.get(i);
                if (cur.start > start) break;

                if(cur.end > max){
                    max = cur.end;
                    flag = true;
                    idx = i + 1;
                }
            }
            if (flag){
                start = max;
                answer++;
            }
            else break;
        }
        if (start < end) bw.write("0");
        else bw.write(String.valueOf(answer));
        bw.flush();
    }

}