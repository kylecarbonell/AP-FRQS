public class Crossword {
    private Square[][] puzzle;

    public Crossword(boolean[][] blackSquares){
        int count = 1;
        puzzle = new Square[blackSquares.length][];

        for(int i = 0; i < puzzle.length; i++){
            puzzle[i] = new Square[blackSquares[i].length];
            for(int j = 0; j < puzzle[i].length; j++){
                if(toBeLabeled(i, j, blackSquares)){
                    puzzle[i][j] = new Square(false, count);
                    count++;
                }
                else{
                    puzzle[i][j] = new Square(true, 0);
                }
            }
        }
    }

    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares){
        if(blackSquares[r][c]){
            return false;
        }
        if(blackSquares[r-1][c] || blackSquares[r][c-1]){
            return false;
        }

        return true;
    }
}
