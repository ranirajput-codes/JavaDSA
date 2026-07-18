package binarysearch;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(search(arr, 3)));
    }

    // search in the row provided, between the columns provided ( the sorted row )
    static int[] binarySearch(int[][] matrix, int target, int row, int cStart, int cEnd){
        int mid = cStart + (cEnd-cStart)/2 ;
        while(cStart<=cEnd){
            if(matrix[row][mid] == target){
                return new int[]{row,mid};
            }
            if(matrix[row][mid] < target){
                cStart = mid + 1;
            }else{
                cEnd = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }

    static int[] search(int[][] matrix , int target){
        int rows = matrix.length;  // we are storing the length or rows and cols
        int cols = matrix[0].length;  // be cautious, matrix may be empty

        if(rows == 1){
            return binarySearch(matrix, target, 0, 0, cols-1);
        }

        int rowStart = 0;
        int rowEnd = rows - 1;
        int colMid = cols/2;
        // run the loop till only two rows are remaining at the last
        while(rowStart < (rowEnd-1)){ // while this is true it will have more than two rows
            int mid = rowStart + (rowEnd - rowStart)/2;
            if(matrix[mid][colMid]== target){
                return new int[] {mid, colMid};
            }
            if(matrix[mid][colMid] > target){
                rowEnd = mid;
            }else{
                rowStart = mid;
            }
        }
        // now we have two rows remaining
        // check whether the target is in the col of two rows
        if(matrix[rowStart][colMid] == target){
            return new int[]{rowStart, colMid};
        }if(matrix[rowStart+1][colMid] == target){
            return new int[]{rowStart+1, colMid};
        }

        // if still not found

        // search in 1st half
        if(target<=matrix[rowStart][colMid-1]){
            return binarySearch(matrix, target, rowStart, 0, colMid-1 );
        }
        // search in 2nd half
        if(target>=matrix[rowStart][colMid+1] && target<=matrix[rowStart][cols-1]){
            return binarySearch(matrix, target, rowStart, colMid+1, cols -1);
        }
        // search in 3rd half
        if(target<=matrix[rowStart+1][colMid-1]){
            return binarySearch(matrix, target, rowStart+1, 0, colMid-1);
        }
        // search in 4th half
        else{
            return binarySearch(matrix, target, rowStart+1, colMid+1, cols-1);
        }
    }
}
