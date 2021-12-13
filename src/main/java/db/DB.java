package db;

import javafx.util.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DB {

    public static final int NO_OF_FILE= 10;


    static Map<Integer, Pair<Integer,Integer>> keyToFileOffsetMap = new HashMap<>();

    static Map<Integer,Integer> fileToOffestMap = new HashMap<>();

    public static void put(int key, int value) throws IOException {
        Integer file = fileToOffestMap.get(key%NO_OF_FILE);
        FileWriter writer = new FileWriter(file + ".txt");
        writer.write(value);
        writer.close();
        Integer offset = fileToOffestMap.get(file);
        if(offset ==null){
            offset =0;
        }
        fileToOffestMap.put(file, offset++);
        keyToFileOffsetMap.put(key,new Pair<>(file,offset));
    }

    public static Integer get(int key) throws IOException {
        String value= null;
        try {
            Stream<String> lines = Files.lines(Paths.get(keyToFileOffsetMap.get(key).getKey() + ".txt"));
            value = lines.skip(keyToFileOffsetMap.get(key).getValue()).findFirst().get();
        } catch (IOException e) {
            throw new IOException("Couldnt read file",e);
        }
        if(value != null){
            return Integer.parseInt(value);
        }
        return null;
    }


    public static int main(String[] args) throws IOException {
        put(1,2);
        put(11,3);
        System.out.println(get(1));
        return 0;

    }
}
