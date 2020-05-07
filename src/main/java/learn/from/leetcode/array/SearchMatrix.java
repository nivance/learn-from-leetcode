package learn.from.leetcode.array;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 		 https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @desc 搜索二维矩阵: 
 * 			编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 			* 每行的元素从左到右升序排列。
 * 			* 每列的元素从上到下升序排列。
 */
public class SearchMatrix {
	
	// 1、暴力法
	// 2、二分查找
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int shorterDim = Math.min(matrix.length, matrix[0].length);
		for (int i = 0; i < shorterDim; i++) {
			boolean verticalFound = binarySearch(matrix, target, i, true);
			boolean horizontalFound = binarySearch(matrix, target, i, false);
			if (verticalFound || horizontalFound) {
				return true;
			}
		}
		return false;
	}

	private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
		int lo = start;
		int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;
		while (hi >= lo) {
			int mid = (lo + hi) / 2;
			if (vertical) {
				if (matrix[start][mid] < target) {
					lo = mid + 1;
				} else if (matrix[start][mid] > target) {
					hi = mid - 1;
				} else {
					return true;
				}
			} else {
				if (matrix[mid][start] < target) {
					lo = mid + 1;
				} else if (matrix[mid][start] > target) {
					hi = mid - 1;
				} else {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 从右上角找起，大于target, 横坐标-1，小于target，纵坐标+1
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int i = 0;
		int start = matrix[0].length - 1;
		while (start >= 0 && i < matrix.length) {
			if (matrix[i][start] == target) {
				return true;
			} else if (matrix[i][start] < target) {
				i++;
			} else if (matrix[i][start] > target) {
				start--;
			}
		}
		return false;
	}
}
