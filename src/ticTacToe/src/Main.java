import service.TicTacToeGame;

public class Main {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initialize(3);
        System.out.println(game.play());
    }
}

