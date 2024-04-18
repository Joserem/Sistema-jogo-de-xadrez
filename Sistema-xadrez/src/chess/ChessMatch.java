package chess;

import boardgame.Board;
import boardgame.Position;
import chess.chess_pieces.King;
import chess.chess_pieces.Rook;

public class ChessMatch {

    // Atributes 

    private Board board;

    // Constructors
    
    public ChessMatch(){
        board = new Board(8, 8);
        initialSetup();
    }

    // Methods

    public ChessPiece[][] getPieces(){

        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for(int i = 0 ; i<board.getRows(); i++){

            for(int j = 0 ; j<board.getColumns(); j ++){

                mat[i][j] = (ChessPiece)board.piece(i,j);

            }
        }
        return mat;

    }

    private void initialSetup(){
        board.placePiece(new Rook(board, Color.BLACK), new Position(2, 1));
        board.placePiece(new King(board, Color.WHITE), new Position(3, 4));
        board.placePiece(new King(board, Color.BLACK), new Position(7, 4));
    }


}
