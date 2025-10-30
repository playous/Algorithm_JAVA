import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[500001];
        List<Integer> list = new ArrayList<>();

        long answer = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(!check[num] && num <= n){
                check[num] = true;
            }
            else {
                list.add(num);
            }
        }
        Collections.sort(list);

        for (int i = 1; i < 500001; i++) {
            if (!check[i]) {
                answer += Math.abs(list.remove(0) - i);
            }
            if(list.isEmpty()){
                break;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
