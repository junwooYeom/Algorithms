package backjoon

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val out = System.out.bufferedWriter()
    val count = readLine().toInt()
    for (i in 1 .. count) {
        val token = StringTokenizer(readLine(), " ")
        out.write("${token.nextToken().toInt() + token.nextToken().toInt()}\n")
    }
    out.flush()
}