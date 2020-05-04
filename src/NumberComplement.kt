class NumberComplement {
    fun findComplement(num: Int): Int {
        var temp = 1L
        while (temp <= num) {
            temp *= 2
        }
        return num.toLong().xor(temp - 1).toInt()
    }
}