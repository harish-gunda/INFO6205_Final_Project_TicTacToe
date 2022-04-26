public class HumanStrategy {
    public static void main(String[] args){
        System.out.println("Hello");
    }

    private static boolean checkWin(String board,String player,int row, int col){
        //todo
        return true;
    }

    private static int nextOptimalStep(String board,String player) {
        //rule 1
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == '0' && checkWin(board, player, i % 3, i / 3)) {
                return i;
            }
        }

        // rule 2
        String opposition = player == "1" ? "2" : "1";
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == '0' && checkWin(board, opposition, i / 3, i % 3)) {
                return i;
            }
        }


        //rule 3
        String check;
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == '0') {
                int row = i / 3;
                int col = i % 3;
                check = "";
                count = 0;
                for (int r1 = 0; r1 < 3; r1++) {
                    if (r1 != row) {
                        check += board.charAt(r1 * 3 + col);
                    }
                }
                if (check == '0' + player || check == player + '0') {
                    count += 1;
                }
                check = "";
                for (int c1 = 0; c1 < 3; c1++) {
                    if (c1 != col) {
                        check += board.charAt(row * 3 + c1);
                    }
                }
                if (check == '0' + player || check == player + '0') {
                    count += 1;
                }
                check = "";
                if (row == col) {
                    int r1 = 0;
                    int c1 = 0;
                    while (r1 < 3) {
                        if (r1 == row) {
                            continue;
                        }
                        check += board.charAt(r1 * 3 + c1);
                        r1++;
                        c1++;
                    }
                }
                if (check == '0' + player || check == player + '0') {
                    count += 1;
                }
                check = "";
                if (row == col || java.lang.Math.abs(row - col) == 2) {
                    int r1 = 0;
                    int c1 = 3;
                    while (r1 < 3) {
                        if (r1 == row) {
                            continue;
                        }
                        check += board.charAt(r1 * 3 + c1);
                        r1++;
                        c1--;
                    }
                }
                if (check == '0' + player || check == player + '0') {
                    count += 1;
                }
                if (count >= 2) {
                    return i;
                }
            }
        }

        //rule 4
        String temp = player;
        player = opposition;
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == '0') {
                int row = i / 3;
                int col = i % 3;
                check = "";
                count = 0;
                for (int r1 = 0; r1 < 3; r1++) {
                    if (r1 != row) {
                        check += board.charAt(r1 * 3 + col);
                    }
                }
                if (check == '0' + player || check == player + '0') {
                    count += 1;
                }
                check = "";
                for (int c1 = 0; c1 < 3; c1++) {
                    if (c1 != col) {
                        check += board.charAt(row * 3 + c1);
                    }
                }
                if (check == '0' + player || check == player + '0') {
                    count += 1;
                }
                check = "";
                if (row == col) {
                    int r1 = 0;
                    int c1 = 0;
                    while (r1 < 3) {
                        if (r1 == row) {
                            continue;
                        }
                        check += board.charAt(r1 * 3 + c1);
                        r1++;
                        c1++;
                    }
                }
                if (check == '0' + player || check == player + '0') {
                    count += 1;
                }
                check = "";
                if (row == col || java.lang.Math.abs(row - col) == 2) {
                    int r1 = 0;
                    int c1 = 3;
                    while (r1 < 3) {
                        if (r1 == row) {
                            continue;
                        }
                        check += board.charAt(r1 * 3 + c1);
                        r1++;
                        c1--;
                    }
                }
                if (check == '0' + player || check == player + '0') {
                    count += 1;
                }
                if (count >= 2) {
                    return i;
                }
            }
        }

        player = temp;
        return 0;
    }

}
