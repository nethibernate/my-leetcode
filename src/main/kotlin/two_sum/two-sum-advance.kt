package two_sum

/**
 * @author pangchong
 */

class SolutionAdvance {
	fun twoSum(nums: IntArray, target: Int): IntArray {
		var remain = 0
		val map = hashMapOf<Int, Int?>()
		nums.forEachIndexed { index, each ->
			remain = target - each
			map[remain]?.let {
				return intArrayOf(it, index)
			}
			map[each] = index
		}
		return intArrayOf()
	}
}