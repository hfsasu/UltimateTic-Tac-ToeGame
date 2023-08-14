/*********************************************
 * Hafsa Alaparmak
 * CS2336.001
 * 11/28/2022
 **********************************************/
public class TTTGame {
    private APlayer[] players = new APlayer[2]; //create 2 players. players is object of APlayer
    private String[] marks = {"X", "O"}; //marks to place
    private final int gameRowSize = 3; //default row size
    private final int gameColSize = 3; //default col size
    private final int gameScoreToWin = 3;
    private int currentPlayerIndex = -1;
    private Board[] allBoards = new Board[gameRowSize*gameColSize]; //creates 9 boards
    private Board winnerBoard = new Board(gameRowSize, gameColSize, -1, -1); //an array that holds 3*3 only winner boards(big board)

    // constructor
    public TTTGame() {
        setPlayers();
        setBoard();
    }

    private void setBoard() {
        for(int i = 0; i<gameRowSize; i++){
            for(int j = 0; j<gameColSize; j++){
                this.allBoards[i*gameRowSize+j] = new Board(gameRowSize, gameColSize, i, j);
            }
        }
        print(); //when setting the initial boards, format it as print function from TTTGame file
    }

    private void setPlayers() {
        for (int i = 0; i < players.length; i++) {
            ComputerPlayer p = new ComputerPlayer(marks[i]);
            players[i] = p;
        }
    }

    public void setPlayers(APlayer player1, APlayer player2) {
        players[0] = player1;
        players[1] = player2;
    }

    private void switchPlayer() {
        if (this.currentPlayerIndex == -1 || this.currentPlayerIndex == 1) {
            this.currentPlayerIndex = 0;
        } else {
            this.currentPlayerIndex = 1;
        }
    }

    public void start() {
        switchPlayer(); //go back to the same player since start player index is -1
        int boardNumber = players[this.currentPlayerIndex].selectBoardValue(gameRowSize*gameColSize); //chose board
        switchPlayer(); //switch back to the same player

        do {
            switchPlayer(); //switch to next player

            //if the board is already full, keep asking for input
            while(allBoards[boardNumber].isFull()){
                boardNumber = players[this.currentPlayerIndex].selectBoardValue(gameRowSize*gameColSize);
            }

            int storeRow = players[this.currentPlayerIndex].selectRowValue(gameRowSize);
            int storeCol = players[this.currentPlayerIndex].selectColValue(gameColSize);

            //if the input is not valid, keep asking for it
            while (!allBoards[boardNumber].makeMove(players[this.currentPlayerIndex].getSymbol(), storeRow, storeCol)){
                 storeRow = players[this.currentPlayerIndex].selectRowValue(gameRowSize);
                 storeCol = players[this.currentPlayerIndex].selectColValue(gameColSize);
            }
            print();//print the boards

            //print all the winners
//            for(int i = 0; i < allBoards.length; i++){
//                boardGameOver(allBoards[i]);
//            }
            boardGameOver(allBoards[boardNumber]); //check if the game is over
            boardNumber = storeRow*gameRowSize + storeCol; //check what are the board numbers
        }
        while (!overallGameOver());
    }

    // when board is full or there is a winner
    private boolean boardGameOver(Board x) {
        if (isWinner(x)) {
            x.fill();
            //System.out.print("The Board winner is " + currentPlayerIndex + "winner is!\n" + this.marks[this.currentPlayerIndex]);
            System.out.print(this.marks[this.currentPlayerIndex] + " is a winner for a Board!\n\n");
            return true;
        } else if (x.isFull()) {
            System.out.println("That is a Tie!");
            return true;
        } else {
            return false; //if the game is not over, return false and continue playing
        }
    }

    private boolean overallGameOver() {
        if (overallWinner()) {
            System.out.println("\n***********GAME IS NOW OVER***********\n" + this.marks[this.currentPlayerIndex] + " is the overall winner of the Game!!!");
            return true;
        } else if (winnerBoard.isFull()) {
            System.out.println("Overall game is a Tie!!!!");
            return true;
        } else {
            return false; //if the game is not over, return false and continue playing
        }
    }

    //check which small boards are the winner
    private boolean isWinner(Board x) {
        if (checkRows(x) || checkCols(x) ||checkDiagLR(x) || checkDiagRL(x)) {
            int[] locations = x.findLocation();
            winnerBoard.makeMove(this.marks[this.currentPlayerIndex], locations[0], locations[1]);
            return true;
        }
        else{
            return false;
        }
    }

    //check all the diagonals, rows, and cols to determine if there is a winner on boards
    private boolean overallWinner() {
        return checkRows(this.winnerBoard) || checkCols(this.winnerBoard) || checkDiagLR(this.winnerBoard) || checkDiagRL(this.winnerBoard);
    }

    private boolean checkCols(Board x) {
        for (int col = 0; col < this.gameColSize; col++) {
            if (checkCol(x, col)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(Board x, int col) {
        int count = 0;
        for (int row = 0; row < this.gameRowSize; row++) {
            if (x.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
                count++;
            }
        }
        return count == this.gameScoreToWin;
    }

    private boolean checkRows(Board x) {
        for (int row = 0; row < this.gameRowSize; row++) {
            if (checkRow(x, row)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRow(Board x, int row) {
        int count = 0;
        for (int col = 0; col < this.gameColSize; col++) {
            if (x.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
                count++;
            }
            if (count == this.gameScoreToWin) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagLR(Board x) {
        int count = 0;
        for (int row = 0, col = this.gameRowSize - 1; row < this.gameColSize && col >= 0; row++, col--) {
            if (x.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
                count++;
            }
            if (count == this.gameScoreToWin) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagRL(Board x) {
        int count = 0;
        for (int col = 0, row = 0; col < this.gameColSize && row < this.gameRowSize; col++, row++) {
            if (x.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
                count++;
            }
            if (count == this.gameScoreToWin) {
                return true;
            }
        }
        return false;
    }

    void print(){
        int colNum = 0;
        for(int i = 0; i < 3; i++){ //set of 3
            for(int j = 0; j < 3; j++){ //rows
                for(int k = 0; k < 3; k++){ //cols
                    int boardNum = k + colNum; //find which board it is
                    Board x = (allBoards[i*3 + k]);
                    System.out.print("Board#" + boardNum
                            + " | " + x.getMark(j, 0 )
                            + " | " + x.getMark(j, 1 )
                            + " | " + x.getMark(j, 2 )
                            + " |   " );
                }
                System.out.println("");//new line
            }
            colNum+=3;//go to next row of boards
        }
        System.out.println("");//new line
    }

}
