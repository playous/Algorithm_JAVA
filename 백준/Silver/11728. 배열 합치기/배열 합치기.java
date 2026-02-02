import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[a];
        int[] arr2 = new int[b];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int idx_a = 0;
        int idx_b = 0;

        for (int i = 0; i < a + b; i ++){
            if (idx_a >= a) {
                sb.append(arr2[idx_b] + " ");
                idx_b++;
            }
            else if (idx_b >= b){
                sb.append(arr1[idx_a] + " ");
                idx_a++;
            }
            else if(arr1[idx_a] < arr2[idx_b]){
                sb.append(arr1[idx_a] + " ");
                idx_a++;
            }
            else{
                sb.append(arr2[idx_b] + " ");
                idx_b++;
            }
        }
        System.out.print(sb.toString());
    }
}