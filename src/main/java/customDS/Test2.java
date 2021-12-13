package customDS;

import java.util.*;
// DS to insert delete get random in O1 without duplicates
public class Test2{

    ArrayList<Integer> a;

    Map<Integer, Integer> valueToIndexMap = new HashMap<>();

    void add(int x){
        if(valueToIndexMap.containsKey(x)){
            return;
        }
        a.add(x);
        valueToIndexMap.put(x,a.size()-1);
    }

    void remove(int x){

        if(!valueToIndexMap.containsKey(x)){
            return;
        }

        int index = valueToIndexMap.get(x);
        valueToIndexMap.remove(x);
        int s = a.size();
        int last = a.get(s-1);
        Collections.swap(a,index,s-1);
        a.remove(s-1);
        valueToIndexMap.put(last,index);
    }

    int getRandom(){
        Random r = new Random();
        int i = r.nextInt(a.size()-1);
        return a.get(i);
    }
    int get(int x){
        return valueToIndexMap.get(x);
    }
}
