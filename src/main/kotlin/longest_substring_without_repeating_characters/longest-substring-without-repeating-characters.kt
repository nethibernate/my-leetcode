package longest_substring_without_repeating_characters

import kotlin.math.max

/**
 * @auther pangchong
 */

class Solution {
	fun lengthOfLongestSubstring(s: String): Int {
		if (s.isEmpty()) return 0
		val charArray = s.toCharArray()
		
		var result = 1
		var set = mutableSetOf(charArray[0])
		var left = 0
		var right = 1
		
		while (right < charArray.size) {
			val char = charArray[right]
			while (!set.add(char)) {
				//有字母重复了
				set.remove(charArray[left])
				left++
			}
			right++
			result = max(set.size, result)
		}
		
		return result
	}
}