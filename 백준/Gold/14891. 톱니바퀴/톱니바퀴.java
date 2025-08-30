import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list = new List[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 1; i <= 4; i++) {
            list[i] = new LinkedList<>();
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                list[i].add(s.charAt(j) - '0');
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            boolean[] flag = new boolean[3];
            int r1 = list[1].get(2);
            int l2 = list[2].get(6);
            int r2 = list[2].get(2);
            int l3 = list[3].get(6);
            int r3 = list[3].get(2);
            int l4 = list[4].get(6);
            if (r1 != l2) flag[0] = true;
            if (r2 != l3) flag[1] = true;
            if (r3 != l4) flag[2] = true;
            boolean check1 = false;
            boolean check2 = false;


            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dict = Integer.parseInt(st.nextToken());

            if (num == 1){
                calc(1,dict);
                dict *= -1;
                if (flag[0]){
                    calc(2,dict);
                    dict *= -1;
                    check1 = true;
                }
                if (flag[1] && check1){
                    calc(3,dict);
                    dict *= -1;
                    check2 = true;
                }
                if (flag[2] && check2){
                    calc(4,dict);
                }
            } else if (num == 2) {
                calc(2, dict);
                dict *= -1;
                if (flag[0]) {
                    calc(1, dict);
                }
                if (flag[1]) {
                    calc(3, dict);
                    check1 = true;
                }
                if (check1 && flag[2]){
                    dict *= -1;
                    calc(4, dict);
                }
            } else if (num == 3) {
                calc(3, dict);
                dict *= -1;
                if (flag[1]) {
                    calc(2, dict);
                    check1 = true;
                }
                if (flag[2]) {
                    calc(4, dict);
                }
                if (check1 && flag[0]) {
                    dict *= -1;
                    calc(1, dict);
                }
            } else if (num == 4) {
                calc(4,dict);
                dict *= -1;
                if (flag[2]){
                    calc(3,dict);
                    dict *= -1;
                    check1 = true;
                }
                if (flag[1] && check1){
                    calc(2,dict);
                    dict *= -1;
                    check2 = true;
                }
                if (flag[0] && check2){
                    calc(1,dict);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= 4; i++) {
            if (list[i].get(0) == 1) answer += Math.pow(2, i - 1);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
    static void calc (int num, int dict){
        if(dict == 1){
            int last = list[num].remove(7);
            list[num].add(0, last);
        }
        else if (dict == -1){
            int first = list[num].remove(0);
            list[num].add(7,first);
        }
    }
}
