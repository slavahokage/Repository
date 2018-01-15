package by.itstep;

//1) Комп ходящий рандомно
//2) Два компа ходящих рандомно (c паузой)


//3*) Алгоритм для компа который играет "умно"
//Регистрация на github

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        char[][] gameField = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        showGameField(gameField);
        int result;
        char symbol = 'X';
        do {


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            makeMove(gameField, symbol);
            symbol = symbol == 'X' ? '0' : 'X';
            showGameField(gameField);
            result = checkField(gameField);
        } while (result == 0);
        switch (result) {
            case 1:
                System.out.println("Победа X");
                break;
            case 2:
                System.out.println("Победа 0");
                break;
            case 3:
                System.out.println("Ничья");
        }
    }

    //Мы знаем чем мы ходим(Х или 0), но нам надо узнать в какую клетку
    public static void makeMove(char[][] gameField, char symbol/*Х или 0*/) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сейчас ходит " + symbol);
        int n;
        int m;
        int number;
        do {
            number = scanner.nextInt();
            n = 2 - (number - 1) / 3;
            m = (number - 1) % 3;
        } while (number < 1 || number > 9 || gameField[n][m] != ' ');
        gameField[n][m] = symbol;
    }

    public static void showGameField(char[][] gameField) {
        System.out.println(gameField[0][0] + "|" + gameField[0][1] + "|" + gameField[0][2]);
        System.out.println("-----");
        System.out.println(gameField[1][0] + "|" + gameField[1][1] + "|" + gameField[1][2]);
        System.out.println("-----");
        System.out.println(gameField[2][0] + "|" + gameField[2][1] + "|" + gameField[2][2]);
    }

    public static int checkField(char[][] gameField) {
        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == gameField[i][1]
                    && gameField[i][0] == gameField[i][2]) {
                if (gameField[i][0] == 'X')
                    return 1;
                if (gameField[i][0] == '0')
                    return 2;
            }
            if (gameField[0][i] == gameField[1][i]
                    && gameField[0][i] == gameField[2][i]) {
                if (gameField[0][i] == 'X')
                    return 1;
                if (gameField[0][i] == '0')
                    return 2;
            }
        }
        if (gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2]) {
            if (gameField[0][0] == 'X')
                return 1;
            if (gameField[0][0] == '0')
                return 2;
        }
        if (gameField[2][0] == gameField[1][1] && gameField[2][0] == gameField[0][2]) {
            if (gameField[2][0] == 'X')
                return 1;
            if (gameField[2][0] == '0')
                return 2;
        }
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (gameField[i][j] == ' ')
                    return 0; //Продолжаем

        return 3; //Ничья
    }
}



