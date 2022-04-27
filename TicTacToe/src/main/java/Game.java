public class Game {

    private int[][] board;
    public MenaceStrategy menaceStrategy;
    public HumanStrategy humanStrategy;

    public Game(MenaceStrategy menaceStrategy, HumanStrategy humanStrategy) {
        board = new int[3][3];
        this.menaceStrategy = menaceStrategy;
        this.humanStrategy = humanStrategy;
    }

    public String convert2dboardToString(int[][] board) {
        String state = "";
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                state += Integer.toString(board[i][j]);
            }
        }
        return state;
    }

    public void peekCurrentState() {
        for (int i=0; i<3; i++) {
            System.out.println(board[i][0]+" || "+board[i][1]+" || "+board[i][2]);
            System.out.println("______________");
        }
        System.out.println("######################");
    }


    public int checkwin(int pos, int player) {
        if (pos == -1) {
            return 0;
        }
        int i = pos/3;
        int j = pos%3;

        if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
            return player;
        }
        if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
            return player;
        }

        if (Math.abs(i-j)==2 || i==j) {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1]==player) {
                return player;
            }
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1]==player) {
                return player;
            }
        }
        return 0;
    }

    public int run() {
        peekCurrentState();
        int player = 1;
        int position = -1;
        String s = convert2dboardToString(board);
        while (checkwin(position, player)==0) {
            if (player == 1) {
                position = menaceStrategy.nextOptimalStep(s);
                if (position==-1) {
                    return 0;
                }
                board[position / 3][position % 3] = 1;

                s = convert2dboardToString(board);
                if(checkwin(position,player)!=0){
                    return checkwin(position,player);
                }
                player = 2;
            } else {
                position = humanStrategy.nextOptimalStep(s,"2");
                if (position==-1) {
                    return 0;
                }
                board[position / 3][position % 3] = 2;

                s = convert2dboardToString(board);
                if(checkwin(position,player)!=0){
                    return checkwin(position,player);
                }
                player = 1;
            }
            peekCurrentState();

        }
        return checkwin(position, player);
    }

}
