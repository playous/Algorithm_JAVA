class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for (int num : array){
            answer += count7(num);
        }
        return answer;
    }
    
    int count7(int num){
        int count = 0;
        while(num > 0){
            if (num % 10 == 7) count++;
            num /= 10;
        }
        return count;
    }
}