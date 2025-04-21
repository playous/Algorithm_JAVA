class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[][] arr = new int[n+2][n+2];
        
        for (int i = 0 ;i < n ; i++){
            for (int j = 0; j < n; j++){
                arr[i+1][j+1] = board[i][j];
            }
        }
        
        int answer = 0;
        for (int i = 0 ; i < n; i ++){
            for (int j = 0 ; j < n; j++){
                if (board[i][j] == 1){
                    arr[i][j] = 1;
                    arr[i][j+1] = 1;
                    arr[i][j+2] = 1;
                    arr[i+1][j] = 1;
                    arr[i+1][j+2] = 1;
                    arr[i+2][j] = 1;
                    arr[i+2][j+1] = 1;
                    arr[i+2][j+2] = 1;
                }
            }
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n ; j++){
                if(arr[i][j] == 0) answer++;
            }
        }
    
        return answer;
    }
}