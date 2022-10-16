package backjoon

fun main() = with(System.`in`.bufferedReader()) {
    val count = readLine().toInt()
    for (i in 1..count) {
        for (j in 1..i) {
            print("*")
        }
        println()
    }
}