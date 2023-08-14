/*********************************************
 * Hafsa Alaparmak
 * CS2336.001
 * 11/28/2022
 **********************************************/

//To access an abstract class, it must be inherited from another class. HumanPlayer and ComputerPlayer are extening from APlayer
public abstract class APlayer {
    private String symbol;

    //constructor
    public APlayer(String symbol) {
        this.setName();
        this.setMark(symbol);
    }

    void setName() {
    }

    String getSymbol() {
        return symbol;
    }

    void setMark(String symbol) {
        this.symbol = symbol;
    }

    //These methods does not have a body,  The body is provided by the subclass (inherited from)
    public abstract int selectRowValue(int range);

    public abstract int selectColValue(int range);

    public abstract int selectBoardValue(int range);
}