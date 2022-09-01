package chess;

import boardgame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if(column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    //Converter posição do jogo para o a tabuleiro
    //matrix_row = 8 - chess_row
    //'a' - 'a' = 0
    //'b' - 'a' = 1
    //matrix_column = chess_column - 'a'
    //Retorno uma inst. de uma nova posição em outras coordernadas
    protected Position toPosition(){
        return  new Position(8 - row, column - 'a');
    }

    //Converto da matriz para o xadrez
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
