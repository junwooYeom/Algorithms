package backjoon

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val count = readLine().toInt()
    for (i in 1 .. count) {
        val token = StringTokenizer(readLine(), " ")
        println("Case #$i: ${token.nextToken().toInt() + token.nextToken().toInt()}")
    }
}