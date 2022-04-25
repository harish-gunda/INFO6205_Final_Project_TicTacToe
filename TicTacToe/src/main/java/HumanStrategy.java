public class HumanStrategy {
    public static void main(String[] args){

    }

    private boolean checkWin(char[] board,char player,int row, int col){
        //todo
    }

    private static int nextOptimalStep(board,player){
        //rule 1
        for(int i=0;i<9;i++){
            if (board[i]=='0' and checkWin(board,player,i%3,i/3)){
                return i;
            }
        }
        // rule 2
        char opposition = player=='1'?'2':'1';
        for(int i=0;i<9;i++){
            if (board[i]=='0' and checkWin(board,opposition,i%3,i/3)){
                return i;
            }
        }



    }
}
