import java.io.*;
import java.util.*;

class Solution {
    
    static int[] arr;
    static int[] arr1 = new int[9];
    static int win;
    static int lose;
    static List<Integer> list;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1 ; t <= T ; t++){
            arr = new int[9];
            visited = new boolean[9];
            
            list = new ArrayList<>();
            
            win = 0;
            
            for (int i = 1 ; i <= 18 ; i ++){
                list.add(i);
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < 9 ; i ++){
                arr[i] = Integer.parseInt(st.nextToken());
                list.remove(Integer.valueOf(arr[i]));
            }
            
            calc(0);
            
            
            lose = 362880 - win;
            
            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    public static void calc(int idx){
        if (idx == 9) {
            if (calc2()) win ++;
            return;
        }
        for (int i = 0 ; i < 9; i++){
        	if(visited[i]) continue;
            arr1[idx] = list.get(i);
            
            visited[i] = true;
            calc(idx + 1);
            visited[i] = false;
        }
    }
    
    public static boolean calc2(){
        int sumA = 0;
        int sumB = 0;
        for (int i = 0 ; i < 9 ; i ++){
            int score = arr[i] + arr1[i];
            if(arr[i] > arr1[i]) sumA += score;
            else sumB += score;
        }
        return sumA > sumB;
    }
}