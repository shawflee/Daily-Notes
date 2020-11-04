//给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组 
// 👍 380 👎 0


package com.shawf.leetcode.editor.cn;

//岛屿的最大面积

public class P695_MaxAreaOfIsland{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P695_MaxAreaOfIsland().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    	int res = 0;
    	for(int i = 0; i < grid.length; i++){
    		for(int j = 0; j < grid[0].length; j++){
    			if(grid[i][j] == 1){
    				res = Math.max(res,dfs(grid,i,j));
				}
			}
		}
    	return res;
    }
	public int dfs(int[][] grid, int row, int col) {
    	if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
    		return 0;
		}
		grid[row][col] = 0;
		return 1 + dfs(grid, row, col - 1) +
				   dfs(grid, row, col + 1) +
				   dfs(grid, row - 1, col) +
				   dfs(grid, row + 1, col);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}