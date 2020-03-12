package pl.prokom.sudoku;

import java.util.Random;

public class SudokuBoard {

    private static final int DIM = 9;
    private static final int MINI_DIM = 3;
    private int[][] board = new int[DIM][DIM];

    // tylko dla podstawowego sprawdzenia
    public static void main(String[] args) {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.fillBoard();
        sudoku.printSudokuBoard();
    }

    public boolean isCrossCorrect(int row, int col) {
        for (int i = 0; i < DIM; i++) {
            if (i != col) {
                if (this.board[row][i] == this.board[row][col])
                    return false;
            }
        }

        for (int i = 0; i < DIM; i++) {
            if (i != row) {
                if (this.board[i][col] == this.board[row][col])
                    return false;
            }
        }
        return true;
    }

    public boolean isMiniCorrect(int row, int col) {

        int miniRow = row / MINI_DIM;
        int miniCol = col / MINI_DIM;
        for (int i = 0; i < MINI_DIM; i++) {
            for (int j = 0; j < MINI_DIM; j++) {
                if ((i + miniRow * 3 != row) && (j + miniCol * 3 != col)) {
                    if (this.board[i + miniRow * 3][j + miniCol * 3] == this.board[row][col]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void fillBoard() {

//         tablica helperTab służy do przechowywania ciągu cyfr (1-9)
//         cel jej utworzenia:
//         trudność w "cofaniu się" po ustaleniu braku możliwości wstawienia danej cyfry do konkretnej komórki
//         trudność polega na odpowiedniej zmianie numeru rzędu, a następnie doboru odpowiedniej wartości "początkowej"
//         dla kroku w tył

        int[] helperTab = new int[DIM * DIM];
        boolean isCorrect = false;
        int r, c, i;
        Random randomize = new Random();

        for (i = 0; i < DIM * DIM; i++) {
            isCorrect = false;
            c = i % DIM;
            r = i / DIM;
            // gdy następuje wstawienie cyfry w puste miejsce w tablicy sudoku
            if (helperTab[i] == 0) {
                helperTab[i] = randomize.nextInt(9) + 1;
                board[r][c] = helperTab[i];
                if (isCrossCorrect(r, c) == true && isMiniCorrect(r, c) == true) {
                    isCorrect = true;
                    continue;
                } else {
                    for (int k = 0; k < 8; k++) {
                        if (board[r][c] + 1 == 10) {
                            board[r][c] = 1;
                        } else
                            board[r][c] = board[r][c] + 1;

                        if (isCrossCorrect(r, c) == true && isMiniCorrect(r, c) == true) {
                            isCorrect = true;
                            break;
                        }
                    }
                }
                // gdy następuje krok w tył i wymagane jest dopasowanie zapełnionej już komórki tabeli sudoku
            } else {
                // iteracja po wszystkich(!) cyfrach, dokładny warunek opisany poniżej
                for (int z = 0; z < 8; z++) {
                    if (board[r][c] + 1 == 10) {
                        board[r][c] = 1;
                    } else
                        board[r][c] = board[r][c] + 1;

                    //  podstawowe sprawdzenie + ważny warunek, mówiący że na miejscu zapełnionej komórki tabeli, nie może pojawić się już wartość,
                    //  którą została ona zainicjowana (warunek obowiązuje, gdy krok wstecz wypada na tą właśnie wartość,
                    //  podczas i+1 dopasowania warunek zawsze pozostanie spełniony)

                    if (isCrossCorrect(r, c) == true && isMiniCorrect(r, c) == true && board[r][c] != helperTab[i]) {
                        isCorrect = true;
                        break;
                    }
                    break;
                }
            }

            if (!isCorrect) {
                helperTab[i] = 0;
                board[r][c] = 0;
                i -= 2;
            }
        }
    }

    public void printRow(int rowNumber) {
        for (int col : board[rowNumber]) {
            System.out.print(col + " ");
        }
    }

    public void printSudokuBoard() {
        for (int i = 0; i < DIM; i++) {
            for (int col : board[i]) {
                System.out.print(col + " ");
            }
            System.out.print("\n");
        }
    }

}

