package three_sum

/**
 * @author pangchong
 */

class Solution {
	fun threeSum(nums: IntArray): List<List<Int>> {
		var remain = 0
		val set = mutableSetOf<String>()
		val list = mutableListOf<List<Int>>()
		for (i in 0 until nums.size - 2) {
			val target = 0 - nums[i]
			val map = hashMapOf<Int, Int?>()
			for (j in (i + 1) until nums.size) {
				remain = target - nums[j]
				map[remain]?.let {
					if (it != i && it != j) {
						val temp = listOf(nums[i], remain, nums[j])
						val str = temp.sorted().joinToString()
						if (set.add(str)) list.add(temp)
					}
				}
				map[nums[j]] = j
			}
		}
		return list
	}
}