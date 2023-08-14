/*********************************************
 * Hafsa Alaparmak
 * CS2336.001
 * 11/28/2022
 **********************************************/
class ComputerPlayer extends APlayer {

    // constructor
    ComputerPlayer(String symbol) {
        super(symbol);
    }

    //make a random number
    private int randomNumber(int range) {
        return (int)(Math.random() * range);
    }

    public int selectRowValue(int range) {
        return randomNumber(range);
    }

    public int selectColValue(int range) {
        return randomNumber(range);
    }

    public int selectBoardValue(int range) {
        return randomNumber(range);
    }
}
