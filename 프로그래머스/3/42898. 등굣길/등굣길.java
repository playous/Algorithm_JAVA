class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m+1][n+1];
        boolean[][] water = new boolean[m+1][n+1];
    
        for (int[] arr : puddles){
            water[arr[0]][arr[1]] = true;
        }
        map[0][1] = 1;
        
        for (int i = 1;  i <= m ; i++){
            for (int j = 1; j <= n ; j++){
                if(water[i][j] == false){
                   map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007; 
                }
            }
        }
       
        return map[m][n];
    }
}