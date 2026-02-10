import java.io.*;
import java.util.*;

public class Solution {

    static class Node{
        int r;
        int c;
        int dir;
        int value;
        Node(int r, int c, int dir, int value){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.value = value;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            int n = Integer.parseInt(br.readLine());

            List<Node> list = new ArrayList<>();

            for (int i = 0 ; i < n ; i ++) {
                st = new StringTokenizer(br.readLine());
                int c = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int r = (1000 - Integer.parseInt(st.nextToken())) * 2;
                int k = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list.add(new Node(r, c, k, v));
            }

            int answer = 0;

            int cnt = 1;
            while(true) {
                boolean flag = false;

                HashMap<Long, Integer> move = new HashMap<>();

                HashSet<Integer> set = new HashSet<>();

                int size = list.size();

                for (int i = 0; i < size ; i++) {
                    Node cur = list.get(i);
                    int dir = cur.dir;

                    int curR = cur.r + dr[dir];
                    int curC = cur.c + dc[dir];

                    cur.r = curR;
                    cur.c = curC;

                    if(curR < 0 || curC < 0 || curR > 4000 || curC > 4000) {
                        continue;
                    }

                    flag = true;

                    long key = (long) curR * 10001 + curC;
                    if (move.containsKey(key)) {
                        int prev = move.get(key);
                        set.add(prev);
                        set.add(i);
                    } else {
                        move.put(key, i);
                    }

                }

                List<Node> newList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node cur = list.get(i);
                    int curR = cur.r;
                    int curC = cur.c;

                    if (curR < 0 || curC < 0 || curR > 4000 || curC > 4000) {
                        continue;
                    }

                    if (set.contains(i)) {
                        answer += cur.value;
                    } else {
                        newList.add(cur);
                    }
                }
                list = newList;

                if (!flag) break;
                cnt++;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.print(sb.toString());

    }

}