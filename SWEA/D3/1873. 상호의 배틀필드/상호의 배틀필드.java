import java.util.*;
import java.io.*;

class Solution{
    
    static char[][] map;
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    static HashMap<Character, Integer> hashMap = new HashMap<>();
    
    static int tankR, tankC, tankDir;
    static int h, w;
    
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        hashMap.put('U', 0);
        hashMap.put('R', 1);
        hashMap.put('D', 2);
        hashMap.put('L', 3);
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1 ; t <= T ; t++){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            for (int i = 0 ; i < h ; i ++){
                String s = br.readLine();
                for (int j = 0 ; j < w ; j ++){
                    char c = s.charAt(j);
                    map[i][j] = c;
                    if(c == '^'){
                        tankR = i;
                        tankC = j;
                        tankDir = 0;
                    }
                    if(c == '>'){
                        tankR = i;
                        tankC = j;
                        tankDir = 1;
                    }
                    if(c == 'v'){
                        tankR = i;
                        tankC = j;
                        tankDir = 2;
                    }
                    if(c == '<'){
                        tankR = i;
                        tankC = j;
                        tankDir = 3;
                    }
                }
            }
  
            
	        int n = Integer.parseInt(br.readLine());
	            
	        String s = br.readLine();
	            
	        for (int i = 0 ; i < n ; i++){
	            char c = s.charAt(i);
	                
	            if (c == 'S'){
	                shoot();
	            }
	            else {
	                move(c);
	            }
	         
	        }
	        
	        if (tankDir == 0){
	            map[tankR][tankC] = '^';
	        }
	        if (tankDir == 1){
	            map[tankR][tankC] = '>';
	        }
	        if (tankDir == 2){
	            map[tankR][tankC] = 'v';
	        }
	        if (tankDir == 3){
	            map[tankR][tankC] = '<';
	        }
            
	        sb.append("#").append(t).append(" ");
	        
	        for (int i = 0 ; i < h; i++){
	            for (int j = 0; j < w ; j++){
	                sb.append(map[i][j]);
	            }
	            sb.append("\n");
	        }
        }
        
        System.out.print(sb.toString());
	}
    
    public static void shoot(){
        int shootR = tankR;
        int shootC = tankC;
        int shootDir = tankDir;
        
        int nextR = shootR;
        int nextC = shootC;
        
        while(true){
            nextR += dr[shootDir];
            nextC += dc[shootDir];
            
            if (nextR < 0 || nextC < 0 || nextR >= h || nextC >= w){
                break;
            }
            
            if (map[nextR][nextC] == '#'){
                break;
            }
            if (map[nextR][nextC] == '*'){
                map[nextR][nextC] = '.';
                break;
            }
        }
    }
    
    public static void move(char c){
        tankDir = hashMap.get(c);
        
        int nextR = tankR + dr[tankDir];
        int nextC = tankC + dc[tankDir];
        
        if (nextR >= 0 && nextC >= 0 && nextR < h && nextC < w){
            if (map[nextR][nextC] == '.'){
                map[tankR][tankC] = '.';
                tankR = nextR;
                tankC = nextC;
            }
        }
    }
}