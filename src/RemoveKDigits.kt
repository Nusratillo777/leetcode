import java.util.*

class RemoveKDigits {
    fun removeKdigits(num: String, k: Int): String {
        var s = ""
        var K = k
        for (i in num.indices) {
            if (s.isEmpty() && num[i] != '0') {
                s += num[i]
            } else {
                while (s.isNotEmpty() && s.last() > num[i] && K > 0) {
                    K--
                    s = s.dropLast(1)
                }
                if (s.isNotEmpty() || num[i] != '0')
                    s += num[i]
            }
        }
        while (K > 0 && s.isNotEmpty()) {
            K--
            s = s.dropLast(1)
        }
        return if (s.isNotEmpty()) s else "0"
    }
}