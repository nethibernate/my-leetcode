package trapping_rain_water

/**
 * @author pangchong
 */

class Solution {
	fun trap(height: IntArray): Int {
		if (height.size == 3) {
			if (height[0] > height[1] && height[1] < height[2]) {
				val l = if (height[0] > height[2]) height[2] else height[0]
				return l - height[1]
			}
		}
		var sum = 0
		var firstNotZero = true
		var left = 0
		while (left < height.size) {
			if (firstNotZero && height[left] == 0) {
				left++
				continue
			}
			firstNotZero = false
			var right = left + 1
			var handle = false
			while (right < height.size) {
				if (height[right] < height[left]) {
					right++
					continue
				}
				
				var area = height[left] * (right - left - 1)
				for (i in (left + 1) until right) {
					area -= height[i]
				}
				sum += area
				left = right
				handle = true
				break
			}
			if (!handle) {
				if (left == height.size - 3) {
					if (height[left] > height[left + 1] && height[left + 1] < height[left + 2]) {
						val l = if (height[left] > height[left + 2]) height[left + 2] else height[left]
						sum += (l - height[left + 1])
					}
					break
				} else {
					left++
				}
			}
		}
		return sum
	}
}