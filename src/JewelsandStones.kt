//https://leetcode.com/problems/jewels-and-stones/

class JewelsandStones {

    fun numJewelsInStones(J: String, S: String): Int {
        val map = HashMap<Char, Boolean>()
        J.forEach {
            map[it] = true
        }
        var ans = 0
        S.forEach {
            if (map.containsKey(it))
                ans++
        }
        return ans
    }
}