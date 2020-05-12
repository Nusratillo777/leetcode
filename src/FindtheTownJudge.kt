class FindtheTownJudge {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val tempBool = BooleanArray(N + 1) { false }
        val tempInt = IntArray(N + 1) { 0 }
        trust.forEach {
            tempBool[it[0]] = true
            tempInt[it[1]]++
        }
        for (i in 1..N) {
            if (!tempBool[i] && tempInt[i] == N - 1)
                return i
        }
        return -1
    }
}