class Solution {
    public int solution(int[] box, int n) {
        int num_x = box[0]/n;        
        int num_y = box[1]/n; 
        int num_z = box[2]/n; 
        return num_x * num_y * num_z;
    }
}