package algo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DisjointSet {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String testS = s.nextLine();
        int test = Integer.parseInt(testS);
        boolean [] ans = new boolean[test];
        for(int x =0 ; x <test;x++){
            String s1temp = s.nextLine();
            String s1= s1temp.trim();
            String a = s.nextLine();
            char[][] ss=new char[Integer.parseInt(a)][2];
            for(int i=0; i < Integer.parseInt(a) ; i++){
                String temp = s.nextLine();
                String[]strings = temp.split(" ");
                for(int j=0;j<2;j++){
                    ss[i][j] =strings[j].trim().charAt(0);
                }
            }
            ans[x]=isFlexibleString(s1, ss);
            System.out.println("--"+ss[0][0]+ss[0][1]+ss[1][0]+ss[1][1]);
        }
        for(int j =0 ; j <test;j++) {
            System.out.println(ans[j]?"YES":"NO");
        }
    }
    private static boolean isFlexibleString(String s, char[][] ops) {
        int[] parent = new int[26];

        for (int i = 0; i < 26; i++) parent[i] = i;

        for (char[] op : ops) {
            int p = op[1] - 'a';
            int c = op[0] - 'a';
            int parentP = getParent(p, parent);
            parent[c] = parentP;
        }
        Set<Integer> disParents = new HashSet<>();
        for (char ch : s.toCharArray()) {
            int chIdx = ch - 'a';
            int p = getParent(chIdx, parent);
            disParents.add(p);

            if (disParents.size() > 1) return false;
        }
        return true;
    }

    private static int getParent(int i, int[] pArray) {
        if (pArray[i] != i) pArray[i] = getParent(pArray[i], pArray);
        return pArray[i];
    }
}

