package backjoon

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val token = StringTokenizer(readLine(), " ")
    val first = token.nextToken().toInt()
    val second = token.nextToken().toInt()
    print(when {
        first > second -> ">"
        first < second -> "<"
        else -> "=="
    })
}