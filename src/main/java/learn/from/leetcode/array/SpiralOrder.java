package learn.from.leetcode.array;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/spiral-matrix/
 * 		 https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @desc 螺旋矩阵
 * 		给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。	
 */
public class SpiralOrder {
	public int[] spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
		int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
		int index = 0;
		int[] res = new int[(right + 1) * (bottom + 1)];
		while(true) {
			// from left to right
			for (int i = left; i <= right; i++) {
				res[index++] = matrix[top][i]; 
			}
			if (++top > bottom) {
				break;
			}
			// from top to bottom
			for (int i = top; i <= bottom; i++) {
				res[index++] = matrix[i][right]; 
			}
			if (left > --right) {
				break;
			}
			// from right to left
			for (int i = right; i >= left; i--) {
				res[index++] = matrix[bottom][i]; 
			}
			if (top > --bottom) {
				break;
			}
			// from bottom to top
			for (int i = bottom; i >= top; i--) {
				res[index++] = matrix[i][left]; 
			}
			if (++left > right) {
				break;
			}
		}
		return res;
	}

}
