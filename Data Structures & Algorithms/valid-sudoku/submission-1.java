class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> vertical = new HashSet<>();
        Set<Character> horizontal = new HashSet<>();
        Set<Character> subBox = new HashSet<>();
        int j = 0;
        while (j < 9) {
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c != '.' && vertical.contains(c)) {
                    return false;
                } else {
                    vertical.add(c);
                }
            }
            vertical.clear();
            j++;
        }
        j = 0;
        while (j < 9) {
            for (int i = 0; i < 9; i++) {
                char c = board[j][i];
                if (c != '.' && horizontal.contains(c)) {
                    return false;
                } else {
                    horizontal.add(c);
                }
            }
            horizontal.clear();
            j++;
        }
        int sj = 0;
        int si = 0;
        int vend = 2;
        int hend = 2;
        while (sj <= 8) {
            while (si <= 8) {
                while (sj <= vend) {
                    while (si <= hend) {
                        if (board[si][sj] != '.' && subBox.contains(board[si][sj])) {
                            return false;
                        } else {
                            subBox.add(board[si][sj]);
                            si++;
                        }
                    }
                    si = si - 3;
                    sj++;
                }
                subBox.clear();
                sj = sj - 3;
                si = si + 3;
                hend = hend + 3;
            }
            sj = sj + 3;
            vend = vend + 3;
            si = 0;
            hend = 2;
        }
        return true;
    }
}
