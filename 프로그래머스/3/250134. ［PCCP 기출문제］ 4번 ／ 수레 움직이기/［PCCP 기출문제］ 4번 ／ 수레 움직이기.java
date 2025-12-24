class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visitedB;
    static boolean[][] visitedR;
    static int R, C;
    static int[] goalR = new int[2];
    static int[] goalB = new int[2];
    static boolean checkR, checkB;
    
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] maze) {
        R = maze.length;
        C = maze[0].length;
        visitedB = new boolean[R][C];
        visitedR = new boolean[R][C];
        
        int[] startR = new int[2];
        int[] startB = new int[2];
        
        for (int i = 0 ; i < R; i ++){
            for (int j = 0 ; j < C ; j++){
                if(maze[i][j] == 1){
                    startR[0] = i;
                    startR[1] = j;
                    visitedR[i][j] = true; 
                }
                if(maze[i][j] == 2){
                    startB[0] = i;
                    startB[1] = j;
                    visitedB[i][j] = true; 
                }
                if(maze[i][j] == 3){
                    goalR[0] = i;
                    goalR[1] = j;
                }
                if(maze[i][j] == 4){
                    goalB[0] = i;
                    goalB[1] = j;
                }
            }
        }
        
        calc(maze, startB[0], startB[1], startR[0], startR[1], 0);
        
        if (answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }
    
    public void calc(int[][] map, int br , int bc, int rr, int rc, int count){
        if(br == goalB[0] && bc == goalB[1] && rr == goalR[0] && rc == goalR[1]){
            answer = Math.min(answer, count);
            return;
        }
        
        if (br == goalB[0] && bc == goalB[1]) checkB = true;
        if (rr == goalR[0] && rc == goalR[1]) checkR = true;
        
        for (int i = 0 ; i < 4; i ++){
            int nextBr = br + dr[i];
            int nextBc = bc + dc[i];
            if (checkB) {
                nextBr = br;
                nextBc = bc;
            }
            if (nextBr >= 0 && nextBr < R && nextBc >= 0 && nextBc < C){
                if ((!visitedB[nextBr][nextBc] && map[nextBr][nextBc] != 5) || checkB){
                    for (int j = 0 ; j < 4 ; j ++){
                        int nextRr = rr + dr[j];
                        int nextRc = rc + dc[j];
                        if (checkR) {
                            nextRr = rr;
                            nextRc = rc;
                        }
                        if (nextRr == nextBr && nextBc == nextRc) continue;
                        if (nextBr == rr && nextBc == rc && nextRr == br && nextRc == bc) continue;
                        if (nextRr >= 0 && nextRr < R && nextRc >= 0 && nextRc < C){
                            if((!visitedR[nextRr][nextRc] && map[nextRr][nextRc] != 5) || checkR){
                                visitedB[nextBr][nextBc] = true;
                                visitedR[nextRr][nextRc] = true;
                                calc(map, nextBr, nextBc, nextRr, nextRc , count + 1);
                                visitedB[nextBr][nextBc] = false;
                                visitedR[nextRr][nextRc] = false;
                            }
                        }
                    }
                }
            }
        }
        checkR = false;
        checkB = false;
    }
}