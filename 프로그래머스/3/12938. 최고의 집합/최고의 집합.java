class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (n > s){
            return new int[]{-1};
        }
        
        int num1 = s/n;
        int num2 = s%n;
        for (int i = 0; i < n - num2 ; i ++){
            answer[i] = num1;
        }
        for (int i = n - num2 ; i < n ; i ++){
            answer[i] = num1+1;
        }
        
        return answer;
    }
}