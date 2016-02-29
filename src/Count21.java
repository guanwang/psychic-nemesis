import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ewanggu
 * @since 2015
 *
 */
public class Count21 {

    private static final int COUNT = 21;

    public static void printCount21(final List<String> list) {
        final Set<TrippleElement> set = count21(list);
        for (final TrippleElement ele : set) {
            if (ele.isValid())
                System.out.println(ele.toString());
        }
    }

    public static int getNum(final String cardStr) {
        switch (cardStr.charAt(0)) {
        case '2':
            return 2;
        case '3':
            return 3;
        case '4':
            return 4;
        case '5':
            return 5;
        case '6':
            return 6;
        case '7':
            return 7;
        case '8':
            return 8;
        case '9':
            return 9;
        case '1':
            return 10;
        case 'J':
            return 11;
        case 'Q':
            return 12;
        case 'K':
            return 13;
        case 'A':
            return 1;
        default:
            return -1;
        }
    }

    public static String getStr(final short cardInt) {
        switch (cardInt) {
        case 2:
            return "2";
        case 3:
            return "3";
        case 4:
            return "4";
        case 5:
            return "5";
        case 6:
            return "6";
        case 7:
            return "7";
        case 8:
            return "8";
        case 9:
            return "9";
        case 10:
            return "10";
        case 11:
            return "J";
        case 12:
            return "Q";
        case 13:
            return "K";
        case 1:
            return "A";
        default:
            return "";
        }
    }

    private static Set<TrippleElement> count21(final List<String> list) {
        final Set<TrippleElement> set = new HashSet<TrippleElement>();
        final List<Integer> newList = new ArrayList<Integer>();
        //remove $$
        for (final String card : list) {
            if (getNum(card) != -1) {
                newList.add(getNum(card));
            }
        }
        Collections.sort(newList);
        final int size = newList.size();
        for (int i = 0; i < size; i++) {
            int j = i + 1;
            int k = size - 1;
            while (j < k) {
                final int sum = newList.get(i) + newList.get(j) + newList.get(k);
                if (sum < COUNT) {
                    j++;
                } else if (sum > COUNT) {
                    k--;
                } else {
                    set.add(new TrippleElement(newList.get(i), newList.get(j), newList.get(k)));
                }
            }
        }
        return set;
    }

    public static class TrippleElement {
        private final int a;

        private final int b;

        private final int c;

        public TrippleElement(final int a, final int b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public boolean isValid() {
            return a != b && b != c;
        }

        public boolean equals(final TrippleElement other) {
            return ((this.a == other.a && this.b == other.b && this.c == other.c));

        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Count21 [first card=" + getStr((short) a) + ", second card=" + getStr((short) b) + ", third card="
                    + getStr((short) c) + "]";
        }

    }

}
