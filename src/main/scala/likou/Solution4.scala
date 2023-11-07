package likou

/**
 * @author: BYDylan
 * @date: 2023/11/11
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2. 请你找出并返回这两个正序数组的 中位数 . 算法的时间复杂度应该为 O(log (m+n)).
 *               示例 1：
 *               输入：nums1 = [1,3], nums2 = [2]
 *               输出：2.00000
 *               解释：合并数组 = [1,2,3] ,中位数 2
 *
 *               示例 2： 输入：nums1 = [1,2], nums2 = [3,4]
 *               输出：2.50000
 *               解释：合并数组 = [1,2,3,4] ,中位数 (2 + 3) / 2 = 2.5
 *               解法:
 *               https://leetcode.cn/problems/median-of-two-sorted-arrays/solutions/600394/duo-tu-xiang-jie-liang-chong-shi-xian-by-75f4/
 */
object Solution {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1)
    }
    var m = nums1.length
    var n = nums2.length
    var begin = 0
    var end = m
    // 左半部分的最大值
    var left_max = -9999999999.0
    // 右半部分的最小值
    var right_min = 9999999999.0
    while (begin <= end) {
      // 基于二分的方式求 i
      var i = begin + (end - begin) / 2
      // 数组A长度为m，数组B长度n，总长度为偶数时，左半部分右半部分相等：
      // m - i + n - j = i + j
      // 总长度为奇数时，左半部分比右半部分多1个：
      // m - i + n - j + 1 = i + j
      // 统一奇数、偶数情况，得到j为：(m + n + 1) / 2 - i
      var j = (n + m + 1) / 2 - i
      // 如果nums1[i - 1] > nums2[j]说明 i 取大了
      if (i > 0 && j < n && nums1(i - 1) > nums2(j)) {
        end = i - 1
      }
      // nums2[j - 1] > nums1[i]，i 取小了
      else if (j > 0 && i < m && nums2(j - 1) > nums1(i)) {
        begin = i + 1
      }
      // 满足条件：nums1[i - 1] < nums2[j]，nums2[j - 1] < nums1[i]
      else {
        // 边界情况，数组A切分后左半部分为空 i == 0
        // 数组B 切分后左半部分为空 j == 0
        if (i == 0) {
          left_max = nums2(j - 1)
        }
        else if (j == 0) {
          left_max = nums1(i - 1)
        }
        // 求左半部分的最大值
        else {
          left_max = Math.max(nums1(i - 1), nums2(j - 1))
        }
        // 总长度为奇数时，直接返回左半部分最大值即可
        if ((n + m) % 2 == 1) {
          return left_max / 1.0
        }
        // 边界情况，数组A 切分后，右半部分为空 i == m
        // 数组B 切分后，右半部分为空 j == n
        if (i == m) {
          right_min = nums2(j)
        }
        else if (j == n) {
          right_min = nums1(i)
        }
        // 求右半部分的最小值
        else {
          right_min = Math.min(nums1(i), nums2(j))
        }
        // 总长度为偶数时
        return (left_max + right_min) / 2.0
      }
    }
    return 0.0
  }
}