class Solution {
    public int solution(int[][] lines) {
        int[] line = new int[201];
        int answer = 0;
        
        for (int[] arr : lines){
            for (int j = arr[0]; j < arr[1] ; j++){
                line[j+100] += 1;
            }
        }
        
        for (int i = 0 ; i < 201 ; i++){
            if(line[i] >= 2) {
                answer += 1;
            }
        }
        
        return answer;
    }
}