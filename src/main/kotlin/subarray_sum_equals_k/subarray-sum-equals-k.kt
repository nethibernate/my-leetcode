package subarray_sum_equals_k

/**
 * @auther pangchong
 */

class Solution {
	fun subarraySum(nums: IntArray, k: Int): Int {
		var result = 0
		var left = 0
		var right = 0
		var sum = 0
		
		while (left < nums.size && right < nums.size) {
			if (sum + nums[right] == k) {
				sum += nums[right]
				result++
				right++
				sum -= nums[left]
				left++
			} else if (sum + nums[right] > k) {
				if (left == right) {
					sum += nums[right]
					right++
				} else {
					sum -= nums[left]
					left++
				}
			} else {
				if (nums[left] < 0 && left < right) {
					sum -= nums[left]
					left++
				} else {
					sum += nums[right]
					right++
				}
			}
		}
		return result
	}
}