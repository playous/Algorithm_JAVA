class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int min = Math.min(a,b);
        int gcd = 1; 
        
        for (int i = 2 ; i <= min ; i ++){
            if(a % i == 0 && b % i == 0) 
                gcd = i;
        }
        b /= gcd;
        while(b % 2 == 0){
            b /= 2;
        }
        while(b % 5 == 0){
            b /= 5;
        }
        
        return b == 1 ? 1 : 2;
    }
}