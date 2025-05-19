import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int count = (picks[0] + picks[1] + picks[2]) ;
        Integer[] arr = new Integer[count];
        
        for (int i = 0; i < arr.length; i++) {
             arr[i] = 0;
        }
        
        /*
        다이아몬드 = 100
        철 = 10
        돌 = 1
        */
        
        int index = 0;
        
        for (int i = 0 ; i < minerals.length; i++){
            if (index >= count) break;
            int sum = 0;
            if (minerals[i].startsWith("d")) sum = 100;
            if (minerals[i].startsWith("i")) sum = 10;
            if (minerals[i].startsWith("s")) sum = 1;
            
            arr[index] += sum;
            if ((i + 1) > 4 && (i + 1) % 5 == 0) index++;
        }
        
        Arrays.sort(arr,Collections.reverseOrder());
        
        
        for (int num : arr){
            int[] get = getCount(num);
            int d = get[0];
            int i = get[1];
            int s = get[2];
            
            if (picks[0] > 0){
                answer += (d + i + s);
                picks[0]--;
            }
            else if (picks[1] > 0){
                answer += ((d * 5) + i + s);
                picks[1]--;
            }
            else if (picks[2] > 0){
                answer += ((d * 25) + (i * 5) + s);
                picks[2]--;
            }
        }
        
        return answer;
    }
    
    public int[] getCount(int num){
        int[] arr = new int[3];
        if (num / 100 > 0){
            arr[0] = num / 100;
            num %= 100;
        }
        if (num / 10 > 0){
            arr[1] = num / 10;
            num %= 10;
        }
        arr[2] = num;
        
        return arr;
    }
}