import java.io.FileInputStream;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n + 2];
            boolean[] visited = new boolean[n + 2];
            for (int i = 1; i <= n; i++) {
                arr[sc.nextInt()] = i;
            }
            List<Integer> result = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if(visited[i]){
                    continue;
                }
                if (arr[i] == i) {
                    continue;
                }
                result.add(i);
                int target = arr[i];
                while (target != i) {
                    result.add(target);
                    visited[target] = true;
                    target = arr[target];
                }
                result.add(n + 1);
            }
            System.out.println(result.size());
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
    }
}