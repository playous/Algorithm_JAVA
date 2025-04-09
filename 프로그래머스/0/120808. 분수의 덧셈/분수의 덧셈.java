
class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int mother = denom1 * denom2;
        numer1 *= mother/denom1;
        numer2 *= mother/denom2;
        
        int k = calculate(numer1+numer2, mother);
        
        answer[0] = (numer1+numer2) / k;
        answer[1] = mother / k;
    
        return answer;
    }
    int calculate(int a , int b){
        int k = 1;
        for (int i = 2; i <= Math.min(a,b); i ++){
            if(a % i == 0 && b % i == 0){
                k = i;
            }
        }
        return k;
    }
}