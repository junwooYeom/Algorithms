package backjoon

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val price = readLine().toInt()
    val count = readLine().toInt()
    var total = 0
    for (i in 0 until count) {
        val token = StringTokenizer(readLine(), " ")
        total += token.nextToken().toInt() * token.nextToken().toInt()
    }
    print(if (price == total) "Yes" else "No")
}