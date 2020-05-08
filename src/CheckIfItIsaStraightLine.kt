class CheckIfItIsaStraightLine {

    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val x = (coordinates[0][0] - coordinates[1][0]).toDouble()
        val y = (coordinates[0][1] - coordinates[1][1]).toDouble()
        for (i in 1..coordinates.size - 2) {
            val tempX = (coordinates[i][0] - coordinates[i + 1][0]).toDouble()
            val tempY = (coordinates[i][1] - coordinates[i + 1][1]).toDouble()
            if (y / x != tempY / tempX)
                return false
        }
        return true
    }
}