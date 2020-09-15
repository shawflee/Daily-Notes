package com.shawf;

/**
 * @author shawf_lee
 * @date 2020/9/15 16:55
 *Content: 980.不同路径 III
        在二维网格 grid 上，有 4 种类型的方格：
        1 表示起始方格。且只有一个起始方格。
        2 表示结束方格，且只有一个结束方格。
        0 表示我们可以走过的空方格。
        -1 表示我们无法跨越的障碍。
        返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
        每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。

        示例 1：
        输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
        输出：2
        解释：我们有以下两条路径：
        1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
        2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

 */
public class UniquePaths {
    public static int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;
        //步骤初始化为1，因为终点（值为2）也算一步
        int stepCount = 1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //找到起点坐标
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                    continue;
                }
                //每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
                if(grid[i][j] == 0){
                    stepCount++;
                }
            }
        }
        return dfs(grid, startX, startY, stepCount);
    }
    public static int dfs(int[][] grid, int startX, int startY, int stepCount){
        int res = 0;
        if(startX < 0 || startX >= grid.length
                || startY < 0 || startY >= grid[0].length
                || grid[startX][startY] == -1){
            return res;
        }
        if(grid[startX][startY] == 2){
            //步数为0才算通过有且只通过一次每一个无障碍方格
            return stepCount == 0 ? 1 : 0;
        }
        //走过的置为-1
        grid[startX][startY] = -1;
        res += dfs(grid, startX - 1, startY, stepCount -1);
        res += dfs(grid, startX + 1, startY, stepCount -1);
        res += dfs(grid, startX, startY - 1, stepCount -1);
        res += dfs(grid, startX, startY + 1, stepCount -1);
        //回溯为0
        grid[startX][startY] = 0;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }
}
