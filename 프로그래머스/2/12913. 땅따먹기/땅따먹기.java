class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int len = land.length;
        
        for (int i = 1; i < len; i ++){
            for (int j = 0; j < 4; j++){
                int max = 0;
                for (int k = 0 ; k < 4 ; k++){
                    if (k == j) continue;
                    max = Math.max(land[i-1][k],max);
                }
                land[i][j] += max;
            }
        }

        for (int j = 0 ; j < 4 ; j++){
            if (land[len-1][j] > answer) answer = land[len-1][j];
        }
        
        return answer;
    }
}