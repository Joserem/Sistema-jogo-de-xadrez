package boardgame;

public class Board {

    // Attributes
    
    private int rows;
    private int columns;
    private Piece[][] pieces;

    // Constructors

    public Board(int rows, int columns) {

        if(rows < 1 || columns < 1){
            throw new BoardException("Erro ao criar o tabuleiro: é necessário que tenha pelo menos 1 linha e 1 coluna");
        }

        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    // Getters and Setters

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // Methods

    public Piece piece(int row, int column){

        if (!positionExists(row, column)) {
            throw new BoardException("Posição não consta no tabuleiro");
        }

        return pieces[row][column];
    }

    // Piece

    public Piece piece(Position position){

        if (!positionExists(position)) {
            throw new BoardException("Posição não consta no tabuleiro");
        }

        return pieces[position.getRow()][position.getColumn()];
    }

    // Place piece

    public void placePiece(Piece piece, Position position){

        if (thereIsAPiece(position)) {
            throw new BoardException("Já existe uma peça sobre a posição " + position);
        }

        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    
    // Remove piece
    
    public Piece removePiece(Position position){
        if (!positionExists(position)) {
            throw new BoardException("Position nao existe no tabuleiro");
        }
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;

    }



    private boolean positionExists(int row, int column){
         return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)) {
            throw new BoardException("Posição não consta no tabuleiro");
        }
        return piece(position) != null;
    }
}
