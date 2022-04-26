import java.util.*;

public class Runner {

    public static void main(String[] args) {
        MenaceStrategy m = new MenaceStrategy();
        HumanStrategy h = new HumanStrategy();
        List<Integer> mlist = new ArrayList<>();
        List<Integer> hlist = new ArrayList<>();
        List<Integer> draw = new ArrayList<>();
        int mc = 0;
        int hc = 0;
        int dc = 0;
        int alpha = 3;
        int beta = 1;
        int delta = 0;
        int j;
        for (int i = 0; i<10000000; i++) {
            Game r = new Game(m, h);
            j = r.start();
            if (j==0) {
                dc++;
                draw.add(i);
            } else if (j==1) {
                mc++;
                mlist.add(i);
            } else  {
                hc++;
                hlist.add(i);
            }
            m.updateBeads(j, alpha, beta, delta);
        }
        System.out.println("M: "+mc+" H: "+hc+" D: "+dc);

//        System.out.println(mlist);
//        System.out.println(hlist);
//        System.out.println(draw);
    }

}


