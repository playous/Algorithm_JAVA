import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rank = 1;
        int idx = 1;

        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if(n != 0) st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < n ; i ++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i : list) {
            if(score > i) break;
            if(score != i) rank++;
            idx++;
        }

        int answer = idx > p ? -1 : rank;

        bw.write(String.valueOf(answer));
        bw.flush();
    }


}