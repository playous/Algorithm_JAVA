class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = park.length;
        int y = park[0].length();
        int[] answer = new int[2];
        int[][] map = new int[x][y];
        int index = 0;
        int a = 0;
        int b = 0;
        
        for (String s: park){
            for (int i = 0 ; i < y ; i++){
                if(s.charAt(i) == 'X') map[index][i] = -1;
                if(s.charAt(i) == 'S') {
                    a = index;
                    b = i;
                }
            }
            index++;
        }
        
        int dx = 0;
        int dy = 0;
        
        for (String s : routes){
            dx = 0;
            dy = 0;
            char c = s.charAt(0);
            int count = (int)(s.charAt(2) - '0');
            if (c == 'N'){
                dx = -1;
            }
            if (c == 'S'){
                dx = 1;
            }
            if (c == 'W'){
                dy = -1;
            }
            if (c == 'E'){
                dy = 1;
            }
            for (int i = 1 ; i <= count ; i++){
                a += dx;
                b += dy;
                if (a < 0 || a > x -1 || b < 0 || b > y-1){
                    a -= (dx * i);
                    b -= (dy * i);
                    break;
                }
                if (map[a][b] == -1){
                    a -= (dx * i);
                    b -= (dy * i);
                    break;
                }
            }
        }
        answer[0] = a;
        answer[1] = b;
        
        return answer;
    }
}