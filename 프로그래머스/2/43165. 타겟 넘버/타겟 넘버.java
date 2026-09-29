class Solution {
    
    int answer = 0;
    int len;
    int[] arr;
    
    public int solution(int[] numbers, int target) {
        this.arr = numbers;
        this.len = arr.length;
        
        dfs(0, 0, target);
        
        return answer;
        
    }
    
    public void dfs (int sum, int cnt, int target){
        if(cnt == len){
            if(sum == target) answer++;
            return;
        }
        
        dfs(sum + arr[cnt], cnt + 1 , target);
        dfs(sum - arr[cnt], cnt + 1 , target);
    }
}