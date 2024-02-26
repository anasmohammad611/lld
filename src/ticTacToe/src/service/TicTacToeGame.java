package service;

import model.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> playerList;
    Board board;

    public void initialize(int size) {
        playerList = new ArrayDeque<>();

        Player p1 = new Player("X", new PlayingPiece(PieceType.X));
        playerList.add(p1);

        Player p2 = new Player("O", new PlayingPiece(PieceType.O));
        playerList.add(p2);

        board = new Board(size);
    }

    public String play() {
        Scanner sc = new Scanner(System.in);
        boolean gameOver = true;
        while(gameOver) {
            board.printBoard();

            Player player = playerList.removeFirst();
            int r = 0, c = 0;
            while (true) {
                System.out.print("Player:" + player.name + " Enter row,column: ");
                String s = sc.nextLine();
                String[] values = s.split(",");
                r = Integer.parseInt(values[0]);
                c = Integer.parseInt(values[1]);

                boolean flag = board.add(player, r, c);
                if(flag) break;
                System.out.println("position already filled. Try different position");
            }


            if(board.checkWinner(player, r, c)) {
                board.printBoard();
                return player.name + " won the game";
            }
            if(!board.checkEmptySpaces()) {
                gameOver = false;
                board.printBoard();
            }
            playerList.add(player);
        }

        return "Its a tie";
    }
}
