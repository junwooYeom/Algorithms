package backjoon

/**
 * https://www.acmicpc.net/problem/9498
 */
fun main() = with(System.`in`.bufferedReader()) {
    val grade= when (readLine().toInt()) {
        in 90..100 -> "A"
        in 80 until 90 -> "B"
        in 70 until 80 -> "C"
        in 60 until 70 -> "D"
        else -> "F"
    }
    print(grade)
}