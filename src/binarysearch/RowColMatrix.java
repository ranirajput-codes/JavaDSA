package binarysearch;

import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        System.out.println(Arrays.toString(search(arr,1)));
    }
    static int[] search(int[][] matrix, int target){
        // we are starting with first row and last column, like from the top right corner
        int row = 0;  // vertical pointer
        int col = matrix.length -1;  // horizontal pointer
        while(row <= matrix.length-1 && col >= 0){
            if(matrix[row][col]== target){
                return new int[] {row, col};
            }else if(matrix[row][col]>target){
                col--;  // everytime down is greater
            }else{
                row++;  // everything in the right is smaller
            }
        }
        return new int[] {-1,-1};
    }
}
