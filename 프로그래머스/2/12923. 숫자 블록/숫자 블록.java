class Solution {
    public int[] solution(long begin, long end) {
         int length = (int)(end - begin + 1);
         int[] answer = new int[length];
        
        for (int i = 0 ; i < length ; i++){
            long position = begin + i;
            if (position == 1){
                answer[i] = 0;
                continue;
            }
            answer[i] = check(position);
        }
        
        return answer;
    }
    
    public int check(long num){
        int max = 1;
        for (int i = 2; i <= Math.sqrt(num);i++){
            if(num % i == 0) {
                max = i;
                
                if (num / i <= 10000000){
                    return (int)(num / i);
                    }
               }
            }
        return max;
    }
}