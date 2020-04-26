package ATGCP;

import java.util.Scanner;

public class KnightsTour {

    int[][] solution;
    int path=0;

    public KnightsTour(int N){
        solution = new int[N][N];
        for(int i =0; i<N;i++){
            for(int k=0; k<N;k++){
                solution[i][k] = 0;
            }
        }
    }

    public void solve(){
        try {
            if (findPath(0, 0, 0, solution.length)) {
                printArray();
            } else {
                System.out.println("No Path Found");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean findPath(int row, int col , int index, int N){

        if(solution[row][col] != 0){
            return false;
        }

        solution[row][col] = path++;

        if(index == N * N -1){
            return true;
            // Solved
        }

        // Down Right
        if (canMove(row + 2, col + 1, N)
                && findPath(row + 2, col + 1, index + 1, N)) {
            return true;
        }
        // Right Down
        if (canMove(row + 1, col + 2, N)
                && findPath(row + 1, col + 2, index + 1, N)) {
            return true;
        }
        // Right Up
        if (canMove(row - 1, col + 2, N)
                && findPath(row - 1, col + 2, index + 1, N)) {
            return true;
        }
        // Up Right
         if (canMove(row - 2, col + 1, N)
                && findPath(row - 2, col + 1, index + 1, N)) {
            return true;
        }
        // Up Left
        if (canMove(row - 2, col - 1, N)
                && findPath(row - 2, col - 1, index + 1, N)) {
            return true;
        }
        // Left Up
        if (canMove(row - 1, col - 2, N)
                && findPath(row - 1, col - 2, index + 1, N)) {
            return true;
        }
        // Left Down
        if (canMove(row + 1, col - 2, N)
                && findPath(row + 1, col - 2, index + 1, N)) {
            return true;
        }
        // Down Left
        if (canMove(row + 2, col - 1, N)
                && findPath(row + 2, col - 1, index + 1, N)) {
            return true;
        }
        // Nothing Works
        solution[row][col] = 0;
        path--;
        return false;

    }

    public boolean canMove(int row , int col , int N){
        if(row >=0 && col >= 0 && row < N && col < N){
            return true;
        }
        return false;
    }

    public void printArray(){

        for(int i=0; i < solution.length; i++){
            for(int k=0; k < solution.length; k++){
                System.out.print(solution[i][k] + " ");
            } System.out.println();
        }
    }

    public static void main(String[] args) {
        int N;
        System.out.print("Enter a number: ");
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        KnightsTour i = new KnightsTour(N);
        i.solve();

    }

}
