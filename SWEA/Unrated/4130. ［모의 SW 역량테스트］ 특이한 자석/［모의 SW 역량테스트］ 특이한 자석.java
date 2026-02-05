import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static StringBuilder sb = new StringBuilder();
	static int k;
	static int[][] magnet;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			sb.append("#").append(t).append(" ");
			k = Integer.parseInt(br.readLine());
			magnet = new int[4][8];

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken()) - 1; // 1부터 입력받아서 그냥 -1처리.
				int val = Integer.parseInt(st.nextToken());

				int[] rotate = new int[4];

				rotate[op] = val;
				int nextDir = -val;
				int curBlade = magnet[op][2];
				for (int j = 1; j < 4; j++) {
					int next = op + j;
					if (next < 4) {
						int nextBlade = magnet[next][6];
						if (curBlade != nextBlade) {
							rotate[next] = nextDir;
							nextDir = -nextDir;
						} else
							break;
						curBlade = magnet[next][2];
					}
				}

				nextDir = -val;
				curBlade = magnet[op][6];
				for (int j = 1; j < 4; j++) {
					int next = op - j;
					if (next >= 0) {
						int nextBlade = magnet[next][2];
						if (curBlade != nextBlade) {
							rotate[next] = nextDir;
							nextDir = -nextDir;
						} else
							break;
						curBlade = magnet[next][6];
					}
				}
				for (int j = 0; j < 4; j++) {
					if (rotate[j] == 0)
						continue;
					rotate(magnet[j], rotate[j]);
				}
			}
			sb.append(magnet[0][0] + magnet[1][0] * 2 + magnet[2][0] * 4 + magnet[3][0] * 8);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	static void rotate(int[] mag, int direction) {
		if (direction == 1) { // 시계
			int temp = mag[mag.length - 1];

			for (int i = mag.length - 1; i > 0; i--) {
				mag[i] = mag[i - 1];
			}
			mag[0] = temp;

		} else { // 반시계
			int temp = mag[0];

			for (int i = 1; i < mag.length; i++) {
				mag[i - 1] = mag[i];
			}
			mag[mag.length - 1] = temp;
		}
	}
}
