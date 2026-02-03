import java.io.*;
import java.util.*;

class Solution{
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1 ; t <= 10 ; t++){
            int n = Integer.parseInt(br.readLine());

            int answer = 1;

            for (int i = 0 ; i < n ; i ++){
                String[] arr = br.readLine().split(" ");

                char data = arr[1].charAt(0);

                if (arr.length == 4) {
                    if (data >= '0' && data <= '9') {
                        answer = 0;
                    }
                }

                if (arr.length == 2){
                    if (data < '0' || data > '9') {
                        answer = 0;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
