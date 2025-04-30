class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int lasttime = attacks[attacks.length - 1][0];
        
        int index = 0;
        int cnt = 0;
        int max = health;
        
        for (int i = 0; i <= lasttime; i++){
            if(i == attacks[index][0]){
                health -= attacks[index][1];
                if (health <= 0) return -1;
                index++;
                cnt = 0;
            }
            else {
                cnt++;
                health += bandage[1];
                if (cnt == bandage[0]){
                    health += bandage[2];
                    cnt = 0;
                }
                if (health > max) {
                    health = max;
                }
            }
        }
        return health;
    }
}