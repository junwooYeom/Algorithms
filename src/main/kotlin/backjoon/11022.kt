package backjoon

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val count = readLine().toInt()
    for (i in 1 .. count) {
        val token = StringTokenizer(readLine(), " ")
        val first = token.nextToken().toInt()
        val second = token.nextToken().toInt()
        println("Case #$i: $first + $second = ${first + second}")
    }
}