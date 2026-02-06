import java.util.*;
import java.io.*;

class Solution{
    static boolean[][] cant;
    static int n;
	
    static class Node {
        int name;
        boolean[] cant;
        Node(int name, boolean[] cant){
            this.name = name;
            this.cant = cant;
        }
    }
    
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1 ; t <= T ; t++){
            st = new StringTokenizer(br.readLine());
            
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            cant = new boolean[n + 1][n + 1];
            
            for (int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                cant[a][b] = true;
                cant[b][a] = true;
            }
            
            int answer = 1;
            
            Queue<Node> q = new ArrayDeque<>();
            
            for (int i = 1; i <= n ; i++){
                q.add(new Node(i, cant[i]));    
                
                while (!q.isEmpty()){
                    Node cur = q.poll();
                    int cName = cur.name;
                    boolean[] cCant = cur.cant;
                    
                    answer++;
                    
                    for (int j = cName + 1; j <= n ; j++){
                        if(cur.cant[j]) continue;
                        boolean[] newCant = cCant.clone();
                        for (int k = j + 1; k <= n ; k++){
                            if(cant[j][k]) newCant[k] = true;
                        }
                        q.add(new Node(j,newCant));
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}
