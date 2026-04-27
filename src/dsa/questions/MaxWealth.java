package dsa.questions;

public class MaxWealth {
    public static void main(String[] args) {
        int[][] accounts = {
                {1, 5, 7},
                {8, 2, 5},
                {25,25,25}
        };
        System.out.println(maximumWealth(accounts));
    }

    static int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for (int person = 0; person < accounts.length; person++) {
            //when you start a new column, take a new sum for that row
            int sum = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                sum = sum + accounts[person][account];
            }
            // now we have sum of accounts of the person
            // check with overall answer
            if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }
}
