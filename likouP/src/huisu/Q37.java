package huisu;

/**
 * ��������ֻ��Ψһ�Ľ⡣
 */
public class Q37 {
    int n ;
    public void solveSudoku(char[][] board) {
        n = board.length;
        help(0,0,board);
    }
    boolean help(int row,int col,char[][] board){
        if(row == n){
            return true;
        }
        if(col == n){
            return  help(row + 1,  0 ,board);
        }
        if(board[row][col] != '.') {
            help(row,col + 1,board);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            // ��ѡ��
            if (!isVal(board,row,col,ch)) continue;
            board[row][col] = ch;
            help(row ,col + 1,board);
            board[row][col] = '.';
        }
        return false;
    }
    boolean isVal(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // �ж����Ƿ�����ظ�
            if (board[r][i] == n) return false;
            // �ж����Ƿ�����ظ�
            if (board[i][c] == n) return false;
            // �ж� 3 x 3 �����Ƿ�����ظ�
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
                return false;
        }
        return true;
    }
}
