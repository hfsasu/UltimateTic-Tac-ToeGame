/*********************************************
 * Hafsa Alaparmak
 * CS2336.001
 * 11/28/2022
 **********************************************/
enum Mark{
    X("X"),
    O("O");
    
    private String mark;
    Mark(String mark){
        this.mark = mark;
    }
    public String getMark(){
        return mark;
    }
}