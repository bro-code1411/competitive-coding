import java.util.*;

public class Dictionary {

    private HashMap<String, List<String>> dic = new HashMap<>();

    public Dictionary() {
    }

    public boolean find(String find, int swap) {
        String key = generateKey(find);
        if (this.dic.containsKey(key)) {
            Optional<String> result = dic.get(key).stream().filter(s -> swap >= numberOfSwap(s, find)).findFirst();
            if (result.isPresent()) {
                return true;
            }
        }
        return false;
    }

    private int numberOfSwap(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
        }
        return count / 2;
    }


    public void enterKey(String a) {
        String key = generateKey(a);
        if (this.dic.containsKey(key)) {
            List list = dic.get(key);
            list.add(a);
            dic.put(key, list);
        } else {
            List newList = new ArrayList<>();
            newList.add(a);
            this.dic.put(key, newList);
        }

    }

    private String generateKey(String a) {
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < a.length(); i++) {
            int index = a.charAt(i) - 'a';
            arr[index] = arr[index] + 1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                builder.append((char) ('a' + i));
                builder.append(arr[i]);
            }
        }
        return builder.toString();
    }

}
