public class main {

    public static void main(String[] args){
        int cols = 10;
        int rows = 10;
        int steps = 0;
        Position current = new Position(cols/2,(rows-1)/2,1);
        Position[][] board = new Position[cols][rows];
        fillBoard(board,cols,rows);
        current.setMarked();
        board[current.getX()][current.getY()] = current;
        System.out.print("Starting: ");
        while(true){
            steps++;
            current = nextMoveBishop(board,cols,rows,current);
            if(current==null){
                break;
            }
            board[current.getX()][current.getY()].setMarked();
        }
        System.out.println("Number of steps: "+steps);
        for(int i=0; i<cols; i++){
            for(int j = 0; j<rows; j++){
                if(board[i][j].getMarked()){
                    System.out.print(board[i][j].getValue()+" ");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void fillBoard(Position[][] board,int cols, int rows){
        Position p;
        for (int i = 0, c = cols*rows, m = 0; i <= cols / 2; i++, m++) {
            for (int j = m; j < cols - m; j++){
                p = new Position(i,j,c);
                board[i][j] = p;
                c--;
            }
            for (int j = m + 1; j < rows - m - 1; j++){
                p = new Position(j,cols - m - 1,c);
                board[j][cols - m - 1] = p;
                c--;
            }
            for (int j = cols - m - 1; c <= rows * cols && j >= m; j--){
                p = new Position(rows - i - 1,j,c);
                board[rows - i - 1][j] = p;
                c--;
            }
            for (int j = rows - m - 2; j > m; j--){
                p = new Position(j,i,c);
                board[j][i] = p;
                c--;
            }
        }
    }

    public static Position nextMoveHorse(Position[][] board, int rows, int cols, Position current){
        int min = -1;
        int nextx, nexty, auxX = 0, auxY = 0;
        int val;
        int[] next = new int[8*2];
        next[0] = 1;next[1] = 2;
        next[2] = 1;next[3] = -2;
        next[4] = -1;next[5] = 2;
        next[6] = -1;next[7] = -2;
        next[8] = 2;next[9] = 1;
        next[10] = 2;next[11] = -1;
        next[12] = -2;next[13] = 1;
        next[14] = -2;next[15] = -1;
        for(int i = 0; i<15; i++){
            nextx = current.getX()+next[i];
            nexty = current.getY()+next[i+1];

            if(nextx>=0 && nextx<rows && nexty>=0 && nexty<cols){
                val = board[nextx][nexty].getValue();
                //System.out.print(val+" ");
                if (val < min || min == -1) {
                    if(!board[nextx][nexty].getMarked()) {
                        min = val;
                        auxX = nextx;
                        auxY = nexty;
                    }
                }
            }
            i++;
        }
        //System.out.println();
        if(min==-1){
            current = null;
        } else {
            current.setValue(min);
            current.setY(auxY);
            current.setX(auxX);
            current.setMarked();
        }
        return current;
    }

    public static Position nextMoveBishop(Position[][] board, int rows, int cols, Position current){
        int min = -1;
        int nextx, nexty, auxX = 0, auxY = 0;
        int val;
        int[] next = new int[8];
        next[0] = 1;next[1] = -1;
        next[2] = 1;next[3] = 1;
        next[4] = -1;next[5] = 1;
        next[6] = -1;next[7] = -1;
        for(int i = 0; i<7; i++){
            nextx = current.getX()+next[i];
            nexty = current.getY()+next[i+1];

            if(nextx>=0 && nextx<rows && nexty>=0 && nexty<cols){
                val = board[nextx][nexty].getValue();
                //System.out.print(val+" ");
                if (val < min || min == -1) {
                    if(!board[nextx][nexty].getMarked()) {
                        min = val;
                        auxX = nextx;
                        auxY = nexty;
                    }
                }
            }
            i++;
        }
        //System.out.println();
        if(min==-1){
            current = null;
        } else {
            current.setValue(min);
            current.setY(auxY);
            current.setX(auxX);
            current.setMarked();
        }
        return current;
    }

    public static Position nextMoveTower(Position[][] board, int rows, int cols, Position current){
        int min = -1;
        int nextx, nexty, auxX = 0, auxY = 0;
        int val;
        int[] next = new int[8];
        next[0] = 1;next[1] = 0;
        next[2] = 0;next[3] = 1;
        next[4] = -1;next[5] = 0;
        next[6] = 0;next[7] = -1;
        for(int i = 0; i<7; i++){
            nextx = current.getX()+next[i];
            nexty = current.getY()+next[i+1];

            if(nextx>=0 && nextx<rows && nexty>=0 && nexty<cols){
                val = board[nextx][nexty].getValue();
                //System.out.print(val+" ");
                if (val < min || min == -1) {
                    if(!board[nextx][nexty].getMarked()) {
                        min = val;
                        auxX = nextx;
                        auxY = nexty;
                    }
                }
            }
            i++;
        }
        //System.out.println();
        if(min==-1){
            current = null;
        } else {
            current.setValue(min);
            current.setY(auxY);
            current.setX(auxX);
            current.setMarked();
        }
        return current;
    }

    public static Position nextMoveKing(Position[][] board, int rows, int cols, Position current){
        int min = -1;
        int nextx, nexty, auxX = 0, auxY = 0;
        int val;
        int[] next = new int[8*2];
        next[0] = 1;next[1] = 0;
        next[2] = 0;next[3] = 1;
        next[4] = -1;next[5] = 0;
        next[6] = 0;next[7] = -1;
        next[8] = 1;next[9] = -1;
        next[10] = 1;next[11] = 1;
        next[12] = -1;next[13] = 1;
        next[14] = -1;next[15] = -1;
        for(int i = 0; i<7; i++){
            nextx = current.getX()+next[i];
            nexty = current.getY()+next[i+1];

            if(nextx>=0 && nextx<rows && nexty>=0 && nexty<cols){
                val = board[nextx][nexty].getValue();
                //System.out.print(val+" ");
                if (val < min || min == -1) {
                    if(!board[nextx][nexty].getMarked()) {
                        min = val;
                        auxX = nextx;
                        auxY = nexty;
                    }
                }
            }
            i++;
        }
        //System.out.println();
        if(min==-1){
            current = null;
        } else {
            current.setValue(min);
            current.setY(auxY);
            current.setX(auxX);
            current.setMarked();
        }
        return current;
    }
}
