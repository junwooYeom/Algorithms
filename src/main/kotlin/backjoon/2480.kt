package backjoon

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val token = StringTokenizer(readLine(), " ")
    val first = token.nextToken().toInt()
    val second = token.nextToken().toInt()
    val third = token.nextToken().toInt()

    when {
        first == second && second == third -> print(10000 + first * 1000)
        first == second -> print(1000 + first * 100)
        second == third -> print(1000 + second * 100)
        first == third -> print(1000 + first * 100)
        else -> {
            val max = when {
                first >= second && first >= third -> first
                second >= first && second >= third -> second
                else -> third
            }
            print(max * 100)
        }
    }
}