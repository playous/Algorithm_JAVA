import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}

		int result = 0;
		int s = 0;
		int e = n-1;

		Collections.sort(nums);

		while (s < e) {
			int total = nums.get(s) + nums.get(e);
			
			if (total == m) {
				result += 1;
				s++;
				e--;
			} else if (total < m) {
				s++;
			} else {
				e--;
			}
		}
		System.out.println(result);
	}
}
