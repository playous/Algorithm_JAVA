class Solution {
    static int answerLen;
    static int answerLeft;
    static int answerRight;
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        
        int n = sequence.length;
        
        answerLen = Integer.MAX_VALUE;
        answerLeft = 0;
        answerRight = 0;
        
        int sum = sequence[0];
        
        while (right < n){
            if (sum < k) {
                right++;
                if (right == n) break;
                sum += sequence[right];
            }
            else if (sum == k) {
                calc(left, right);
                sum -= sequence[left];
                left++;
            }
            else {
                sum -= sequence[left];
                left++;
            }
        }
        
        answer[0] = answerLeft;
        answer[1] = answerRight;
        return answer;
    }
    
    public static void calc(int left, int right){
        if (right - left + 1  < answerLen){
            answerLen = right - left + 1;
            answerLeft = left;
            answerRight = right;
        }
    }
}