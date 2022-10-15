package backjoon

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val token = StringTokenizer(readLine(), " ")
    val king = token.nextToken().toInt()
    val queen = token.nextToken().toInt()
    val rook = token.nextToken().toInt()
    val bishop = token.nextToken().toInt()
    val knight = token.nextToken().toInt()
    val pawn = token.nextToken().toInt()
    print("${1 - king} ${1 - queen} ${2 - rook} ${2 - bishop} ${2 - knight} ${8 - pawn}")
}