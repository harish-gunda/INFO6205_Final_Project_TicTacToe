import java.util.*;

public class Runner {

    public static void main(String[] args) {


        int beta = 10;
        int gamma = 5;
        int delta = 1;
        int gameResult;
        int menaceWins = 0;
        int humanWins = 0;
        int draws = 0;
        int NUMBER_OF_TRAINS = 100000;
        List<Integer> m = new ArrayList<>();
        List<Integer> h = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        MenaceStrategy menaceStrategy = new MenaceStrategy();
        HumanStrategy humanStrategy = new HumanStrategy();
        for (int i = 0; i<NUMBER_OF_TRAINS; i++) {
            Game game = new Game(menaceStrategy, humanStrategy);
            gameResult = game.run();
//            game.peekCurrentState();
            if (gameResult==0) {
                d.add(i);
                draws++;
            } else if (gameResult==1) {
                m.add(i);
                menaceWins++;
            } else  {
                h.add(i);
                humanWins++;
            }
            menaceStrategy.updateBeads(gameResult, beta, gamma, delta);
        }
        System.out.println("Menacewins: "+menaceWins+" || Humanwins: "+humanWins+" || Draws: "+draws);
        System.out.println(Arrays.toString(m.toArray()));
        System.out.println(Arrays.toString(h.toArray()));
        System.out.println(Arrays.toString(d.toArray()));

    }

}


