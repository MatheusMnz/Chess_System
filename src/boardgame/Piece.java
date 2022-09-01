package boardgame;

//Conhece o tabuleiro(Board), tem uma associação.
public abstract class Piece {
    protected Position position;
    private Board board;

    //Passo apenas o tabuleiro, pois aposição de uma peça recém criada é nula, nao foi colocada no tabuleiro ainda.
    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    //Só classes do mesmo pacote e subclasses tem acesso ao tabuleiro.
    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    //Método concreto utilizando um método abstrato.
    //Hook methods
    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    //Matriz quadrada
    public  boolean isThereAnyPossibleMove(){
        boolean[][] mat = possibleMoves();
        for(int i =0; i<mat.length; i++){
            for(int j=0; j<mat.length;j++){
                if(mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

}
