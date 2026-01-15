class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left + 1);
        int c = len;
        int[] answer = new int[len];
        
        int row = (int)(left / n);
        int col = (int)(left % n);
        
        int idx = 0;
        
        while (len > 0){
            if (row >= col) {
                answer[idx] = row + 1;
            }
            else {
                answer[idx] = col + 1;
            }
            col++;
            idx++;
            if (col >= n){
                row++;
                col = 0;
            }
            len--;
        }
        
        return answer;
    }
}

