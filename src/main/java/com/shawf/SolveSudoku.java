package com.shawf;

import java.util.Arrays;

/**
 * @author shawf_lee
 * @date 2020/9/15 9:58
 * Content: 37. 解数独
 */
public class SolveSudoku {
    private static boolean[][] row = new boolean[9][9];
    private static boolean[][] col = new boolean[9][9];
    private static boolean[][][] blo = new boolean[3][3][9];

    public static void solveSudoku(char[][] board) {
        //true表示这个数（这行，这列，这格）用过了
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = board[i][j] - '0';
                if (num >= 1 && num <= 9) {
                    row[i][num - 1] = true;
                    col[j][num - 1] = true;
                    blo[i / 3][j / 3][num - 1] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    public static boolean dfs(char[][] board, int x, int y) {
        //一行结束到下一行
        if (y == 9) {
            y = 0;
            x++;
            if (x == 9)  {
                return true;
            }
        }
        if (board[x][y] == '.') {
            for (int num = 0; num < 9; num++) {
                if (!row[x][num] && !col[y][num] && !blo[x / 3][y / 3][num]) {
                    row[x][num] = true;
                    col[y][num] = true;
                    blo[x / 3][y / 3][num] = true;
                    board[x][y] = (char) (num + '1');
                    //继续下一个格子，可行返回true
                    if (dfs(board, x, y + 1)) {
                        return true;
                    } else {//不可行回滚尝试一下一个数
                        board[x][y] = '.';
                        row[x][num] = false;
                        col[y][num] = false;
                        blo[x / 3][y / 3][num] = false;
                    }
                }
            }
        } else {//是数组则下一个格子
            return dfs(board, x, y + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char [][]board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'} };
        solveSudoku(board);
        for (char[] item : board) {
            System.out.println(Arrays.toString(item));
        }
    }
}
