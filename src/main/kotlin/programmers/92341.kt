package programmers

import kotlin.math.ceil

/**
 * [링크] https://school.programmers.co.kr/learn/courses/30/lessons/92341?language=kotlin
 */

fun main() {
    val solutionClass = Solution()
    val answer = solutionClass.solution(
        intArrayOf(
            180, 5000, 10, 600
        ), arrayOf(
            "05:34 5961 IN",
            "06:00 0000 IN",
            "06:34 0000 OUT",
            "07:59 5961 OUT",
            "07:59 0148 IN",
            "18:59 0000 IN",
            "19:09 0148 OUT",
            "22:59 5961 IN",
            "23:00 5961 OUT"
        )
    )
    answer.forEach {
        println(it)
    }
}

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val answer: HashMap<String, Int> = hashMapOf()
        val cars: HashMap<String, Int> = hashMapOf()

        records.forEach {
            val carInfo = it.split(" ")
            val timeStamp = (carInfo[0].split(":")[0].toInt() * 60 + carInfo[0].split(":")[1].toInt())

            if (carInfo[2] == "IN") {
                cars[carInfo[1]] = timeStamp
            } else {
                val prev = cars.remove(carInfo[1])
                prev?.let { prevTimeStamp ->
                    answer[carInfo[1]] = answer.getOrDefault(carInfo[1], 0) + (timeStamp - prevTimeStamp)
                }
            }
        }
        cars.forEach {
            answer[it.key] = answer.getOrDefault(it.key, 0) + (1439 - it.value)
        }

        return answer.toSortedMap().values.map {
            if (it - fees[0] <= 0) fees[1] else fees[1] +  ceil((it - fees[0]).toFloat() / fees[2].toDouble()).toInt() * fees[3]
        }.toIntArray()
    }
}


