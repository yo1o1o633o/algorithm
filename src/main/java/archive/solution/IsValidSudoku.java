package archive.solution;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * */
public class IsValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudokuWithBit(board));
    }

    /**
     * 采用位运算方式
     * 行列块各一个数组
     * rows[i] >> n & 1
     *
     * 比如，i = 0， n = 5，判断第0行是否填了数字5？
     *
     * rows[0] >> 5 & 1，将row[0] 向右移5位，那么row[0]的二进制形式的第5位处于最低位，此时再跟1进行与操作，就可以获得最低位的数字，也就是原来处于row[0]的二进制形式的第5位的数字。
     *
     * 用每一位记录是否被访问过
     * 如1010010000
     * 第4,7,9为1
     * 将1010010000右移3位得到1010011000，与1进行与运算，结果为0，未访问过1010011000
     * 将1左移位3位得到1000，异或后得到1010011000
     * */
    private static boolean isValidSudokuWithBit(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }
                int n = num - '0';
                int boxIndex = (i / 3) * 3 + j / 3;
                // 分别判断行列块的n数字，看是否已填，如果等于1，代表已填
                if ((rows[i] >> n & 1) == 1 || (columns[j] >> n & 1) == 1 || (boxes[boxIndex] >> n & 1) == 1) {
                    return false;
                }
                // 将n数字加入到位运算数组
                rows[i] = rows[i] | (1 << n);
                columns[j] = columns[j] | (1 << n);
                boxes[boxIndex] = boxes[boxIndex] | (1 << n);
            }
        }
        return true;
    }

    /**
     * 哈希表
     * 利用双层数组
     * 一次遍历，分别记录一个位置， 在行， 列， 块的出现
     * 每当下次遍历时， 发现在行列块中任意出现， 就代表数独是不合法的
     * */
    private static boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boxes = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                // 此处如果换成不等于,leetCode性能减半...
                if (num == '.') {
                    continue;
                }
                int n = num - '1';
                if (rows[i][n] != 0) {
                    return false;
                }
                if (columns[j][n] != 0) {
                    return false;
                }
                int boxIndex = (i / 3) * 3 + j / 3;
                if (boxes[boxIndex][n] != 0) {
                    return false;
                }
                rows[i][n] = 1;
                columns[j][n] = 1;
                boxes[boxIndex][n] = 1;
            }
        }
        return true;
    }
}
