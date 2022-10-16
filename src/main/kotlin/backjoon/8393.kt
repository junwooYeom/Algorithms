package backjoon

fun main() = with(System.`in`.bufferedReader()) {
    val item = readLine().toInt()
    var answer = 0
    for (i in 1..item) {
        answer += i
    }
    print(answer)
}