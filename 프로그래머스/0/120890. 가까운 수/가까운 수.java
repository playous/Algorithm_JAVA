import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int index = 0;
        Arrays.sort(array);
        for (int num : array){
            if(n < num) break;
            index++;
        }
        if(index == array.length) return array[index-1];
        if(index == 0) return array[0];
        if(n - array[index - 1] > array[index] - n) return array[index];
        return array[index - 1];
    }
}