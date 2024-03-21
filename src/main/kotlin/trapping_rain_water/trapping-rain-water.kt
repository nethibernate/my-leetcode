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
				var i = height.lastIndex
				while (i > left) {
					if (height[i] <= height[i - 1]) {
						i--
						continue
					}
					
					var innerHandle = false
					var j = i - 1
					while (j >= left) {
						if (height[j] < height[i]) {
							j--
							continue
						}
						var area = height[i] * (i - j - 1)
						for (m in (i - 1) downTo (j + 1)) {
							area -= height[m]
						}
						sum += area
						i = j
						innerHandle = true
						break
					}
					if (!innerHandle) break
				}
				break
			}
		}
		return sum
	}
}