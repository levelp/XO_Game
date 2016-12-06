package model;

/**
 * Игровое поле
 */
public class Game {
    // Размер поля
    static final int SIZE = 4;
    // Пустая клетка поля
    static final char EMPTY = '_';

    // Игровое поле
    char[][] field = new char[SIZE][SIZE];

    public Game() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }
    }

    /**
     * Показать игровое поле
     */
    public void showField() {
        // Рамка сверху
        border();
        // Печать клеток поля
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        // Рамка снизу
        border();
    }

    private void border() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    /**
     * @return Игра окончена?
     */
    public boolean over() {
        // Горизонтали (строчки)
        for (int i = 0; i < SIZE; i++) {
            // Берём первый символ строчки
            char first = field[i][0];
            // Если первый символ не крестик и не нолик
            // то горизонтальной линии нет
            if (first == 'X' || first == 'O') {
                // Если он X или O, то проверяем что
                // остальные символы в строке такие же
                boolean allSame = true; // Предполагаем все такие же
                // XXO
                for (int j = 1; j < SIZE; j++) {
                    if (field[i][j] != first) {
                        allSame = false;
                        break;
                    }
                }
                if (allSame) {
                    System.out.println(first + " - выйграли");
                    return true;
                }
            }
        }
        // Вертикальные (столбцы)
        for (int j = 0; j < SIZE; j++) {
            // Берём верхний символ столбца
            char first = field[0][j];
            // Если верний символ не крестик и не нолик
            // то вертикальной линии нет
            if (first == 'X' || first == 'O') {
                // Если он X или O, то проверяем что
                // остальные символы в столбце такие же
                boolean allSame = true; // Предполагаем все такие же
                for (int i = 1; i < SIZE; i++) {
                    if (field[i][j] != first) {
                        allSame = false;
                        break;
                    }
                }
                if (allSame) {
                    System.out.println(first + " - выйграли");
                    return true;
                }
            }
        }
        // Диагональ прямая  \
        char first = field[0][0];
        // Если угловой символ не крестик и не нолик
        // то диагонали нет
        if (first == 'X' || first == 'O') {
            // Если он X или O, то проверяем что
            // остальные символы в диагонали такие же
            boolean allSame = true; // Предполагаем все такие же
            for (int i = 1; i < SIZE; i++) {
                if (field[i][i] != first) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                System.out.println(first + " - выйграли");
                return true;
            }
        }
        // Обратная диагональ /
        first = field[0][SIZE - 1];
        // Если угловой символ не крестик и не нолик
        // то диагонали нет
        if (first == 'X' || first == 'O') {
            // Если он X или O, то проверяем что
            // остальные символы в диагонали такие же
            boolean allSame = true; // Предполагаем все такие же
            for (int i = 1; i < SIZE; i++) {
                if (field[i][SIZE - i - 1] != first) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                System.out.println(first + " - выйграли");
                return true;
            }
        }
        // Проверяем все ли клетки поля заполнены?
        // Т.е. можно ли сделать ещё ход
        if (isDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        // Если все проверки прошли, то игра не окончена
        return false;
    }

    // Проверяем все ли клетки поля заполнены?
    // Т.е. можно ли сделать ещё ход
    private boolean isDraw() {
        boolean fieldFull = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == EMPTY) {
                    fieldFull = false;
                    break;
                }
            }
        }
        return fieldFull;
    }

    /**
     * Является ли ход корректным
     *
     * @param row строка
     * @param col столбец
     * @return Является ли ход корректным?
     */
    public boolean isMoveCorrect(int row, int col) {
        // Проверка на границы поля
        if (row < 1 || row > SIZE) {
            System.out.println("Строка должна быть в пределах: 1.." + SIZE);
            return false;
        }
        if (col < 1 || col > SIZE) {
            System.out.println("Столбец должен быть в пределах: 1.." + SIZE);
            return false;
        }
        // Можно ходить только в пустую клетку
        return field[row - 1][col - 1] == EMPTY;
    }

    /**
     * Делаем ход
     *
     * @param side Сторона: крестики или нолики
     * @param row  строка
     * @param col  столбец
     */
    public void move(char side, int row, int col) {
        if (!isMoveCorrect(row, col))
            throw new IllegalArgumentException("Неверный ход");
        field[row - 1][col - 1] = side;
    }

}
