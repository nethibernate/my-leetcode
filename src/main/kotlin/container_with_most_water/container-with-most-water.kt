package container_with_most_water

/**
 * @auther pangchong
 */

class Solution {
	fun maxArea(height: IntArray): Int {
		var result = 0
		
		var left = 0
		var right = height.lastIndex
		
		while (left < right) {
			val leftValue = height[left]
			val rightValue = height[right]
			
			if (leftValue < rightValue) {
				val area = leftValue * (right - left)
				if (area > result) result = area
				left++
			} else if (leftValue > rightValue) {
				val area = rightValue * (right - left)
				if (area > result) result = area
				right--
			} else {
				val area = rightValue * (right - left)
				if (area > result) result = area
				right--
				left++
			}
		}
		return result
	}
}