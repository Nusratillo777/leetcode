//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class BestTimetoBuyandSellStockII {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty())
            return 0
        var ans = 0
        var mn = prices[0]
        for (i in 1 until prices.size - 1) {
            if (mn < prices[i] && prices[i + 1] < prices[i]) {
                ans += prices[i] - mn
                mn = prices[i + 1]
            } else {
                mn = if (mn < prices[i]) mn else prices[i]
            }
        }
        if (prices[prices.size - 1] > mn)
            ans += prices[prices.size - 1] - mn
        return if (ans > 0) ans else 0
    }
}