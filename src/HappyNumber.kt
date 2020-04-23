//https://leetcode.com/problems/happy-number/

class HappyNumber {

    fun isHappy(n: Int): Boolean {
        val map = HashMap<Int, Boolean>()
        var N = n
        while (true) {
            var temp = getDigitSum(N)
            if (temp == 1)
                return true
            if (map.containsKey(temp))
                break
            map[temp] = true
            N = temp
        }
        return false
    }

    private fun getDigitSum(n: Int): Int {
        var ans = 0
        var N = n
        while (N > 0) {
            ans += (N % 10) * (N % 10)
            N /= 10
        }
        return ans
    }
}