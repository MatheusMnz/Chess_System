package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    //Instancio um obj. do tipo Piece que contem uma matriz de peças.
    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }


    //Retornando um objeto piece
    public Piece piece(int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    //Consigo acessar diretamente o position, pois ela é protected
    //Se a posição não é nula, já tem uma peça
    //Se não, coloco a peça na posição
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;

    }


    public Piece removePiece(Position position) {
       if(!positionExists(position)){
           throw new BoardException("Position not on the board");
       }
       if(piece(position) == null){
           return null;
       }
       Piece aux = piece(position);
       aux.position = null;
       pieces[position.getRow()][position.getColumn()] = null;
       return aux;
    }

    //Validando as caracteristicas de uma posição do tabuleiro
    private  boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    //Verifico se naquela posição já existe uma peça
    //Caso contrario, lanço uma exceção
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }





}
