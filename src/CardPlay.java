import java.util.ArrayList;
import java.util.List;

/**
 * @author ewanggu
 * @since 2015
 *
 */
public class CardPlay {
    public static void cardPlay(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        play(list, 0);
    }

    private static void play(final List<String> list, final int begin) {
        if (begin < 0 || begin > list.size()) {
            return;
        }
        if (begin == list.size()) {
            System.out.println(list.toString());
        } else {
            for (int j = begin; j < list.size(); j++) {
                String sBegin = list.get(j);
                list.set(j, list.get(begin));
                list.set(begin, sBegin);
                play(list, begin + 1);
                sBegin = list.get(j);
                list.set(j, list.get(begin));
                list.set(begin, sBegin);
            }
        }
    }

    public static void main(final String args[]) {
        final List<String> list = new ArrayList<String>();
        list.add("2");
        list.add("8");
        list.add("5");
        list.add("10");
        list.add("J");
        list.add("Q");
        list.add("K");
        list.add("A");
        list.add("$");
        list.add("$$");
        cardPlay(list);
    }

}
