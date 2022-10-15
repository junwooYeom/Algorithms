package backjoon

fun main() = with(System.`in`.bufferedReader()) {
    val x = readLine().toInt()
    val y = readLine().toInt()
    print(if (x > 0) {
        if (y > 0) {
            1
        } else {
            4
        }
    } else {
        if (y > 0) {
            2
        } else {
            3
        }
    })
}