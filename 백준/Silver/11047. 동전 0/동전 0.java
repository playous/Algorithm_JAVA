
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < n ; i ++){
            int coin = Integer.parseInt(br.readLine());
            list.add(coin);
        }

        list.sort(Collections.reverseOrder());

        int answer = 0;

        for (int i = 0; i < n ; i ++){
            int cur = list.get(i);

            if (cur <= k){
                answer += (k / cur);
                k %= cur;
            }
        }

        System.out.print(answer);
    }

}