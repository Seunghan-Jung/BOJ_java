// 양 한마리... 양 두마리...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char[][] grid = new char[H][W];

			for (int i = 0; i < H; i++) {
				grid[i] = br.readLine().toCharArray();
			}

			boolean[][] visit = new boolean[H][W];

			int answer = 0;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (grid[i][j] == '#' && !visit[i][j]) {
						dfs(i, j, grid, visit, H, W);
						answer += 1;
					}
				}
			}

			System.out.println(answer);
		}
		System.out.println(br.readLine());
	}

	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	public static void dfs(int x, int y, char[][] grid, boolean[][] visit, int H, int W) {
		visit[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= H || ny < 0 || ny >= W)
				continue;

			if (grid[nx][ny] == '#' && !visit[nx][ny])
				dfs(nx, ny, grid, visit, H, W);
		}
	}

}
