/*********************************************
 * Hafsa Alaparmak
 * CS2336.001
 * 11/28/2022
 **********************************************/
public class Box{
    private String placeHolder;

    Box(String x){
        placeHolder = x;
    }

    String getPlaceHolder(){
        return placeHolder;
    }

    boolean setPlaceHolder(String placeHolder){
        if(isAvailable()) {
            this.placeHolder = placeHolder;
            return true;
        }
        return false;
    }
    
    boolean isAvailable(){
        return Character.isDigit(placeHolder.charAt(0));
    }

}