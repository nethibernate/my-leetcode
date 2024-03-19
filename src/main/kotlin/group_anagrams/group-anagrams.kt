package group_anagrams

/**
 * @auther pangchong
 */

class Solution {
	fun groupAnagrams(strs: Array<String>): List<List<String>> {
		if(strs.isEmpty()) return listOf()
		if(strs.size == 1) return listOf(listOf(strs[0]))
		
		val map = hashMapOf<String, MutableList<String>>()
		strs.forEach {
			val chars = it.toCharArray()
			chars.sort()
			val sortedString = chars.concatToString()
			var list = map[sortedString]
			if(list == null){
				list = mutableListOf()
				map[sortedString] = list
			}
			list.add(it)
		}
		
		return map.values.toList()
	}
}