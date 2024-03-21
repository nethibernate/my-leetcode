package three_sum

/**
 * @author pangchong
 */

class SolutionAdvance {
	fun threeSum(nums: IntArray): List<List<Int>> {
		var remain = 0
		val list = mutableListOf<List<Int>>()
		nums.sort()
		nums.forEachIndexed { index, each ->
			if (index > 0 && nums[index - 1] == each) return@forEachIndexed
			
			val target = -each
			var right = nums.lastIndex
			for (left in (index + 1) until nums.size) {
				if (left > index + 1 && nums[left] == nums[left - 1]) continue
				while (right > left && nums[left] + nums[right] > target) right--
				if (left == right) break
				if (nums[left] + nums[right] == target) list.add(listOf(each, nums[left], nums[right]))
			}
		}
		return list
	}
}