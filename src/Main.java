import model.Game;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Game game = new Game();

    public static void main(String[] args) {
        // Показываем игровое поле
        game.showField();
        while (true) {
            // Спросить как ходят X и сделать ход
            doMove('X');
            // Показываем игровое поле
            game.showField();
            // Если игра окочена => выход
            if (game.over()) {
                break;
            }
            // Спросить как ходят O
            doMove('O');
            // Показываем игровое поле
            game.showField();
            if (game.over()) {
                break;
            }
        }
    }

    private static void doMove(char side) {
        int row;
        int col;
        do {
            System.out.print("Введите ход " + side + " строка столбец: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!game.isMoveCorrect(row, col));
        game.move(side, row, col);
    }
}
