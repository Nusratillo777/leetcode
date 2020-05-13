class FloodFill {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val used = Array<BooleanArray>(image.size) { BooleanArray(image[0].size) { false } }
        dfs(sr, sc, image, used, image[sr][sc], newColor)
        return image
    }

    private fun dfs(i: Int, j: Int, image: Array<IntArray>, used: Array<BooleanArray>, oldColor: Int, newColor: Int) {
        if (i < 0 || j < 0 || i >= image.size || j >= image[0].size || image[i][j] != oldColor || used[i][j])
            return
        used[i][j] = true
        image[i][j] = newColor
        dfs(i + 1, j, image, used, oldColor, newColor)
        dfs(i - 1, j, image, used, oldColor, newColor)
        dfs(i, j + 1, image, used, oldColor, newColor)
        dfs(i, j - 1, image, used, oldColor, newColor)
    }
}

fun main() {
    val b = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
    val floodFill = FloodFill()
    println(floodFill.floodFill(b, 1, 1, 1))
}