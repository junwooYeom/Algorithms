package programmers

/**
 * [92344] https://school.programmers.co.kr/learn/courses/30/lessons/92344
 */
class `92344` {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {

        var answer = 0
        val arr = Array(board.size+1) { IntArray(board[0].size+1)}
        skill.forEach {
            arr[it[1]][it[2]] += if (it[0] == 2) it[5] else it[5] * -1
            arr[it[3]+1][it[2]] += if (it[0] == 1) it[5] else it[5] * -1
            arr[it[1]][it[4]+1] += if (it[0] == 1) it[5] else it[5] * -1
            arr[it[3]+1][it[4]+1] += if (it[0] == 2) it[5] else it[5] * -1
        }
        for (i in 0 until arr.indices.last) {
            for (j in 0 until  arr[0].indices.last)
                arr[i][j+1] += arr[i][j]
        }

        for (i in 0 until arr.indices.last) {
            for (j in 0 until  arr[0].indices.last)
                arr[i+1][j] += arr[i][j]
        }

        for (i in board.indices) {
            for (j in board[0].indices) {
                board[i][j] += arr[i][j]
                if (board[i][j] > 0) {
                    answer++
                }
            }
        }

        return answer
    }
}