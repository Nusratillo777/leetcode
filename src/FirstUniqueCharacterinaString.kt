class FirstUniqueCharacterinaString {
    fun firstUniqChar(s: String): Int {
        val temp = BooleanArray(26) { false }
        s.forEach {
            temp[it - 'a'] = true
        }
        s.forEachIndexed { index, char ->
            if (!temp[char - 'a'])
                return index
        }
        return -1
    }
}