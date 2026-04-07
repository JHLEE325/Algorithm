import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[4][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int currentPlayer = Integer.parseInt(br.readLine());
        int winner = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            board[r][c] = currentPlayer;

            if (winner == 0 && checkWin(currentPlayer)) {
                winner = currentPlayer;
            }

            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        System.out.println(winner);
    }

    static boolean checkWin(int p) {
        for (int i = 1; i <= 3; i++) {
            if (board[i][1] == p && board[i][2] == p && board[i][3] == p) return true;
            if (board[1][i] == p && board[2][i] == p && board[3][i] == p) return true;
        }
        
        if (board[1][1] == p && board[2][2] == p && board[3][3] == p) return true;
        if (board[1][3] == p && board[2][2] == p && board[3][1] == p) return true;

        return false;
    }
}