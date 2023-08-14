/*********************************************
 * Hafsa Alaparmak
 * CS2336.001
 * 11/28/2022
 **********************************************/
public class Board{ // package visibility / default
    private int boardRowSize;
    private int boardColSize;
    private Box[] boxes;
    private int roww;
    private int coll;

    // custom constructor
    Board(int rowSize, int colSize, int roww, int coll){
        this.setName();
        this.setSize(rowSize, colSize);
        this.roww = roww;
        this.coll = coll;
    }

    //set the small boards size to 3
    private void setSize(int row, int col)  {
        // check if board dimensions are valid
        if (row < 3 || col < 3) {
            System.out.println("min board size is 3");

        }
        else{
            this.boardColSize = col;
            this.boardRowSize = row;
            init();
        }
    }

    public void init() {
        boxes = new Box[boardColSize * boardRowSize];
        for (int i = 0; i < boxes.length; i++)  {
            Box b = new Box(("" + i));
            boxes[i] = b;
        }
    }

    // this method will set a placeholder on the desired box
    boolean makeMove(String mark, int row, int col) {
        return boxes[row * this.boardRowSize + col].setPlaceHolder(mark);
    }

    // this method determines if the boxes are full or empty
    public boolean isFull() {
        for(Box b : boxes) {
            if (b.isAvailable()) {
                return false;
            }
        }
        return true;
    }

    // getters and setters
    public String getMark(int row, int col) {
        return boxes[row * this.boardRowSize + col].getPlaceHolder();
    }

    void setName(){
    }

    //find where the rows and coll
    int[] findLocation(){
        return new int[]{ //inline
                roww, coll
        };
    }

    //Go from 0 to length of the boxes and wherever there is a number, replace is with star
    void fill(){
        for (Box box : boxes) {
            if (Character.isDigit(box.getPlaceHolder().charAt(0))) {
                box.setPlaceHolder("*");
            }
        }
    }
}


