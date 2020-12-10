public class Board {
    private StringBuffer boardStr;

    int[] magicSquare = new int[]{4, 9, 2, 3, 5, 7, 8, 1, 6};

    public Board(String s){
        this.boardStr = new StringBuffer(s);
    }
    public boolean isEmptyAt(int i){
        return (boardStr.charAt(i) == '-');
    }
    public void makeMove(int i, char player){
        boardStr.setCharAt(i, player);
    }

    //I was a technique called magic square (Basically a square where the
    // sum of the n numbers in any horizontal, vertical, diagonal is 15)
    boolean hasWon(char player) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                for (int k = 0; k < 9; k++)
                    if (i != j && i != k && j != k)
                        if (boardStr.charAt(i) == player && boardStr.charAt(j) == player && boardStr.charAt(k) == player)
                            if (magicSquare[i] + magicSquare[j] + magicSquare[k] == 15)
                                return true;
        return false;
    }
}
