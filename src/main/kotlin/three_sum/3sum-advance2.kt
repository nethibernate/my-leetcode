package three_sum

/**
 * @author pangchong
 */

class SolutionAdvance2 {
	fun threeSum(nums: IntArray): List<List<Int>> {
		var remain = 0
		val list = mutableListOf<List<Int>>()
		nums.sort()
		nums.forEachIndexed { index, each ->
			if (index > 0 && nums[index - 1] == each) return@forEachIndexed
			
			val target = -each
			var left = index + 1
			var right = nums.lastIndex
			while (left < right) {
				if (left > index + 1 && nums[left] == nums[left - 1]) {
					left++
					continue
				}
				
				val sum = each + nums[left] + nums[right]
				if (sum < 0) left++
				else if (sum > 0) right--
				else {
					list.add(listOf(each, nums[left], nums[right]))
					left++
					right--
				}
			}
		}
		return list
	}
}