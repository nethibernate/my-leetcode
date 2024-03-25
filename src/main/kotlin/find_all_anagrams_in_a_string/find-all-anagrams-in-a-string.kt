package find_all_anagrams_in_a_string

/**
 * @auther pangchong
 */

class Solution {
	fun findAnagrams(s: String, p: String): List<Int> {
		val list = mutableListOf<Int>()
		val comp = p.toSortedString()
		var left = 0
		var right = left + p.length - 1
		while (left < s.length && right < s.length) {
			val temp = s.substring(left..right).toSortedString()
			if (temp == comp) list.add(left)
			left++
			right++
		}
		return list
	}
	
	fun String.toSortedString(): String {
		val chars = this.toCharArray()
		chars.sort()
		return chars.concatToString()
	}
}