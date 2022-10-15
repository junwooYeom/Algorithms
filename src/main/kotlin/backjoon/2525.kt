package backjoon

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val time = StringTokenizer(readLine(), " ")
    var hour = time.nextToken().toInt()
    var minute = time.nextToken().toInt()
    val during = readLine().toInt()
    hour += during / 60
    minute += during % 60
    if (minute >= 60) {
        hour += 1
        minute -= 60
    }
    print("${hour % 24} $minute")
}