import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {

	class MySecond {
		public int maxSum(int[][] grid) {
			int n = grid.length;
			int m = grid[0].length;
			int res = 0;
			for(int i = n - 1; i > 0;i--){
				for(int j = m - 1;j>0;j--){
					res = Math.max(sum(grid, i , j), res);
				}
			}
			return res;
		}
		private int sum(int[][] grid, int n , int m){
			if(n - 2 < 0 || m - 2  < 0){
				return 0;
			}
			int[][] dirs = {{0,0},{0,-1},{0,-2},{-1,-1},{-2,0},{-2,-1},{-2,-2}};
			int res = 0;
			for(int[] dir : dirs){
				res += grid[n + dir[0]][m + dir[1]];
			}
			return res;
		}
		
	}

	class Two {
		public int maxSum(int[][] a) {
			int n = a.length, m = a[0].length;
			int ans = 0;
			for(int i = 0;i < n-2;i++){
				for(int j = 0;j < m-2;j++){
					int s = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
					ans = Math.max(ans, s);
				}
			}
			return ans;
		}
	}

    class Three {
		public int minimizeXor(int num1, int num2) {
			int o = num1;
			int s = Integer.bitCount(num2);
			for(int d = 29;d >= 0 && s > 0;d--){
				if(num1<<~d<0){
					num1 ^= 1<<d;
					s--;
				}
			}
			for(int d = 0;d < 30 && s > 0;d++){
				if(o<<~d>=0){
					num1 ^= 1<<d;
					s--;
				}
			}
			return num1 ^ o;
		}
	}
    // Four
    class Four {
		public int deleteString(String S) {
			char[] s = S.toCharArray();
			int n = s.length;
			int[] dp = new int[n];
			for(int i = n-1;i >= 0;i--){
				char[] t = Arrays.copyOfRange(s, i, n);
				int[] z = Z(t);
				dp[i] = 1;
				for(int j = 1;2*j <= t.length;j++){
					if(z[j] >= j){
						dp[i] = Math.max(dp[i], dp[i+j] + 1);
					}
				}
			}
			return dp[0];
		}

		public int[] Z(char[] str)
		{
			int n = str.length;
			int[] z = new int[n];
			if(n == 0)return z;
			z[0] = n;
			int l = 0, r = 0;
			for(int i = 1;i < n;i++){
				if(i > r){
					l = r = i;
					while(r < n && str[r-l] == str[r])r++;
					z[i] = r-l; r--;
				}else{
					if(z[i-l] < r-i+1){
						z[i] = z[i-l];
					}else{
						l = i;
						while(r < n && str[r-l] == str[r])r++;
						z[i] = r-l; r--;
					}
				}
			}

			return z;
		}

	}
}
