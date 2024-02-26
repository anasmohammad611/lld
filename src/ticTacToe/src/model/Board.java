package model;

public class Board {
    PlayingPiece[][] board;
    int size;
    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public void printBoard() {
        System.out.println("Board: ");
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null)
                    if(j < size - 1)
                        System.out.print("  | ");
                    else
                        System.out.print("  ");
                else
                    if(j < size - 1)
                        System.out.print(board[i][j].pieceType + " | ");
                    else
                        System.out.print(board[i][j].pieceType);
            }
            System.out.println();
        }
    }

    public boolean add(Player player, int r, int c) {
        if(board[r][c] != null) return false;
        
        board[r][c] = player.playingPiece;
        return true;
    }

    public boolean checkWinner(Player player, int row, int col) {
        PieceType pieceType = player.playingPiece.pieceType;

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for (int i = 0; i < size; i++) {

            if (board[row][i] == null || board[row][i].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        //need to check in col
        for (int i = 0; i < size; i++) {

            if (board[i][col] == null || board[i][col].pieceType != pieceType) {
                columnMatch = false;
                break;
            }
        }

        //need to check diagonals
        for (int i = 0, j = 0; i <  size; i++, j++) {
            if (board[i][j] == null || board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        //need to check anti-diagonals
        for (int i = 0, j =  size - 1; i <  size; i++, j--) {
            if (board[i][j] == null || board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

    public boolean checkEmptySpaces() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null) return true;
            }
        }
        return false;
    }
}
