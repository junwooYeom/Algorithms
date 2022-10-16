package backjoon

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val token = StringTokenizer(readLine(), " ")
    var hour = token.nextToken().toInt()
    var minute = token.nextToken().toInt()

    minute -= 45
    if (minute < 0) {
        hour -= 1
        minute += 60
    }
    if (hour < 0) {
        hour += 24
    }
    print("$hour $minute")
}