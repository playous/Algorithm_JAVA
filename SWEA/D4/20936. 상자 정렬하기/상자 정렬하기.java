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
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            List<Integer> result = new ArrayList<>();

            while (!check(arr, n)) {
                int space = n + 1;
                for (int i = n; i >= 1; i--) {
                    if (i == arr[i]) continue;
                    for (int j = 1; j <= n; j++) {
                        if (arr[j] == i) {
                            result.add(j);
                            int temp = arr[space];
                            arr[space] = arr[j];
                            arr[j] = temp;
                            space = j;
                            break;
                        }
                    }
                    if (result.size() == 1) break;
                }
                while (space != n + 1) {
                    for (int j = 1; j <= n + 1; j++) {
                        if (arr[j] == space) {
                            result.add(j);
                            int temp = arr[space];
                            arr[space] = arr[j];
                            arr[j] = temp;
                            space = j;
                            break;
                        }
                    }
                }
            }
            System.out.println(result.size());
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
    }
    static boolean check(int[] arr , int n){
        for (int i = 1; i <= n; i++){
            if (arr[i] != i) return false;
        }
        return true;
    }
}