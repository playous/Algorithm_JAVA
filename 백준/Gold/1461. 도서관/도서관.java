import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        int max = 0;
        int flag = 0;
        for (int i = 0; i < n; i++) {
            int book = Integer.parseInt(st.nextToken());
            if (Math.abs(book) > max) {
                flag = book > 0 ? 1 : -1;
                max = Math.abs(book);
            }
            list.add(book);
        }

        if (flag == 1){
            Collections.sort(list);
        }
        if (flag == -1){
            Collections.sort(list,Collections.reverseOrder());
        }

        int answer = 0;
        boolean flag1 = false;
        int flag2 = 0;
        while (!list.isEmpty()) {
            int book = list.get(0);
            flag2 = book > 0 ? -1 : 1;

            if (flag != flag2) flag1 = true;
            int pivot = m;
            if (flag1 && (list.size() % m != 0)){
                pivot = list.size() % m;
            }
            else{
                for (int i = 0; i < m; i++) {
                    if (list.size() < i + 1) {
                        pivot = i;
                        break;
                    }
                    if (Math.signum(list.get(i)) != Math.signum(book)) {
                        pivot = i;
                        flag1 = true;
                        break;
                    }
                }
            }
            int maxb = 0;
            for (int i = 0; i < pivot; i++) {
                int b = list.remove(0);
                if (Math.abs(b) > maxb) {
                    maxb = Math.abs(b);
                }
            }
            if (list.size() != 0) {
                maxb *= 2;
            }
            answer += Math.abs(maxb);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}