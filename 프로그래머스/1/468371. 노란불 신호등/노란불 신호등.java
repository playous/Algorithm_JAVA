class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        
        int n = signals.length;
        boolean[][] arr = new boolean[n][];
        
        for (int i = 0 ; i < n ; i ++){
            int len = signals[i][0] + signals[i][1] + signals[i][2];
            
            int start = signals[i][0];
            
            arr[i] = new boolean[len];
            
            for (int j = 0; j < signals[i][1] ; j ++){
                arr[i][start + j] = true;
            }
            
        }
        
        
        
        for (int i = 0 ; i <= 100000000; i ++){
            boolean flag = true;
            for (int j = 0 ; j < n ; j ++){
                if (!arr[j][i % arr[j].length]){
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}