class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[101];
        
        for (int i = 2 ; i * i <= 100 ; i++){
            if(arr[i] == 0){            
                for (int j = i * i; j <= 100 ; j += i){
                    arr[j] = 1;
                }
            }
        }
        
        for (int i = 4 ; i <= n ; i++){
            if(arr[i] == 1) answer++;
        }
 
        return answer;
    }
}