package move_zeroes

/**
 * @auther pangchong
 */

class Solution {
	fun moveZeroes(nums: IntArray): Unit {
		var zeroIndex = 0
		nums.forEachIndexed { index, each ->
			if (each != 0) {
				val tmp = nums[zeroIndex]
				nums[zeroIndex] = each
				nums[index] = tmp
				zeroIndex++
			}
		}
	}
}