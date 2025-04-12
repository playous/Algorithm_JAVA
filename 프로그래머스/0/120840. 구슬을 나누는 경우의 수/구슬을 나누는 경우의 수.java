class Solution {
    public int solution(int balls, int share) {
        double mother = 1;
        double child = 1;
        
        if(balls / 2 < share){
            share = balls - share;
        }
        
        for (int i = 1 ; i <= share ; i ++){
            mother *= i;
        }
        
        for (int i = balls ; share > 0;i--) {
            child *= i;
            share--;
        }
        
        
        return (int)(child/mother);
    }
}