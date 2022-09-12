import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import kotlin.math.abs

private var n = 0
private var l = 0
private var r = 0
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private val canMove = ArrayList<Pair<Int, Int>>()
private val queue: Queue<Pair<Int, Int>> = LinkedList()
private lateinit var map: Array<IntArray>
private lateinit var visited: Array<BooleanArray>

fun main() = with(System.`in`.bufferedReader()){
    var st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    l = st.nextToken().toInt()
    r = st.nextToken().toInt()

    map = Array(n) { IntArray(n) }
    repeat(n) { row ->
        st = StringTokenizer(readLine())
        repeat(n) { col ->
            map[row][col] = st.nextToken().toInt()
        }
    }
    // END INPUT
    println(move())
}

private fun move(): Int {
    var count = 0
    while (true) {
        visited = Array(n) { BooleanArray(n) }
        var isMove = false
        repeat(n) { row ->
            repeat(n) { col ->
                if (visited[row][col].not()) {
                    val total = bfs(row, col)

                    if (canMove.size > 1) {
                        afterMove(total)
                        isMove = true
                    }
                }
            }
        }
        if (isMove.not()) return count
        count++
    }
}

private fun bfs(y: Int, x: Int): Int {
    canMove.clear()
    queue.clear()
    queue.add(Pair(y, x))
    canMove.add(Pair(y, x))
    visited[y][x] = true

    var total = map[y][x]
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        val curY = current.first
        val curX = current.second

        for(i in 0 until 4) {
            val nextY = curY + dy[i]
            val nextX = curX + dx[i]

            if (isCondition(nextY, nextX)) {
                val diff = abs(map[nextY][nextX] - map[curY][curX])
                if (diff in l .. r) {
                    queue.add(Pair(nextY, nextX))
                    canMove.add(Pair(nextY, nextX))
                    total += map[nextY][nextX]
                    visited[nextY][nextX] = true
                }
            }
        }
    }

    return total
}
private fun afterMove(total: Int) {
    val avg = total / canMove.size
    canMove.forEach { map[it.first][it.second] = avg }
}

private fun isCondition(x: Int, y: Int) = (y in 0 until n && x in 0 until n && visited[x][y].not())