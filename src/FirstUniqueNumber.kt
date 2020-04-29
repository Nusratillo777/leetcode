class DoubleLinkedListNode(
    val `val`: Int,
    var prev: DoubleLinkedListNode? = null,
    var next: DoubleLinkedListNode? = null
)

class FirstUnique(nums: IntArray) {
    var head: DoubleLinkedListNode? = null
    var tail: DoubleLinkedListNode? = null
    val map = HashMap<Int, DoubleLinkedListNode>()
    val setNums = mutableSetOf<Int>()

    init {
        nums.forEach {
            add(it)
        }
    }

    fun showFirstUnique(): Int {
        return head?.`val` ?: -1
    }

    fun add(value: Int) {
        if (map.containsKey(value)) {
            if (setNums.contains(value)) {
                val temp = map[value]
                if (temp == head && temp == tail) {
                    head = null
                    tail = null
                } else if (temp == head) {
                    head = head?.next
                    head?.prev = null
                } else if (temp == tail) {
                    tail = tail?.prev
                    tail?.next = null
                } else {
                    val left = temp?.prev
                    val right = temp?.next
                    left?.next = right
                    right?.prev = left
                }
                setNums.remove(value)
            }
        } else {
            val temp = DoubleLinkedListNode(value)
            if (head == null){
                head = temp
                tail = temp
            }else{
                temp.prev = tail
                tail?.next = temp
                tail = tail?.next
            }
            setNums.add(value)
            map[value] = temp
        }
    }
}