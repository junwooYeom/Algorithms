package backjoon

fun main() = with(System.`in`.bufferedReader()) {
    val item = readLine().toInt()
    for (i in 1 .. 9) {
        println("$item * $i = ${item * i}")
    }
}