import java.io.*;
import java.util.*;
public class BuildGates {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("gates.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));

		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int currentX = 2002;
		int currentY = 2002;
		boolean[][] isFence = new boolean[4005][4005];
		isFence[currentX][currentY] = true;
		for(int i = 0; i < N; i++) {
			int directionX = 0, directionY = 0;
			if(s.charAt(i) == 'N') {
				directionX = -1;
			}
			else if(s.charAt(i) == 'S') {
				directionX = 1;
			}
			else if(s.charAt(i) == 'W') {
				directionY = -1;
			}
			else {
				directionY = 1;
			}
			for(int a = 0; a < 2; a++) {
				currentX += directionX;
				currentY += directionY;
				isFence[currentX][currentY] = true;
			}
		}
		int ret = -1;
		int[] dx = new int[]{-1,1,0,0};
		int[] dy = new int[]{0,0,-1,1};
		for(int i = 0; i < isFence.length; i++) {
			for(int j = 0; j < isFence[i].length; j++) {
				if(isFence[i][j]) {
					continue;
				}
				ret++;
				LinkedList<Point> q = new LinkedList<Point>();
				q.add(new Point(i, j));
				isFence[i][j] = true;
				while(!q.isEmpty()) {
					Point curr = q.removeFirst();
					for(int k = 0; k < dx.length; k++) {
						int nx = curr.x + dx[k];
						int ny = curr.y + dy[k];
						if(nx >= 0 && nx < isFence.length && ny >= 0 && ny < isFence[nx].length && !isFence[nx][ny]) {
							isFence[nx][ny] = true;
							q.add(new Point(nx, ny));
						}
					}
				}
			}
		}
        br.close();
		pw.println(ret);
		pw.close();
	}
	static class Point {
		public int x,y;
		public Point(int xIn, int yIn) {
			x = xIn;
			y = yIn;
		}
	}
	
}