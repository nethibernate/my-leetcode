package longest_consecutive_sequence

/**
 * 尝试解读一下： 当新读入一个数n，如果没有左右相邻的数，经过该数的队列长度为1。
 * 如果找到左邻数l，则m中l对应的长度为left，其代表的队列是[...,...,l]而不是[...,l,n,...]。
 * 假设是第二种，那么必然之前读了一个n，那么该n就应该省略了。如果找到右邻数r，
 * 同理，代表的队列是[r,...,...]而不是[...,r,...]。
 *
 * len=left+right+1
 
 * 如果l或r只找到一个，以l为例，则right=0，n作为补充加入左队列[...,l,n]，这样，m[n]的长度
 * 就是left的长度+1即m[n+right]=len，n也会变成后边某个数的左邻数，如果l左边有数字[...,l,n]，
 * 则其永远不会被搜索到了，因为n=l+1已经处理过了，不会再处理了，对应m[l]不用更新，但是队列
 * 最左端的数字可以作为未来某个数的右邻数，所以其长度需要更新为m[n−left]=left+1=len;如果左边
 * 没有数字[l,n]即left=1，则l仍可以作为某个数的右邻数被处理，也是需要更新的，m[n−left]=m[n−1]=left+1=len。
 *
 * 如果左右都找到了，那么经过n的长度应该是len，队列变为[...l,n,r,...],n不会再被处理了，不更新也可以。
 * 但是左队列的左端和右队列的右端需要更新，也就是m[n−left]=m[n+right]=len
 *
 * @auther pangchong
 */

class Solution {
	fun longestConsecutive(nums: IntArray): Int {
		val map = hashMapOf<Int, Int>()
		var max = 0
		nums.forEach {
			if (map.contains(it)) return@forEach
			val left = map[it - 1] ?: 0
			val right = map[it + 1] ?: 0
			val len = left + right + 1
			map[it] = 1
			map[it - left] = len
			map[it + right] = len
			max = if (max > len) max else len
		}
		return max
	}
}