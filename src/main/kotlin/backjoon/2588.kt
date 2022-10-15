package backjoon

fun main() = with(System.`in`.bufferedReader()) {
    val standard = readLine().toInt()
    val purpose = readLine()
    print("${standard * purpose[2].digitToInt()}\n${standard * purpose[1].digitToInt()}\n${standard * purpose[0].digitToInt()}\n${standard * purpose.toInt()}")
}