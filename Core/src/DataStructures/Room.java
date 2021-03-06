package DataStructures;

import java.io.Serializable;
import java.util.UUID;

public class Room implements Serializable {
    private String name;
    private UUID id;
    private Board board;
    private Player bluePlayer;
    private Player redPlayer;

    public Room(RoomInfo roomInfo) {
        name = roomInfo.getName();
        board = new Board(roomInfo.getBoardSize());
        bluePlayer = roomInfo.getBluePlayer();
        redPlayer = roomInfo.getRedPlayer();
        id = roomInfo.getId();
    }

    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public int getSize() {
        return board.getSize();
    }

    public Player getBluePlayer() {
        return bluePlayer;
    }

    public Player getRedPlayer() {
        return redPlayer;
    }

    public void unbindPlayer(Player player) {
        if (bluePlayer == player) {
            bluePlayer = null;
        } else if (redPlayer == player) {
            redPlayer = null;
        }
    }

    public void setBluePlayer(Player bluePlayer) {
        this.bluePlayer = bluePlayer;
    }

    public void setRedPlayer(Player redPlayer) {
        this.redPlayer = redPlayer;
    }

    public Scores getScores() {
        return board.calcScores();
    }

    public boolean isFree() {
        return bluePlayer == null || redPlayer == null;
    }
}
