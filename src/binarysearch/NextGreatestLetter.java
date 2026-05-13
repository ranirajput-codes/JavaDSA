package binarysearch;
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/
//You are given an array of characters [letters] that is sorted in non-decreasing order,
// and a character [target]. There are at least two different characters in letters.
//Return the smallest character in letters that is lexicographically greater than target.
// If such a character does not exist, return the first character in letters.

public class NextGreatestLetter {
    public static void main(String[] args) {
        char [] letters = {'a','c','f','s','u'};
        char target = 'f';
        System.out.println(nextGreatestLetter(letters, target));
    }
    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
        //in this case start is 2 and length is 5. we can't divide 2 with five. so we get the
        // remainder 2 ( same as the ans everytime).
        // and if the target is greater than the last element the start will become mid+1 = (the length of the array)
        //so when we will divide start(= to length) with length we will get the remainder 0 ( the first index).

        //if we don't want to return start%letters.length so we can add another if condition like, if start==letters.length , return 0
    }
}
