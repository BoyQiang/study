package com.study.dynamic;

import java.util.Objects;

/**
 *
 * 给定一组数组 求出连续子序列的最大累加值
 * 定义dp[n]数组在n位置的最大累加值
 * 则dp方程：dp[n] = max(dp[n-1]+a[n], a[n])
 * 最大值就在各个dp[n]中取得
 */
public class MaxSumResult {

    public static void main(String[] args){
        int[] origin = {0,12,-2,3,50,9,-35,20,10};
        MaxSumResult maxSumResult = new MaxSumResult();
        System.out.println(maxSumResult.getMaxSumResult(origin));
    }

    private int getMaxSumResult(int[] origin){
        if (Objects.isNull(origin)) {
            return Integer.MIN_VALUE;
        }
        if (origin.length == 1) {
            return origin[0];
        }
        int[] dp = new int[origin.length];
        dp[0] = origin[0];
        int res = Integer.MIN_VALUE;
        for (int i=1; i<origin.length; i++) {
            dp[i] = Integer.max(dp[i-1] + origin[i], origin[i]);
            res = Integer.max(res, dp[i]);
        }
        return res;
    }
}
