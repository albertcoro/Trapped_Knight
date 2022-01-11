public class Position {
    int position_x;
    int position_y;
    int value;
    boolean marked;

    public Position(int x, int y, int val){
        position_x = x;
        position_y = y;
        value = val;
        marked = false;
    }

    public int getX(){
        return position_x;
    }

    public void setX(int x){
        position_x = x;
    }

    public int getY(){
        return position_y;
    }

    public void setY(int y){
        position_y = y;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int val){
        value = val;
    }

    public void setMarked(){ marked = true; }

    public boolean getMarked(){ return marked; }
}
