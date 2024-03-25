package longest_substring_without_repeating_characters

import kotlin.math.max
import kotlin.math.min

/**
 * @auther pangchong
 */
class SolutionAdvance {
	fun lengthOfLongestSubstring(s: String): Int {
		if (s.isEmpty()) return 0
		var result = 0
		var currentLen = 0
		val map = mutableMapOf<Char, Int>()
		
		s.forEachIndexed { index, char ->
			if (map.contains(char)) {
				currentLen = min(currentLen + 1, index - map[char]!!)
			} else {
				currentLen++
			}
			map[char] = index
			result = max(result, currentLen)
		}
		
		return result
	}
}