package programmers

/**
 * [92342] https://school.programmers.co.kr/learn/courses/30/lessons/92342
 */
class `92342` {
    private val combinationList: MutableList<List<Int>> = mutableListOf()
    fun solution(n: Int, info: IntArray): IntArray {
        var answer: IntArray = intArrayOf(-1)
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        makeOverlabCombination(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),IntArray(n), 0, 0)
        combinationList.forEach {
            var sum_score = 0
            var apeach = 0
            var lion = 0
            val info_lion = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
            it.forEach { count ->
                info_lion[10 - count] += 1
            }
            for (i in info.indices) {
                sum_score += info_lion[i] * (10 - i)
                when {
                    info[i] == 0 && info_lion[i] == 0 -> Unit
                    info[i] >= info_lion[i] -> apeach += (10 - i)
                    else -> lion += (10-i)
                }
            }
            if (lion > apeach) {
                val difference = lion - apeach
                if ((difference == max && min > sum_score) || difference > max){
                    max = difference
                    min = sum_score
                    answer = info_lion
                }
            }
        }
        return answer
    }


    private fun makeOverlabCombination(arrayList: IntArray, temp: IntArray, current: Int, start: Int) {
        if (current == temp.size) {
            combinationList.add(temp.toList())
            return
        } else {
            for (i in start until arrayList.size) {
                temp[current] = arrayList[i]
                makeOverlabCombination(arrayList, temp, current + 1, i)
            }
        }
    }
}

