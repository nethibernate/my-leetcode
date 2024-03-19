package longest_consecutive_sequence

/**
 * @auther pangchong
 */

class Solution {
	fun longestConsecutive(nums: IntArray): Int {
		val map = hashMapOf<Int, IntArray?>()
		var max = 0
		nums.forEach {
			val pre = it - 1
			val next = it + 1
			val preCount = map[pre]
			val nextCount = map[next]
			if (preCount != null && nextCount != null) {
				val keepCount = if (preCount[0] >= nextCount[0]) {
					preCount[0] += (1 + nextCount[0])
					preCount
				} else {
					nextCount[0] += (1 + preCount[0])
					nextCount
				}
				map[pre] = keepCount
				map[next] = keepCount
				map[it] = keepCount
			}
		}
	}
}