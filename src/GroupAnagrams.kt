//https://leetcode.com/problems/group-anagrams/

import java.util.ArrayList
import java.util.Arrays
import java.util.HashMap

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()
        val counts = IntArray(26)
        for (s in strs) {
            Arrays.fill(counts, 0)
            for (c in s.toCharArray()) {
                counts[c - 'a']++
            }
            val sb = StringBuilder()
            for (i in 0..25) {
                sb.append(counts[i])
                sb.append("$")
            }
            val key = sb.toString()
            if (!map.containsKey(key))
                map[key] = ArrayList()
            map[key]?.add(s)
        }
        return ArrayList(map.values)
    }
}