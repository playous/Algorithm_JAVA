class Solution {
    long answer = 1;
    
    int dist_limit, split_limit;
    public int solution(int dist_limit, int split_limit) {
        if (dist_limit == 0) return 1;    
        
        this.dist_limit = dist_limit;
        this.split_limit = split_limit;

        dfs(1, 1, 0);
        
        return (int) answer;
    }
    
    public void dfs(long leaf, long split, long dist){
        if (dist > dist_limit) return;
        if (split > split_limit) return;
        
        answer = Math.max(answer, leaf);
        
        // 3개
        long nLeaf3 = leaf * 3;
        long nSplit3 = split * 3;
        long nDist3 = dist + leaf;
        
        if (nDist3 > dist_limit && nSplit3 <= split_limit){
            nLeaf3 = leaf - (dist_limit - dist) + (dist_limit - dist) * 3; 
            answer = Math.max(answer, nLeaf3);
        }
        else dfs(nLeaf3, nSplit3, nDist3);
        
        // 2개
        long nLeaf2 = leaf * 2;
        long nSplit2 = split * 2;
        long nDist2 = dist + leaf;
        
        if (nDist2 > dist_limit && nSplit2 <= split_limit){
            nLeaf2 =  leaf - (dist_limit - dist)  + (dist_limit - dist) * 2;
            answer = Math.max(answer, nLeaf2);
        }
        else dfs(nLeaf2, nSplit2, nDist2);
    }

}