import java.util.*;
import java.io.*;

class Solution{
    static int[][] arr;
    
    static int[] point;
    static boolean[] visited;
    
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T ; t++){
            int k = Integer.parseInt(br.readLine());
            
            arr = new int[5][80];
            point = new int[]{0, 40, 40, 40, 40};
            for (int i = 1 ; i <= 4 ; i ++){
                st = new StringTokenizer(br.readLine());
                int[] arr1 = new int[8];
                for (int j = 0 ; j < 8 ; j ++){
                    arr1[j] = Integer.parseInt(st.nextToken());
                }
                for (int j = 0 ; j < 80 ; j++) {
                	arr[i][j] = arr1[j % 8];
                }
            }
            
            for (int i = 0 ; i < k ; i ++){
                st = new StringTokenizer(br.readLine());
                int name = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                visited = new boolean[5];
                visited[0] = true;
                
                calc(name,dir);
            }
            int answer = 0;
            int[] score = {0, 1, 2, 4 ,8};
            for (int i = 1; i <= 4; i ++){
                int p = point[i];
                if(arr[i][p] == 1){
                    answer += score[i];
                }
            }
            
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
	}

    
    public static void calc(int name, int dir){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(name);
        visited[name] = true;
        int[] change = new int[5];
        change[name] = dir;
        
        while (!q.isEmpty()){
            int cName = q.poll();
            int cDir = change[cName];
            int cPoint = point[cName];
           
            if (canLeft(cName, cPoint)){
            	q.add(cName - 1);
                
                change[cName - 1] = cDir * -1;
                
                visited[cName - 1] = true;
            }
            if (canRight(cName, cPoint)){
            	q.add(cName + 1);
                
                change[cName + 1] = cDir * -1;
                
                visited[cName + 1] = true;
            }
        }
        
        for (int i = 1; i <= 4 ; i++) {
        	move(i, change[i]);
        }
    }
        
    public static boolean canLeft(int cName, int cPoint){
        int nName = cName - 1;
        if(nName >= 1 && !visited[nName]) {
        	int nPoint = point[nName];
        	if (arr[cName][cPoint - 2] != arr[nName][nPoint + 2]){
        		return true;
        	}
        }
        return false;
    }
    public static boolean canRight(int cName, int cPoint){
        int nName = cName + 1;
        if(nName <= 4 && !visited[nName]) {
        	int nPoint = point[nName];
        	if (arr[cName][cPoint + 2] != arr[nName][nPoint - 2]){
        		return true;
        	}
        }
        return false;
    }
    
    public static void move(int name, int dir){
        if (dir == -1){
            point[name]++;
        }
        if (dir == 1){
            point[name]--;
        }
    }
}