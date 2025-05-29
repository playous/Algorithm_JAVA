import java.util.*;

class Solution {
    class Data{
        int x;
        int y;
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    List<Data> list;
    public String[] solution(int[][] line) {
        list = new ArrayList<>();
        for (int i = 0 ; i < line.length; i++){
            for (int j = i + 1; j < line.length ; j++){
                find(line[i][0],line[i][1],line[i][2],line[j][0],line[j][1],line[j][2]);
            }
        }
        int max_x = Integer.MIN_VALUE;
        int max_y = Integer.MIN_VALUE;
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        
        for (Data d : list){
           if(d.x > max_x) max_x = d.x;
           if(d.x < min_x) min_x = d.x;
           if(d.y > max_y) max_y = d.y; 
           if(d.y < min_y) min_y = d.y;
        }
        
        char[][] arr = new char[max_y - min_y + 1][max_x - min_x + 1];
        for(int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], '.');
        }
        
        for (Data d: list){
            System.out.println(d.x + " " + d.y);
            int a = d.x - min_x; 
            int b = max_y - d.y; 
            arr[b][a] = '*';
        }
        
        String[] answer = new String[max_y-min_y+1];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]); 
        }
        
        return answer;
    }
    
    void find(long a, long b, long e, long c, long d, long f){
        long A = (b*f) - (e*d); 
        long B = (e*c) - (a*f); 
        long C = (a*d) - (b*c);
        if(C == 0) return;
        if(A % C != 0 || B % C != 0) return;
        list.add(new Data((int)(A / C),(int)(B / C)));
    }
}