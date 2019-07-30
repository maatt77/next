import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
valued coins, how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
So the output should be 5.
 */

//    int[] coins = {4,2,3};
//    int sum = 6;
//
//    CoinChange cc = new CoinChange();
////        System.out.println(cc.numSolsRecursion(coins,coins.length-1,sum));
////        System.out.println(cc.numSolsMemo(coins,coins.length-1,sum,new HashMap<String,Integer>()));
////        System.out.println(cc.numSolsTab(coins,sum));
////        System.out.println(cc.leastNumCoinsRecursion(coins,coins.length-1,sum));
//        System.out.println(cc.leastNumCoinsTabular(coins,sum));

    public int numSolsRecursion(int[] coins, int index, int sum) {

        if (sum == 0) return 1;

        if (sum < 0) return 0;

        if (index < 0 && sum > 0) return 0;

        return numSolsRecursion(coins, index, sum - coins[index]) + numSolsRecursion(coins, index - 1, sum);
    }

    public int numSolsMemo(int[] coins, int index, int sum, Map<String, Integer> memTable) {

        String key = String.valueOf(index) + "-" + String.valueOf(sum);

        if (!memTable.containsKey(key)) {

            if (sum == 0) memTable.put(key, 1);

            if (sum < 0) memTable.put(key, 0);

            if (index < 0 && sum > 0) memTable.put(key, 0);

            memTable.put(key, numSolsRecursion(coins, index, sum - coins[index]) + numSolsRecursion(coins, index - 1, sum));

        }

        return memTable.get(key);
    }

    public int numSolsTab(int[] coins, int sum) {

        int[][] results = new int[coins.length + 1][sum + 1];

        for (int row = 0; row <= coins.length; row++) {

            for (int col = 0; col <= sum; col++) {

                if (col == 0) {
                    results[row][col] = 1;
                } else if (row == 0) {
                    results[row][col] = 0;
                } else {
                    results[row][col] = (coins[row - 1] > col ? 0 : results[row][col - coins[row - 1]]) + results[row - 1][col];
                }
            }

        }

        return results[coins.length][sum];

    }

    public int leastNumCoinsRecursion(int[] coins, int index, int sum) {

        if (sum == 0) return 0;
        if (sum < 0) return Integer.MAX_VALUE; // No solution exists
        if (sum > 0 && index < 0) return Integer.MAX_VALUE; // No soution exists
        // Solution for am array coins[1+length] and sum = S
        //        min( solution(coins[excluding the last element , sum])  , solution[ the whole array , sum-last element] )

        return Math.min(leastNumCoinsRecursion(coins, index - 1, sum),
                leastNumCoinsRecursion(coins, index, sum - coins[index]) == Integer.MAX_VALUE ?
                        Integer.MAX_VALUE : 1 + leastNumCoinsRecursion(coins, index, sum - coins[index])
        );

    }


    public int leastNumCoinsTabular(int[] coins, int sum) {

        int[][] results = new int[coins.length + 1][sum + 1];

        for (int rows = 0; rows <= coins.length; rows++) {

            for (int col = 0; col <= sum; col++) {

                if (col == 0) {
                    results[rows][col] = 0;
                } else if (rows == 0) {
                    results[rows][col] = Integer.MAX_VALUE;
                } else {
                    if (coins[rows - 1] > col) {
                        results[rows][col] = results[rows - 1][col];
                    } else {

                        results[rows][col] = Math.min(
                                results[rows][col - coins[rows - 1]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (1 + results[rows][col - coins[rows - 1]])
                                , results[rows - 1][col]);
                    }
                }

            }

        }

        int row = coins.length;
        int col = sum;

        // Print the coins
        while (row>0 || col > 0) {
            if (results[row][col] < results[row-1][col]) {
                System.out.print(coins[row-1] + " ==> ");
                col = col - coins[row-1];
            } else {
                row = row-1;
            }
        }
        System.out.println();
        return results[coins.length][sum];

    }




}
