
package Main;

public interface DataInterface {
    void saveGame(String fileName, GameInformation gameInformation);

    GameInformation loadGame(String fileName);
}