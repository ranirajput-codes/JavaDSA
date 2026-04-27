package linearsearch;

public class FindMinimumNumber {
    public static void main(String[] args) {
        int[] arr = {11,22,0,37,86,99,4,};
        System.out.println(min(arr));
    }
    static int min(int[] arr){
        int min = arr[0];
        for(int i = 1; i< arr.length; i++){
            if(arr[i]<min){
                min = arr[i];
                return min;
            }
        }
        return min;
    }
}
