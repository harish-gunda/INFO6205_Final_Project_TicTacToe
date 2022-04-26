import java.util.*;

public class MenaceStrategy {

    

    private int INITIAL = 100;
    private Map<String, List<Integer>> beads = new HashMap<>();
    private List<String> roundString = new ArrayList<>();
    private List<Integer> roundPositions = new ArrayList<>();

    public void updateBeads(int result, int a, int b, int d) {
        if (result == 0) {int l = roundPositions.size();
            for (int i=0; i<l; i++) {
                int j = 0;
                while (j<d) {
                    beads.get(roundString.get(0)).add(roundPositions.get(0));
                    j++;
                }
                roundPositions.remove(0);
                roundString.remove(0);
            }
        } else if (result == 1) {
            int l = roundPositions.size();
            for (int i=0; i<l; i++) {
                int j = 0;
                while (j<b) {
                    beads.get(roundString.get(0)).add(roundPositions.get(0));
                    j++;
                }
                roundPositions.remove(0);
                roundString.remove(0);
            }
        } else {
            int l = roundPositions.size();
            for (int i=0; i<l; i++) {
                int j = 0;
                while (j<a) {
                    beads.get(roundString.get(0)).add(roundPositions.get(0));
                    j++;
                }
                roundPositions.remove(0);
                roundString.remove(0);
            }
        }
    }

    public int turn(String s) {
        Random rand = new Random();
        if (beads.containsKey(s)) {
            if (beads.get(s).size()<=1) {
                return beads.get(s).get(0);
            }
            int zeros = beads.get(s).remove(rand.nextInt(beads.get(s).size()));
            roundString.add(s);
            roundPositions.add(zeros);
            return zeros;
        }
        else {
            createKeyValue(s);
            int zeros = beads.get(s).remove(rand.nextInt(beads.get(s).size()));
            roundString.add(s);
            roundPositions.add(zeros);
            return zeros;
        }
    }

    public void createKeyValue(String s) {
        List<Integer> zeros = new ArrayList<>();
        List<Integer> positions = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='0') {
                zeros.add(i);
            }
        }
        int length = zeros.size();
        if (length==0) {
            for (int i=0; i<INITIAL; i++) {
                positions.add(-1);
            }
            beads.put(s, positions);
            return;
        }
        for (int i=0; i<INITIAL; i++) {
            int j=0;
            while (j<length) {
                positions.add(zeros.get(j));
                j++;
            }
        }
        beads.put(s, positions);
    }




}
