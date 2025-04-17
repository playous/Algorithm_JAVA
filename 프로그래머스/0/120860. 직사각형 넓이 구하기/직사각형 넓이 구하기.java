class Solution {
    public int solution(int[][] dots) {
        int x1 = -256;
        int x2 = 256;
        int y1 = -256;
        int y2 = 256;
        
        for (int[] arr : dots){
            x1 = arr[0] > x1 ? arr[0] : x1;
            x2 = arr[0] < x2 ? arr[0] : x2;
            y1 = arr[1] > y1 ? arr[1] : y1;
            y2 = arr[1] < y2 ? arr[1] : y2;
        }
        
        return (x1 - x2) * (y1 - y2);
    }
}