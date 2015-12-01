package Interfaces;

import DataStructures.BoardChange;
import DataStructures.Player;
import DataStructures.Room;
import DataStructures.Scores;

import java.rmi.Remote;
import java.util.List;
import java.util.UUID;

public interface IClient extends Remote {
    void setPlayer(Player player);
    void updateRooms(List<Room> rooms);
    void updateBoard(BoardChange boardChange);
    void startGame();
    void setRoom(Room room);
    void setPlayerColor(Player.Color color);
    void gameOver();
    public void error(String errorMessage);
}
