import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlexibleString {

    public static class Pair implements Comparable<Pair>{
        char from;
        char to;

        public Pair(char from, char to) {
            super();
            this.from = from;
            this.to = to;
        }
        @Override
        public int compareTo(Pair o) {

            if(this.to <= o.from)
                return -1;

            return 1;
        }
        @Override
        public String toString() {
            return "Pair [from=" + from + ", to=" + to + "]";
        }



    }

    public static boolean isFlexible(String s, List<Pair> pairs) {

        Collections.sort(pairs);

        for(Pair p : pairs) {

            s = s.replace(p.from, p.to);

        }

        for(int i = 0; i < s.length() -1; i++)
            if(s.charAt(i) != s.charAt(i+1))
                return false;

        return true;

    }


    public static void main(String[] args) {

        test1();
        test2();

    }

    private static void test1() {
        String s = "abccc";
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair('b', 'a'));
        pairs.add(new Pair('c', 'a'));

        System.out.println(isFlexible(s, pairs));

    }

    private static void test2() {
        String s = "abcdc";
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair('b', 'c'));
        pairs.add(new Pair('a', 'd'));
        System.out.println(isFlexible(s, pairs));

    }

}