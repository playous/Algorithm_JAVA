import java.util.*;
import java.io.*;

class Solution{
    static class Node {
        int start;
        int end;
        int count;
        Node(int start, int end, int count){
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }
    
    static int[] arr;
    static int[] answerArr;
    static int n, x;
    static boolean flag;
    static List<Node> list;
    static int answerSum;
    
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            list = new ArrayList<>();
            
            for (int i = 0 ; i < m ; i ++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new Node(s,e,c));
            }
            
            arr = new int[n + 1];
            flag = false;
            answerSum = -1;
            calc(1, 0);
            
            
            sb.append("#").append(t).append(" ");
            if (flag){
                for (int i = 1; i <= n ; i++){
                    sb.append(answerArr[i]).append(" ");
                }
            }
            if (!flag) sb.append("-1");
            sb.append("\n");
        }
        System.out.print(sb.toString());
	}
	
    public static void calc(int idx, int sum){
        if (idx == n + 1){
            if (check() && sum > answerSum){
            	flag = true;
            	answerSum = sum;
            	answerArr = arr.clone();
            }
            return;
        }
        for (int i = 0; i <= x; i++){
            arr[idx] = i;
            calc(idx + 1, sum + i);
        }
    }
    
    public static boolean check(){
        for (Node n : list){
            int s = n.start;
            int e = n.end;
            int c = n.count;
            int sum = 0;
            for (int i = s; i <= e ; i++){
                sum += arr[i];
            }
            if (sum != c) return false;
        }
        return true;
    }
}