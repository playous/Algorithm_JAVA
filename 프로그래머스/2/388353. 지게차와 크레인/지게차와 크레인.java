import java.util.*;

class Solution {
    char[][] map;
    int n, m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        map = new char[n + 2][m + 2];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                map[i + 1][j + 1] = storage[i].charAt(j);

        for (String req : requests) {
            char target = req.charAt(0);
            if (req.length() == 1) {
                forklift(target);
            } else {
                crane(target);
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (map[i][j] != '\0') answer++;

        return answer;
    }

    void forklift(char target) {
        boolean[][] visited = new boolean[n + 2][m + 2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        List<int[]> toRemove = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= n + 2 || nc < 0 || nc >= m + 2) continue;
                if (visited[nr][nc]) continue;

                if (map[nr][nc] == target) {
                    visited[nr][nc] = true;
                    toRemove.add(new int[]{nr, nc});
                } else if (map[nr][nc] == '\0') {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        for (int[] pos : toRemove)
            map[pos[0]][pos[1]] = '\0';
    }

    void crane(char target) {
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (map[i][j] == target)
                    map[i][j] = '\0';
    }
}