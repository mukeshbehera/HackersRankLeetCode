package com.dsa.hackersrank;

import java.util.List;
/*
It is about calculating the number of combinations of coins that make up a given amount.
* */
public class CoinCombinations {

    public static int change(int amount, List<Integer> coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Base case: one way to make amount 0 (no coins)

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        List<Integer> coins = List.of(1, 2, 5);
        int amount = 5;

        System.out.println(change(amount, coins));
    }
}


/*
The combinations to make 5 are:

[1, 1, 1, 1, 1]
[1, 1, 1, 2]
[1, 2, 2]
[5]

Output: 4
* */