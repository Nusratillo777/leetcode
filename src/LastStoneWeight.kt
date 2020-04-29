//https://leetcode.com/problems/last-stone-weight/

import java.util.*

class LastStoneWeight {

    fun lastStoneWeight(stones: IntArray): Int {
        val queue = PriorityQueue<Int>()
        stones.forEach {
            queue.add(it)
        }
        while (queue.size > 1) {
            val stoneFirst = queue.remove()
            val stoneSecond = queue.remove()
            if (-1 * (stoneFirst - stoneSecond) != 0)
                queue.add(stoneFirst - stoneSecond)
        }
        return if (queue.isEmpty()) 0 else queue.remove()
    }
}