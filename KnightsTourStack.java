package ATGCP;

import java.util.Scanner;
import java.util.Stack;

public class KnightsTourStack {

    private int[][]chess;
    private int size;
    private static int count = 0;

    public KnightsTourStack(int size){
        this.size = size;
        chess = new int[size][size];
    }

    private void print(int knightLocation){
        int row , col , top , temp;

        Stack<Integer> stack = new Stack<Integer>();

        row = knightLocation/size;
        col = knightLocation%size;
        chess[row][col] = 1;
        System.out.println("["+ (row + col)+"]");

        count ++;
        stack.push(knightLocation);

        while (!stack.isEmpty()){
            top = stack.peek();

            if((temp = validMove(top)) != 1){
                row = temp/size;
                col = temp%size;
                chess[row][col] =1;

                if(count % size == 0){ System.out.println(); }
                System.out.print("["+(row + col)+"]");

                count++;
                stack.push(temp);
                } else {
                    stack.pop();
                }
            }
    }

    private  int validMove(int top) {

        int row, col, rowIndex, lColIndex, rColIndex, index;
        row = top / size;
        col = top % size;

        for (int i = -2; i <= 2; i++) {
            if (i == 0) {
                continue;
            }

            if(i%2 ==0){
                index = 1;
            } else {
                index =2;
            }

            rowIndex = row+i;
            lColIndex = col-index;
            rColIndex = col+index;

            if( rowIndex >=0 && rowIndex < size){
                if(lColIndex >=0 && lColIndex < size){
                    if(chess[rowIndex][lColIndex] ==0)
                    return (rowIndex*size + rColIndex);
                }
                if(rColIndex >=0 && rColIndex < size){
                    if(chess[rowIndex][rColIndex] ==0){
                        return (rowIndex*size + rColIndex);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        KnightsTourStack kt = new KnightsTourStack(N);
        kt.print(0);
    }
}