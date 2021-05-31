package sal;

import java.util.*;

public class SnakeAndLadderServiceImpl extends SnakeAndLadderService {

    private static final int DEFAULT_BOARD_SIZE = 100;

    private Board board;
    private Queue<Player> playerList;

    private boolean hasGameEnded = false;

    public SnakeAndLadderServiceImpl(){
        this.playerList= new LinkedList<Player>();
        this.board = new Board(DEFAULT_BOARD_SIZE);
    }


    public SnakeAndLadderServiceImpl(int boardSize){
        this.playerList= new LinkedList<Player>();
        this.board = new Board(boardSize);
    }

    public void registerPlayer(Player player) {
        this.playerList.add(player);
    }

    public void registerPlayers(List<Player> players) {
        this.playerList.addAll(players);
    }
    // addSnakes
    // addLadders
    @Override
    public Integer updatePosition() {
        if(this.hasGameEnded){
            return null;
        }
        Player currentPlayer = playerList.poll();

        int newPostion = calculateNextPostion(currentPlayer);
        board.getPlayerPosition().put(currentPlayer,newPostion);
        if(hasPlayerWon(newPostion)){
            System.out.println(currentPlayer.getName()+" has won the game.");
            this.hasGameEnded = true;
        }
        playerList.add(currentPlayer);
        return  newPostion;
    }

    private boolean hasPlayerWon(Integer newPosition){
        return newPosition == this.board.getSize();
    }

    private int calculateNextPostion(Player currentPlayer){
        int prevPostion = board.getPlayerPosition().get(currentPlayer);
        int newPosition = prevPostion + DiceService.roll();
        Optional<Ladder> ladderOptional =  board.getLadderList().stream().filter(ladder -> ladder.getStart() == newPosition).findFirst();
        Optional<Snake> snakeOptional=  board.getLadderList().stream().filter(snake -> snake.getStart() == newPosition).findFirst();
        if(ladderOptional.isPresent()){
            newPosition = ladderOptional.get().getEnd();
        }
        else if(snakeOptional.isPresent()){
            newPosition = ladderOptional.get().getEnd();
        }
        return newPosition;
    }

    @Override
    public Map<Player, Integer> currentPositions() {
        return null;
    }
}
