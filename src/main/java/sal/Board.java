package sal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    private List<Snake> snakeList;

    private List<Ladder> ladderList;

    private HashMap <Player, Integer> playerPosition;

    private int size;

    public Board(int size) {
        this.snakeList = new ArrayList<Snake>();
        this.ladderList = new ArrayList<Ladder>();
        this.playerPosition = new HashMap<Player,Integer>();
        this.size = size;
    }


    public List<Snake> getSnakeList() {
        return snakeList;
    }

    public void setSnakeList(List<Snake> snakeList) {
        this.snakeList = snakeList;
    }

    public List<Ladder> getLadderList() {
        return ladderList;
    }

    public void setLadderList(List<Ladder> ladderList) {
        this.ladderList = ladderList;
    }

    public HashMap<Player, Integer> getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(HashMap<Player, Integer> playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
