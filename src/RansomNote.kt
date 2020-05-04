//https://leetcode.com/problems/ransom-note/

class RansomNote {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val map = HashMap<Char, Int>()
        magazine.forEach {
            if (map.containsKey(it))
                map[it] = map[it]?.plus(1) ?: 0
            else
                map[it] = 1
        }
        ransomNote.forEach {
            if (map.containsKey(it)) {
                map[it] = map[it]?.minus(1) ?: 0
                if (map[it] == 0)
                    map.remove(it)
            } else {
                return false
            }
        }
        return true
    }
}

fun main() {
    val ransomNote = RansomNote()
    println(ransomNote.canConstruct("a", "b"))
}