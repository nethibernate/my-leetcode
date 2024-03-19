package two_sum

/**
 * @author pangchong
 */

class Solution {
	fun twoSum(nums: IntArray, target: Int): IntArray {
		val result = IntArray(2)
		for(i in 0 until nums.size - 1){
			val n = nums[i]
			for(j in i + 1 until nums.size){
				if(n + nums[j] == target){
					result[0] = i
					result[1] = j
					return result
				}
			}
		}
		return result
	}
}