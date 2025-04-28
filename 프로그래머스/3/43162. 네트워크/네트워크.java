class Solution {
    static boolean[] visited;
    static int count;
    static int answer;
    
    public int solution(int n, int[][] computers) {
        answer = n;
        count = n;
        visited = new boolean[n];
        
        for (int i = 0 ; i < count ; i++){
            visited[i] = true;
            dfs(computers[i], computers);
        }
        
        return answer;
    }
    
    public void dfs(int[] arr, int[][]computers){
        for (int i = 0 ; i < count ; i++){
            if (visited[i] == false && arr[i] == 1){
                visited[i] = true;
                answer--;
                dfs(computers[i], computers);
            }
        } 
    }
}