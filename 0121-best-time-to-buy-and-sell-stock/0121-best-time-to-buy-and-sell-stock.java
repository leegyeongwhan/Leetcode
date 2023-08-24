class Solution {
    public int maxProfit(int[] prices) {
       int maxPrice = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxPrice = Math.max(maxPrice, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        System.out.println("max = " + maxPrice);
        return maxPrice;
    }
}