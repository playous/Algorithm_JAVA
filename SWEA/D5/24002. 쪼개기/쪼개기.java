import java.io.FileInputStream;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
  
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Map<Integer,Integer>[] mapList = new HashMap[n];

            for (int i = 0; i < n; i++) {
                mapList[i] = getNumber(arr[i]);
            }

            Set<Integer> set = mapList[0].keySet();
            for (int i = 1; i < n ; i++){
                set.retainAll(mapList[i].keySet());
            }

            int answer = Integer.MAX_VALUE;
            for (int num : set) {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    cnt += mapList[i].get(num);
                }
                answer = Math.min(answer,cnt);
            }

            System.out.println(answer);
        }
    }
    public static Map<Integer, Integer> getNumber(int number){
        Queue<Integer> queue = new LinkedList();
        Map<Integer, Integer> cases = new HashMap();
        queue.add(number);
        cases.put(number, 0);

        while (!queue.isEmpty()){
            int currentNumber = queue.poll();
            int left = currentNumber/2;

            if (!cases.containsKey(left)){
                cases.put(left, cases.get(currentNumber)+1);
                queue.add(left);
            }

            if (currentNumber%2 == 0){
                continue;
            }
            int right = left+1;
            if (!cases.containsKey(right)){
                cases.put(right, cases.get(currentNumber)+1);
                queue.add(right);
            }
        }
        return cases;
    }
}