package programmers

import kotlin.math.ceil

/**
 * [92341] https://school.programmers.co.kr/learn/courses/30/lessons/92341?language=kotlin
 */
class `92341` {
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


