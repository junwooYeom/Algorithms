package backjoon

import java.util.StringTokenizer

private val board =
    intArrayOf(
        0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0,
        10, 13, 16, 19, 25, 30, 35, 40, 0,
        20, 22, 24, 25, 30, 35, 40, 0,
        30, 28, 27, 26, 25, 30, 35, 40, 0
    )

private var dice = IntArray(10)
private var piece = IntArray(10)
private var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val dice = IntArray(10)

    for (i in 0 until 10) {
        dice[i] = st.nextToken().toInt()
    }

    println(dice.contentToString())

    selectHorse(0)
    println(answer)
}

private fun selectHorse(count: Int) {
    if (count == 0) {
        answer = answer.coerceAtLeast(startGame())
        return
    }
    for (i in 0 until 4) {
        piece[count] = i
        selectHorse(count + 1)
    }
}

private fun startGame() : Int{
    val visited = BooleanArray(board.size)
    var score = 0
    val player = intArrayOf(4)
    for (i in 0 until 10) {
        val currentDice = dice[i]
        val currentPlayer = piece[i]
        if (isFinish(player[currentPlayer])) return score

        val nextPoint = nextPoint(player[currentPlayer], currentDice)
        if (isFinish(nextPoint)) {
            setVisited(visited, player[currentPlayer], false)
            player[currentPlayer] = nextPoint
            continue
        }
        if (visited[nextPoint]) return score
        setVisited(visited, player[currentPlayer], false)
        setVisited(visited, nextPoint, true)

        player[currentPlayer] = nextPoint
        score += board[player[currentPlayer]]
    }
    return score
}

private fun nextPoint(currentPoint: Int, dice: Int): Int {
    var next = currentPoint + dice
    next = when {
        currentPoint < 21 && next >= 21 -> 21
        currentPoint < 30 && next >= 30 -> 30
        currentPoint < 38 && next >= 38 -> 38
        currentPoint < 47 && next >= 47 -> 47
        else -> next
    }

    return when (next) {
        5 -> 22
        10 -> 31
        15 -> 39
        else -> next
    }
}

private fun setVisited(visited: BooleanArray, index: Int, isChecked: Boolean) {
    when (index) {
        20, 29, 37, 46 -> { // 40
            visited[20] = isChecked
            visited[29] = isChecked
            visited[37] = isChecked
            visited[46] = isChecked
        }
        26, 34, 43 -> { // 25
            visited[26] = isChecked
            visited[34] = isChecked
            visited[43] = isChecked
        }
        27, 35, 44 -> { // 30
            visited[27] = isChecked
            visited[35] = isChecked
            visited[44] = isChecked
        }
        28, 36, 45 -> { // 35
            visited[27] = isChecked
            visited[35] = isChecked
            visited[44] = isChecked
        }
        else -> visited[index] = isChecked
    }

    }

private fun isFinish(index: Int) = index == 21 || index == 30 || index == 38 || index == 47