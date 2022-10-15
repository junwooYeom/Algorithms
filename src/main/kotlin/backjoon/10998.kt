package backjoon

import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/10998
 */

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine(), " ")
    print(st.nextToken().toInt() * st.nextToken().toInt())
}