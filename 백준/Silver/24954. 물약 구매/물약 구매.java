import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] price = new int[n + 1];
        int[][] sale = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            price[i]= Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= n; i++) {
            int t = Integer.parseInt(br.readLine());
            for (int j = 0; j < t; j++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                sale[i][p] = d;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }

        calc(set,price,sale,n);

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void calc(HashSet<Integer> set , int[] price , int[][] sale, int n) {
        if(set.isEmpty()){
            int cost = 0;
            for (int i = 1 ; i <= n ; i++) {
                cost += price[i];
            }
            answer = Math.min(cost,answer);
        }
        for (int i = 1; i <= n; i++) {
            if(set.contains(i)){
                set.remove(i);
                int[] arr= price.clone();
                for (int j = 1; j <= n; j++) {
                    if (sale[i][j] != 0 && set.contains(j)) {
                        arr[j] = Math.max(arr[j] - sale[i][j], 1);
                    }
                }
                calc(set,arr,sale,n);
                set.add(i);
            }
        }
    }
}